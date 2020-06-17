package com.booksystem.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booksystem.bean.Book;
import com.booksystem.dao.DS;

@WebServlet("/pass")
public class Pass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookid = request.getParameter("bookid");
		String pid = request.getParameter("pid");
		String sql = "delete b_p where book_id = "+bookid+" and person_id = "+pid+"";
		DS.query(sql);
		String sqlBook = "select * from book where id = "+bookid;
		Book book = DS.query(sqlBook,Book.class).get(0);
		book.setNum(book.getNum()+1);
		DS.delelte(book.getId(), Book.class);
		DS.save(book);
		response.sendRedirect("check");
	}
}
