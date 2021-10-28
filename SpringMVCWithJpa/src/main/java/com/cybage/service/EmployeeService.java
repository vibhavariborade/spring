package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cybage.dao.EmployeeRepository;
import com.cybage.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeService() {
	}
	
	public List<Employee> getAllEmployees(){
		
		return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}
	
	public void addEmployee(Employee employee){
		employeeRepository.save(employee);
	}
	
	public Employee getEmployeeById(int id){		
		 return employeeRepository.getById(id);	
	}
	
	public void editEmployee(Employee employee){
		Employee persistentEmployee = employeeRepository.getById(employee.getId());
		persistentEmployee.setName(employee.getName());
		persistentEmployee.setDesignation(employee.getDesignation());
		persistentEmployee.setSalary(employee.getSalary());
		employeeRepository.save(persistentEmployee);
	}
	
	public void deleteEmployeeById(int id){
		 employeeRepository.deleteById(id);
	}
	
	public List<Employee> getByName(String name){
		return employeeRepository.getByName(name);
	}
	public List<Employee> getByDesignation(String designation){
		return employeeRepository.getByDesignation(designation);
	}
	public List<Employee> getBySalayr(double salary){
		return employeeRepository.getBySalary(salary);
	}
	
	public List<Employee> getByMinSalary(double salary){
		return employeeRepository.getBySalaryGreaterThan(salary);
	}
	
	public List<Employee> getByMaxSalary(double salary){
		return employeeRepository.getBySalaryLessThan(salary);
	}
	
	
}
