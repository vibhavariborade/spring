package com.cybage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.model.Book;

public interface IBookRepository extends JpaRepository<Book, Integer> {
	
	List<Book> getByTitle(String title);

}
