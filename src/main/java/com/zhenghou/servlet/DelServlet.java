package com.zhenghou.servlet;

import com.zhenghou.dao.BaseDao;
import com.zhenghou.service.Impl.UserServiceImpl;
import com.zhenghou.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

//        String sql="delete from user where id=?";
//        BaseDao baseDao=new BaseDao();
//        int i = baseDao.executeUpdate(sql, id);
//        System.out.println(i);
        UserService userService=new UserServiceImpl();
        userService.delUser(Integer.valueOf(id));

        response.sendRedirect("user.jsp");
    }
}
