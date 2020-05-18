package com.cqeec.vote.filer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/filter/*")
public class loginfiler implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp= (HttpServletResponse) servletResponse;
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpSession session=req.getSession();
        if(session.getAttribute("email")==null){
    resp.sendRedirect("/1.html");
        }else{
    filterChain.doFilter(req,resp);
        }
    }

    @Override
    public void destroy() {

    }
}
