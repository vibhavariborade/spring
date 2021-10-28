package com.cybage.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@ToString
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookId;
	//@NotEmpty(message="Enter Title")
	@Column
	private String title;
	
	@Column
	//@NotEmpty(message="Enter publisher")
	private String publisher;
	
	@OneToMany(mappedBy="book",cascade=CascadeType.ALL,fetch=FetchType.LAZY)	
	private List<Author> authors = new ArrayList<>();
	
	
	
	public List<Author> getAuthors() {
		return this.authors;
	}
	public void setAuthors(Author author) {
		this.authors.add(author);
	}
	public int getBookId() {
		return bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
}
