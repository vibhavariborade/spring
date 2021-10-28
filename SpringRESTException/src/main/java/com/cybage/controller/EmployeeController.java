package com.cybage.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cybage.exception.RecordNotFoundException;
import com.cybage.pojo.Employee;
import com.cybage.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	Logger logger = LogManager.getLogger("EmployeeController.class");

	@Autowired
	EmployeeServiceImpl employeeService;

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		List<Employee> empList = employeeService.listAllEmployees();
		return empList;
	}

	@PostMapping("/addemployee")
	public ResponseEntity<String> addEmployee(@Valid Employee employee) {
		employeeService.addEmployee(employee);
		return new ResponseEntity<String>("Added!", HttpStatus.CREATED);
	}

	// delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<String>("Removed", HttpStatus.CREATED);
	}

	// edit
	@PutMapping("/edit/{id}")
	public ResponseEntity<String> editPerson(@PathVariable int id) {
		Employee employee = employeeService.getEmployeeById(id);
		employeeService.updateEmployee(employee);
		return new ResponseEntity<String>("updated", HttpStatus.CREATED);
	}

	@GetMapping("/get-all-employees-greater")
	public List<Employee> getAllEmployeesGreater() {
		List<Employee> empList = employeeService.salaryGreater();
		return empList;
	}

	@GetMapping("/employee-by-name/{name}")
	public Employee employeeByName(@PathVariable String name) {
		Employee emp = employeeService.getByName(name);
		if (emp == null)
			throw new RecordNotFoundException("Record not found");
		else
			return emp;
	}
	
	

}
