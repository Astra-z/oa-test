package com.study.oa.global;

import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    public LoginInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url=httpServletRequest.getRequestURI();

        if(url.toLowerCase().indexOf("login")>=0) {
            return true;
        }
        else{
            if(httpServletRequest.getSession().getAttribute("employee")==null) {
                httpServletRequest.setAttribute("message","没有权限请先登录！");
                httpServletRequest.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(httpServletRequest, httpServletResponse);
            }
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
