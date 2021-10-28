package com.cybage.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cybage.dao.IBookRepository;
import com.cybage.model.Book;
@Service
public class BookService{
	
	@Autowired
	private IBookRepository bookRepository;
		
	public void addBook(Book book) {
		bookRepository.save(book);
		
	}

	
	public List<Book> getAllBooks() {
		return bookRepository.findAll(Sort.by(Direction.ASC,"title"));
	}

	
	public void deleteBookById(int bookId) {
		bookRepository.deleteById(bookId);
	}

	
	public void updateBook(Book book) {
		Book persistentBook = bookRepository.getById(book.getBookId());
		BeanUtils.copyProperties(book, persistentBook);
		bookRepository.save(persistentBook);
	}
	
	public Book getBookById(int bookId){
		return bookRepository.getById(bookId);
	}
	
	public List<Book> filterBookByTitle(String title){
		return bookRepository.getByTitle(title);
	}

}
