package com.njtc.njvolunteer.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("user");
        if (loginUser == null) {
            request.setAttribute("msg", "请登录账号后再访问！");
            request.getRequestDispatcher("/showLogin").forward(request, response);
            return false;
        }
        return true;
    }
}
