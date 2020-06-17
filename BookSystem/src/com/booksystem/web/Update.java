package com.booksystem.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booksystem.bean.Book;
import com.booksystem.dao.DS;

@WebServlet("/upd")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("id"));
		int id = Integer.parseInt(request.getParameter("id"));
		String sql = "select * from book where id ="+id+"";
		List<Book> list = DS.query(sql, Book.class);
		Book book = list.get(0);
		request.setAttribute("book", book);
		request.getRequestDispatcher("souBook.jsp").forward(request, response);
	}
}
