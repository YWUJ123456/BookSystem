package com.booksystem.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.booksystem.bean.Person;
import com.booksystem.dao.DS;

@WebServlet("/repay")
public class RepayBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		Person p = (Person) session.getAttribute("person");
		String sql = "update b_p set state = 2 where book_id = " + id + " and person_id =" + p.getId();
		DS.query(sql);
		response.sendRedirect("showBorrow");
	}
}
