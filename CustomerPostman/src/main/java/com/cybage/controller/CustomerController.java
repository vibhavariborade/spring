package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Customer;
import com.cybage.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomer()
	{
		return customerService.getAllCustomer();
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<String> addCustomer(Customer customer)
	{
		customerService.addCustomer(customer);
		return new ResponseEntity<String>("Customer ADDED !" , HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{customerId}")
	public void deleteEmployee(@PathVariable int customerId)
	{
		customerService.deleteCustomer(customerId);
	}
	
	@PutMapping("/edit/{id}")
	public void editEmployee(@PathVariable int id , Customer customer)
	{
		customerService.updateEmployee(id , customer);
	}
	
	@GetMapping("/findByName/{name}")
	public List<Customer> findByName(@PathVariable String name)
	{
		
		List<Customer> customerList = customerService.findByName(name);
		
	/*	if(employeeList.size() == 0)
			throw new RecordNotFoundException("Record  Not Found");
		else
			return employeeList;  */
		
		return customerList;
	}
}
