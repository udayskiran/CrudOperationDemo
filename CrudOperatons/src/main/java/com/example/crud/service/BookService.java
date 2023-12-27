package com.example.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.crud.entity.Book;
import com.example.crud.repo.bookRepo;

@Service
public class BookService {
	@Autowired
	public bookRepo bookrepo;
	public Book saveBookData(Book book) {
		return bookrepo.save(book);
	}

	public Book getBookData(@PathVariable int bookId) {
		Optional<Book> book = bookrepo.findById(bookId);
		if (book.isPresent()) {
			return book.get();
		} else {
			return null;
		}

	}
	public Book updateBookData(@PathVariable int bookId,Book book) {
		Optional<Book> bookById=bookrepo.findById(bookId);
		if(bookById.isPresent()) {
			bookById.get().setBookName(book.getBookName());
			bookById.get().setBookAuthor(book.getBookAuthor());
			bookById.get().setBookPrice(book.getBookPrice());
			return bookrepo.save(bookById.get());
		}else {
			return null;
		}
	}
}
