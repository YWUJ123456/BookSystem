package com.booksystem.web;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

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
import com.booksystem.util.SimplePage;

@WebServlet("/toindex")
public class ToIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNo = request.getParameter("pageNo")==null?1:Integer.parseInt(request.getParameter("pageNo"));
		String sql = "select * from book where num>0 order by id";
		List<Book> list = DS.query(sql, Book.class);
		SimplePage<Book> simplePage = new SimplePage<>();	
		simplePage.setPage(8);
		simplePage.setPageNo(pageNo);
		simplePage.setAll(list);
		request.setAttribute("simplePage", simplePage);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
