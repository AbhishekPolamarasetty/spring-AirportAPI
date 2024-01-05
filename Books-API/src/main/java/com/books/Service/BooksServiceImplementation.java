package com.books.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.Entity.Books;
import com.books.Exception.BookNotFoundException;
import com.books.repository.BooksRepository;

@Service
public class BooksServiceImplementation implements BooksService {
	@Autowired
	BooksRepository booksRepository;
	
	@Override
	public List<Books> getAllBooks(){
		return booksRepository.findAll();
	}
	
	@Override
	public String createBook(Books books) {
		booksRepository.save(books);
		return "success";
	}
	
	@Override
	public Books getBooksById(Integer BookId) {
		if (booksRepository.findById(BookId).isEmpty())
			throw new BookNotFoundException("not found");
		return booksRepository.findById(BookId).get();
		
	}
}
