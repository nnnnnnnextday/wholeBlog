package com.example.theblogcx.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginInterceptor implements HandlerInterceptor {

    //Socket socket = new Socker();
    //ServerSocket a = new Ser;
    //重写预处理方法，通过Request.getSession，判断其中是否有User数据,即可。
    //并且通过WebConfig里面的配置器来重写关于控制器过滤的设置
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/admin");
            return false;
        }
        return true;
    }
}
