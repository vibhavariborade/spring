package com.cybage.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cybage.dao.IAuthorRepository;
import com.cybage.dao.IBookRepository;
import com.cybage.dto.AuthorDto;
import com.cybage.model.Author;
import com.cybage.model.Book;
@Service
public class BookService{
	
	@Autowired
	private IBookRepository bookRepository;
	
	@Autowired
	private IAuthorRepository authorRepository;
		
	public void addBook(Book book) {
		bookRepository.save(book);
		
	}

	
	public List<Book> getAllBooks() {
		return bookRepository.findAll(Sort.by(Direction.ASC,"title"));
		/*List<Book> listBook =  bookRepository.getAllBooks();
		System.out.println("Print this");
		System.out.println(listBook);
		return listBook;*/
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
	
	public void addAuthors(AuthorDto authorDto){
		Book book = bookRepository.getById(authorDto.getBookId());
		Author author = new Author();
		
		BeanUtils.copyProperties(authorDto,author);
		author.setBook(book);
		book.setAuthors(author);		
		bookRepository.save(book);
	}
	
	public List<Book> getByAuthorName(String name){
	//	return bookRepository.getAllBooksByAuthorName(name);	
		return null;
	}
	
	public void deleteAuthorByEmail(String email){	
		System.out.println(email+" : in service");
		authorRepository.deleteAuthorByEmail(email);
	}

}
