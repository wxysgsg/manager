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

public class UpdServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        user u=new user();
        u.setId(Integer.valueOf(id));
        u.setName(name);
        u.setPassword(password);
        u.setEmail(email);

        UserService userService=new UserServiceImpl();
        userService.updUser1(u);

//        String sql="update user set name=?,password=?,email=? where id=?";
//        BaseDao baseDao=new BaseDao();
//        baseDao.executeUpdate(sql,name,password,email,id);
        //修改成功，跳到userservlet
        response.sendRedirect("userAction.do");
    }
}
