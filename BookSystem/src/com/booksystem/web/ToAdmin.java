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

@WebServlet("/toadmin")
public class ToAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNo = request.getParameter("pageNo")==null?1:Integer.parseInt(request.getParameter("pageNo"));
		String sql = "select * from book order by id";
		List<Book> listBook = DS.query(sql,Book.class);
//		request.setAttribute("list", listBook);
		
		SimplePage<Book> simplePage = new SimplePage<>();	
		simplePage.setPage(8);
		simplePage.setPageNo(pageNo);
		simplePage.setAll(listBook);
		request.setAttribute("simplePage", simplePage);
		
		request.getRequestDispatcher("adminIndex.jsp").forward(request, response);
	}
}
