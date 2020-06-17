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

@WebServlet("/del")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] ids = request.getParameterValues("id");
		System.out.println(ids.length);
		for (String id : ids) {
			DS.delelte(id, Book.class);
			
		}
//		String sql = "select * from book order by id";
//		List<Book> list = DS.query(sql, Book.class);
//		request.setAttribute("list", list);
		response.sendRedirect("toadmin");
	}
}
