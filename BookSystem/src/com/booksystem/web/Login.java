package com.booksystem.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.booksystem.bean.Book;
import com.booksystem.bean.Person;
import com.booksystem.dao.DS;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String loginRole = request.getParameter("role");
		String auto = request.getParameter("auto");
		String sql = "select * from person where name='"+username+"' and password = '"+password+"'";
		List<Person> list = DS.query(sql, Person.class);
		if(list!=null&&list.size()>0) {//登录成功
			HttpSession session = request.getSession();
			Person person = list.get(0);
			session.setAttribute("person",person);
			Integer role = person.getRole();
			String sqlBook = "select * from book order by id";
			List<Book> listBook = DS.query(sqlBook, Book.class);
			request.setAttribute("list", listBook);
//			if("autoLogin".equals(auto)){
//				Cookie cUsername = new Cookie("username", username);
//				Cookie cPassword = new Cookie("password", password);
//				response.addCookie(cUsername);
//				response.addCookie(cPassword);
//			}
			if(role==1&&"1".equals(loginRole)) {
				request.getRequestDispatcher("toadmin").forward(request, response);
				return;
			}else {
				request.getRequestDispatcher("toindex").forward(request, response);
				return;
			}
			
		}else {
			request.setAttribute("msg", "用户名或密码错误!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
	}
}
