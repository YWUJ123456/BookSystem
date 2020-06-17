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

import com.booksystem.bean.Book;
import com.booksystem.bean.Bp;
import com.booksystem.dao.DS;

@WebServlet("/check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sql = "select * from b_p where state = 2";
		List<Bp> bp = DS.query(sql, Bp.class);
		if(bp==null) {
			response.sendRedirect("toadmin");
			return;
		}
		Map<Book, Integer> map = new HashMap<>();
		for (Bp b : bp) {
			String sqlBook = "select * from book where id = "+b.getBook_id();
			Book book = DS.query(sqlBook, Book.class).get(0);
			map.put(book, b.getPerson_id());
		}
		request.setAttribute("map", map);
		request.getRequestDispatcher("check.jsp").forward(request, response);
	}
}
