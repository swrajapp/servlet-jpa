package com.dev.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.dev.entity.Book;
import com.dev.entity.Library;



public abstract class DaoImpl implements Dao{
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Servlet");
	private static EntityManager entityManager= entityManagerFactory.createEntityManager();
	
	public void addBook(Book b) {
		entityManager.getTransaction().begin();
		
		entityManager.persist(b);
		
		entityManager.getTransaction();
		((EntityTransaction) entityManager).commit();
		
	}
	
	public Library getLibrary(String libraryName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createQuery("SELECT * FROM Library ", Library.class);
		List<Library> lib = query.getResultList();
		
		for(Library library : lib ) {
			if(library.getLibraryName().equals(libraryName)) {
				return library;
			}
		}
		return null;
	}
	
	public Book searchBook(int bookId) {
		return entityManager.find(Book.class,bookId);
	}

	public void deleteBook(Book bookId) {
		entityManager.getTransaction().begin();
		Book book = addBook(bookId);
		entityManager.remove(book);
		
		entityManager.getTransaction().commit();
	}
	
	public List<Book> getAllBooks(){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT books FROM Book b", Book.class);
		List<Book> books = query.getResultList();
		entityManager.close();
		return books;
	}
	
	public Book updateBookInformation(Book bookId,String bookName,String author,String publisher) {
		Book b = addBook(bookId);
		
		entityManager.getTransaction().begin();
		
		if(bookName.length()!=0) {
			b.setBookName(bookName);
		}
		if(author.length()!=0) {
			b.setAuthor(author);
		}
		if(publisher.length()!=0) {
			b.setPublisher(publisher);
		}
		
		entityManager.getTransaction().commit();
		return b;
	}

	
}
