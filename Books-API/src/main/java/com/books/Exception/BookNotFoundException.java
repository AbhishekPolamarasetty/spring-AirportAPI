package com.books.Exception;

public class BookNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public BookNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BookNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
