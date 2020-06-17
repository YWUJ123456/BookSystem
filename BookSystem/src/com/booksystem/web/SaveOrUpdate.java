package com.booksystem.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.booksystem.bean.Book;
import com.booksystem.dao.DS;

@WebServlet("/sou")
@MultipartConfig
public class SaveOrUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String publish = request.getParameter("publish");
		Integer num = Integer.parseInt(request.getParameter("num"));
		String author = request.getParameter("author");
		//获取文件
		Part img = request.getPart("img");
		String fileName = UUID.randomUUID()+img.getSubmittedFileName();
//		img.write("E://img/"+fileName);//备份
		String realPath = request.getRealPath("/")+"img\\";
		img.write(realPath+fileName);
		
		Book book = new Book();
		book.setName(name);
		book.setDob(new Date());
		book.setNum(num);
		book.setPrice(price);
		book.setPublish(publish);
		book.setAuthor(author);
		book.setImg("img\\"+fileName);
		if("".equals(id)) {
			Random r = new Random();
			int d = r.nextInt(100000);
			book.setId(d);
			DS.save(book);
		}else {
			DS.delelte(id, Book.class);
			book.setId(Integer.parseInt(id));
			DS.save(book);
		}
		String sql = "select * from book order by id";
		List<Book> list = DS.query(sql, Book.class);
		request.setAttribute("list", list);
		response.sendRedirect("toadmin");
	}
}
