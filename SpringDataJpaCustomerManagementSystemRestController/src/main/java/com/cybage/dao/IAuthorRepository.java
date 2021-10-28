package com.cybage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cybage.model.Author;

public interface IAuthorRepository extends JpaRepository<Author, Integer> {
     
	
	void deleteAuthorByEmail(String email);
}
