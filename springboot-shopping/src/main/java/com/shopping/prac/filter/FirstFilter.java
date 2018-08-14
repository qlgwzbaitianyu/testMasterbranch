package com.shopping.prac.filter;
import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FirstFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("this is in First Filter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        
    }
}
