package com.zhenghou.servlet;

import com.zhenghou.dao.BaseDao;
import com.zhenghou.entity.user;
import com.zhenghou.service.Impl.UserServiceImpl;
import com.zhenghou.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取页面
        String currentPageStr =request.getParameter("currentPage");
        int currentPage=1;
        if(currentPageStr!=null&&!"".equals(currentPageStr)){
            currentPage=Integer.valueOf(currentPageStr);
            if(currentPage<=0){
                currentPage=1;
            }
        }

        int pageSize=3;
//        int startRow=(currentPage-1)*pageSize;
//
//        BaseDao basedao=new BaseDao();
//        String sql="select * from user limit ?,?";
//        List<user> list= basedao.selectList(user.class,sql,startRow,pageSize);
        UserService userService=new UserServiceImpl();
        List<user> list = userService.getList(currentPage, pageSize);

//        String sql1="select count(1) from user";
//        //当前条数
//        int count = basedao.selectCount(sql1);
        int count = userService.getCount();
        //当前页数
        int totalPage=count%pageSize==0?count/pageSize:count/pageSize+1;

        HttpSession session = request.getSession();
        //设置对象
        session.setAttribute("list",list);
        //设置当前页
        session.setAttribute("currentPage",currentPage);
        //设置当前条数
        session.setAttribute("count",count);
        //设置当前页数
        session.setAttribute("totalPage",totalPage);
        response.sendRedirect("user.jsp");


    }
}
