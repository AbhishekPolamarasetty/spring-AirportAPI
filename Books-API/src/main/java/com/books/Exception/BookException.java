package com.books.Exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

//import org.springframework.http.HttpStatus;
@Data
public class BookException {
	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpStatus;
	
	public BookException(String message, Throwable throwable, HttpStatus httpStatus) {
		this.message = message;
		this.throwable = throwable;
		this.httpStatus = httpStatus;
	}
}
