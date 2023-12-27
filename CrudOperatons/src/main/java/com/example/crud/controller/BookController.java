package com.example.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entity.Book;
import com.example.crud.service.BookService;


@RestController
public class BookController{

	@Autowired
	public BookService bookservice;
	@PostMapping("/api/book")
	public ResponseEntity<Book> saveBook(@RequestBody Book book){
		return new ResponseEntity<Book> (bookservice.saveBookData(book),HttpStatus.CREATED);
	}
	@GetMapping("/api/book/{bookId}")
	public ResponseEntity<Book> getBook(@RequestBody Book book,@PathVariable int bookId){
		if(bookservice.getBookData(bookId)==null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Book> (bookservice.getBookData(bookId),HttpStatus.OK);
			
		}
	}
	@PutMapping("/api/book/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable int bookId){
		if(bookservice.updateBookData(bookId, book)==null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Book> (bookservice.updateBookData(bookId,book),HttpStatus.OK);
			
		}
	}
	
}
