package com.booksystem.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录验证
 * 
 * @author 杨武军
 *
 */
@WebFilter("/*")
public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpServletRequest req = (HttpServletRequest)request;
		String path = req.getServletPath();
		if(path.contains("login")) {
			chain.doFilter(request, response);
			return;
		}else {
			HttpSession session = req.getSession();
			Object person = session.getAttribute("person");
			if(person==null) {
				req.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}else {
				chain.doFilter(request, response);
				return;
			}
		}
	}

	@Override
	public void destroy() {
		
	}
	
}
