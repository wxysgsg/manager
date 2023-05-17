package com.zhenghou.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginSessionFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化方法");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest)servletRequest;
        HttpServletResponse response= (HttpServletResponse)servletResponse;
        //获取url
        String url = request.getRequestURL().toString();
        if(url.indexOf(".jsp")!=-1){
            if(url.indexOf("login.jsp")!=-1){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }else {
                //否则 登陆验证，跳到登录界面
                HttpSession session = request.getSession();
                Object userObj =    session.getAttribute("currentuser");
                if(userObj==null){
                    response.sendRedirect("login.jsp");
                    return;
                }
            }
        }
        if(url.indexOf(".do")!=-1){
            if(url.indexOf("login.do")!=-1){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }else {
                //否则 登陆验证，跳到登录界面
                HttpSession session = request.getSession();
                Object userObj =    session.getAttribute("currentuser");
                if(userObj==null){
                    response.sendRedirect("login.jsp");
                    return;
                }
            }
        }
        //放行,报404错误
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {
        System.out.println("销毁方法");
    }
}
