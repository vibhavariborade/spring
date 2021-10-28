package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.CustomerRepository;
import com.cybage.model.Customer;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(customerId);
	}

	public void updateEmployee(int id, Customer customer) {
		// TODO Auto-generated method stub
		Customer existingCustomer = customerRepository.getById(id);
		existingCustomer.setName(customer.getName());
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setEmailId(customer.getEmailId());
		customerRepository.save(existingCustomer);
	}

	public List<Customer> findByName(String name) {
		// TODO Auto-generated method stub
		return customerRepository.findByName(name);
	}
	
	
	
	
}
