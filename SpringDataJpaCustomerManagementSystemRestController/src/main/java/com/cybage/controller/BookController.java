package com.cybage.controller;

import java.util.List;

import javax.xml.ws.RespectBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.dto.AuthorDto;
import com.cybage.dto.BookAuthorDto;
import com.cybage.model.Author;
import com.cybage.model.Book;
import com.cybage.model.User;
import com.cybage.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/login")
	public String login(Model model){
		model.addAttribute("user",new User());
		return "login";
	}
	@PostMapping("/login")
	public String authenticateuser(@Validated @ModelAttribute("user") User user,Model model,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "login";
		}
		
		if(("admin").equals(user.getUserName())){
			if(("admin").equals(user.getPassword())){
				System.out.println("success");
				return "redirect:/getBooks";
			}
		}
		
		return "login";
	}
	
	@GetMapping("/book")
	public List<Book> getAllBooks(){
		 return bookService.getAllBooks();
	}
	
	
	@PostMapping("/book/add")
	public ResponseEntity<?> addBook(BookAuthorDto bookAuthorDto){
		System.out.println("inside add book");
		Author author = new Author();
		author.setName(bookAuthorDto.getName());
		author.setEmail(bookAuthorDto.getEmail());
		author.setContactNumber(bookAuthorDto.getContactNumber());
		
		
		Book book = new Book();
		book.setTitle(bookAuthorDto.getTitle());
		book.setPublisher(bookAuthorDto.getPublisher());
		author.setBook(book);
		book.setAuthors(author);
		bookService.addBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body("successfully added");	
	}
	
	@GetMapping("/edit/{bookId}")
	public String editBook(@PathVariable int bookId,Model model){
		Book book = bookService.getBookById(bookId);
		System.out.println();
		System.out.println(book);
		System.out.println();
		model.addAttribute(book);
		return "editBook";		
	}
	
	@PostMapping("/edit")
	public String editBook(@Validated @ModelAttribute("book") Book book,BindingResult bindingResult,Model model){
		if(bindingResult.hasErrors()){
			return "editBook";
		}
		bookService.updateBook(book);
		return "redirect:/getBooks";		
	}
	
	@GetMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable int bookId,Model model){
		bookService.deleteBookById(bookId);
		return "redirect:/getBooks";
		
	}
	
	@PostMapping("/filterBooks")
	public String filterBookByName(@RequestParam(value="bookTitle") String title,Model model){
		
		System.out.println(title);
		//List<Book> bookList = bookService.getByAuthorName(title);			
		List<Book> bookList = bookService.filterBookByTitle(title);
		model.addAttribute("bookList",bookList);
		return "bookList";		
	}
	
	@GetMapping("/addAuth/{bookId}")
	public String addAuthor(Model model,@PathVariable("bookId") int bookId){
		AuthorDto author = new AuthorDto();
		author.setBookId(bookId);
		model.addAttribute("author", author);	
			
		return "addAuth";
	}
	
	@PostMapping("/addAuth")
	public String addAuth(@Validated @ModelAttribute("author") AuthorDto authorDto,BindingResult bindingResult,Model model){
		if(bindingResult.hasErrors()){
			return "addAuth";
		}
		bookService.addAuthors(authorDto);		
		return "redirect:/getBooks";	
	}
	
	@GetMapping("/deleteauth/{email}")
	public String deleteAuthorByEmail(@PathVariable("email") String email){	
		System.out.println(email);
		bookService.deleteAuthorByEmail(email);
		return "redirect:/getBooks";
	}
	
	
	
	
		
		
	

}
