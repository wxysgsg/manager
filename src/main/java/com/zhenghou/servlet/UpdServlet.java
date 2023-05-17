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

public class UpdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询action
        String id = request.getParameter("id");

        UserService userService=new UserServiceImpl();
        user user = userService.updUser(Integer.valueOf(id));

        HttpSession session = request.getSession();
        session.setAttribute("user",user);

        response.sendRedirect("upduser.jsp");

    }
}
