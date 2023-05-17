package com.zhenghou.listener;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener{

    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("创建session");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("销毁session");
        HttpSession httpSession = se.getSession();
        ServletContext application = httpSession.getServletContext();
        Object countObj = application.getAttribute("onlineCount");
        int count=(Integer)countObj-1;
        application.setAttribute("onlineCount",count);
    }
}
