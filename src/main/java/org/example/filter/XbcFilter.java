package org.example.filter;

import jakarta.servlet.*;

import java.io.IOException;
//@WebFilter(urlPatterns = "/*")
public class XbcFilter implements Filter {

    @Override//拦截请求后调用，调用多次
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        System.out.println("拦截了");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

}
