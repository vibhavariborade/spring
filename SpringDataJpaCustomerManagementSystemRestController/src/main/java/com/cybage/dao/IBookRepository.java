package com.cybage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cybage.model.Book;

public interface IBookRepository extends JpaRepository<Book, Integer> {
	
	List<Book> getByTitle(String title);
	
	//@Query(value="select b from Book b join fetch b.authors where b.authors.name=:author")
	//List<Book> getAllBooksByAuthorName(@Param("author") String name);
	
}
