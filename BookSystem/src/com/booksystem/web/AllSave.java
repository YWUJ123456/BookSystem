package com.booksystem.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.booksystem.bean.Book;
import com.booksystem.dao.DS;

@WebServlet("/allSave")
@MultipartConfig
public class AllSave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part myfile = request.getPart("myfile");
		InputStream in = myfile.getInputStream();
		HSSFWorkbook work = new HSSFWorkbook(in);
		HSSFSheet sheet = work.getSheetAt(0);
		int rowLength = sheet.getLastRowNum();
		for(int i=1;i<rowLength;i++) {
			HSSFRow row = sheet.getRow(i);
			Book book = new Book();
			book.setId((int)(Double.parseDouble(row.getCell(0).toString())));
			book.setName(row.getCell(1).toString());
			book.setPrice((int)(Double.parseDouble(row.getCell(2).toString())));
			book.setNum((int)(Double.parseDouble(row.getCell(3).toString())));
			book.setAuthor(row.getCell(4).toString());
			book.setImg(row.getCell(5).toString());
			book.setPublish(row.getCell(6).toString());	
			book.setDob(new Date());
			System.out.println("批量导入的book:"+book);
			DS.save(book);
		}
//		String sql = "select * from book order by id";
//		List<Book> list = DS.query(sql, Book.class);
//		request.setAttribute("list", list);
		response.sendRedirect("toadmin");
	}
}
