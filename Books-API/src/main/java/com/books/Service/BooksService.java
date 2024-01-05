package com.books.Service;

import java.util.List;

import com.books.Entity.Books;

public interface BooksService {
	public List<Books> getAllBooks();
	public String createBook(Books books);
	public Books getBooksById(Integer booksBookId);
}


