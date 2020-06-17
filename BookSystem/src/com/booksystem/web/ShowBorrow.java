package com.booksystem.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.booksystem.bean.Book;
import com.booksystem.bean.Bp;
import com.booksystem.bean.Person;
import com.booksystem.dao.DS;

@WebServlet("/showBorrow")
public class ShowBorrow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Person p = (Person)session.getAttribute("person");
		String sql = "select * from b_p where person_id = "+p.getId();
		List<Bp> list = DS.query(sql,Bp.class);
		Map<Book,Integer> map = new HashMap<>();
		for (Bp bp : list) {
			String sqlBook = "select * from book where id ="+bp.getBook_id();
			Book book = DS.query(sqlBook, Book.class).get(0);
			map.put(book, bp.getState());
		}
		request.setAttribute("map", map);
		request.getRequestDispatcher("borrow.jsp").forward(request, response);
	}
}
