package com.books.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.Entity.Books;
import com.books.Service.BooksServiceImplementation;

@RestController
@RequestMapping("/books")
public class BookController {
	BooksServiceImplementation booksService;
	
	public BookController(BooksServiceImplementation booksService) {
		this.booksService=booksService;
	}
	
	@GetMapping
	public List<Books> getAllBookDetails(){
		return booksService.getAllBooks();
	}
	
	@PostMapping
	public String createBookDetails(@RequestBody Books books) {
		return booksService.createBook(books);
	}
	
	@GetMapping("{BookId}")
	public Books getBookDetails(@PathVariable("BookId") Integer BookId) {
		return booksService.getBooksById(BookId);
	}
}
