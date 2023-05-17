package com.zhenghou.servlet;

import com.zhenghou.dao.BaseDao;
import com.zhenghou.entity.user;
import com.zhenghou.service.Impl.UserServiceImpl;
import com.zhenghou.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收页面传入的值
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        System.out.println(id);
        System.out.println(name);
        System.out.println(password);
        System.out.println(email);

//        BaseDao baseDao=new BaseDao();
//        String sql="insert into user (id,name,password,email) values (?,?,?,?)";
//        baseDao.executeUpdate(sql,id,name,password,email);
        user u=new user();
        u.setId(Integer.valueOf(id));
        u.setName(name);
        u.setPassword(password);
        u.setEmail(email);

        UserService userService=new UserServiceImpl();
        userService.addUser(u);

        //重定向
        //response.sendRedirect("user.jsp");

        //以ajax方式
        response.getWriter().write("true");

    }
}
