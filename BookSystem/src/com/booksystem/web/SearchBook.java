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
import com.booksystem.util.SimplePage;

@WebServlet("/search")
public class SearchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNo = request.getParameter("pageNo")==null?1:Integer.parseInt(request.getParameter("pageNo"));
		String name = request.getParameter("name");
		String publish = request.getParameter("publish");
		String author = request.getParameter("author");
		String sql = "select * from book where name like '%"+name+"%' and publish like '%"+publish+"%' and author like '%"+author+"%' order by id";
		List<Book> list = DS.query(sql,Book.class);
//		request.setAttribute("list", list);
		SimplePage<Book> simplePage = new SimplePage<>();	
		simplePage.setPage(8);
		simplePage.setPageNo(pageNo);
		simplePage.setAll(list);
		request.setAttribute("simplePage", simplePage);
		request.getRequestDispatcher("adminIndex.jsp").forward(request, response);
	}
}
