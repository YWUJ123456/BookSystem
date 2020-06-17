package com.booksystem.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.booksystem.bean.Book;
import com.booksystem.bean.Person;
import com.booksystem.dao.DS;

@WebServlet("/borrow")
public class Borrow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		Person p = (Person)session.getAttribute("person");
		String sql = "insert into b_p(book_id,person_id,state) values("+id+","+p.getId()+",1)";
		DS.query(sql);
		//更新书的数量
		String sqlBook = "select * from book where id = "+id;
		Book book = DS.query(sqlBook,Book.class).get(0);
		DS.delelte(book.getId(), Book.class);
		book.setNum(book.getNum()-1);
		DS.save(book);
		response.sendRedirect("toindex");
	}
}
