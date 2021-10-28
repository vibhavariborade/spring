package com.cybage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
public List<Customer> findByName(String name);
	
	public List<Customer> findByAddress(String address);
	
	public List<Customer> findByEmailId(String emailId);
}
