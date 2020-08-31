package com.dev.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.DaoImpl;
import com.dev.entity.Book;


public class SearchBook extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	private DaoImpl dao = new DaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	response.setContentType("text/html");
	Book b = dao.searchBook(Integer.parseInt(request.getParameter("getbookId")));
	if(b!=null) {
		out.println("Book Id : "+b.getBookId());
		out.print("<br>");
		out.println("Book Name : "+b.getBookName());
		out.print("<br>");
		out.println("Author of Book : "+b.getAuthor());
		out.print("<br>");
		out.println("Publisher of Book : "+b.getPublisher());
	}
	else 
	{
		out.println("please enter valid bookid");
	}
}
}
