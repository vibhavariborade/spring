package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cybage.dto.BookAuthorDto;
import com.cybage.model.Author;
import com.cybage.model.Book;
import com.cybage.model.User;
import com.cybage.service.BookService;

@Controller
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
	
	@GetMapping("/getBooks")
	public String getAllBooks(Model model){
		List<Book> bookList = bookService.getAllBooks();
		model.addAttribute("bookList",bookList);
		return "bookList";		
	}
	
	@GetMapping("/add")
	public String addBook(Model model){
		model.addAttribute("book", new BookAuthorDto());		
		return "addBook";
	}
	
	@PostMapping("/add")
	public String addBook(@Validated @ModelAttribute("book") BookAuthorDto bookAuthorDto,BindingResult bindingResult,Model model){
		if(bindingResult.hasErrors()){
			return "addBook";
		}
		
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
		return "redirect:/getBooks";	
	}
	
	@GetMapping("/edit/{bookId}")
	public String editBook(@PathVariable int bookId,Model model){
		Book book = bookService.getBookById(bookId);
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
		List<Book> bookList = bookService.filterBookByTitle(title);			
		model.addAttribute("bookList",bookList);
		return "bookList";		
	}
	
	
	
	
		
		
	

}
