package com.zhenghou.servlet;

import com.zhenghou.dao.BaseDao;
import com.zhenghou.entity.user;
import com.zhenghou.service.Impl.UserServiceImpl;
import com.zhenghou.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
/**
 * 对客户端请求做出响应
 * 1.继承HttpServlet
 * 2.重写doGet和doPost方法
 * 3.在web.xml中配置servlet和servlet-mapping
 * */
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    /**
     * 1.获取页面输入的参数
     * 2.操作数据库
     * 3.页面跳转
     * */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //所有的java代码
        //request获取表单提交的数据值
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        //对比用户名
//        String sql="select * from user where name=?";
//        BaseDao baseDao=new BaseDao();
//        user u = baseDao.selectOne(user.class, sql, name);
        UserService userService=new UserServiceImpl();
        user u = userService.getUser(name);

        if(u!=null){
            //说明有这个用户,然后对比密码
            if(u.getPassword().equals(password)){
                //在线用户+1
                ServletContext application = request.getServletContext();
                //把对象放到session小推车中
                HttpSession session = request.getSession();

                //单点登录
                Object onlineUserMapObj = application.getAttribute("onlineUserMap");
                if(onlineUserMapObj==null){
                    HashMap<String,HttpSession> onlineUserMap=new HashMap<String, HttpSession>();
                    onlineUserMap.put(u.getName(), session);
                    application.setAttribute("onlineUserMap",onlineUserMap);
                }else {
                    HashMap<String,HttpSession> onlineUserMapGu=(HashMap)onlineUserMapObj;
                    HttpSession oldSession = onlineUserMapGu.get(u.getName());
                    if(oldSession==null){
                        onlineUserMapGu.put(u.getName(),session);
                    }else {
                        if(oldSession!=session){
                            oldSession.invalidate();
                            System.out.println("成功挤掉");
                            onlineUserMapGu.put(u.getName(),session);
                        }else {
                            System.out.println("会话相同");
                            oldSession.invalidate();
                            System.out.println("成功挤掉");
                        }
                    }

                }

                Object onlineCount = application.getAttribute("onlineCount");
                if(onlineCount==null){
                    application.setAttribute("onlineCount",1);
                }else {
                    Integer count=(Integer) onlineCount+1;
                    application.setAttribute("onlineCount",count);
                }


                //以key，value的方式保存
                session.setAttribute("currentuser",u);
                response.sendRedirect("userAction.do");
                return;
            }
        }
        //forward转发方式
//        request.getRequestDispatcher("login.jsp").forward(request,response);
        //重定向方式
        response.sendRedirect("login.jsp");
    }
}
