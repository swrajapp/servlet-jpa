package com.dev.dao;

import java.util.List;

import com.dev.entity.Book;
import com.dev.entity.Library;

public interface Dao {
	public void addBook(Book b);
	public Library getLibrary(String libraryName);
	public Book searchBook(int bookId);
	public void deleteBook(int bookId);
	public List<Book> getAllBooks();
	public Book updateBookInformation(int bookId,String bookName,String author,String publisher);
	
}
