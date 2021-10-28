package com.cybage.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.cybage.pojo.Employee;

public interface IEmployeeService {
	// to return all the employee list
	public List<Employee> listAllEmployees();

	// to add new employee
	public void addEmployee(Employee employee);

	// update existing employee
	public void updateEmployee(Employee employee);

	// delete employee
	public void deleteEmployee(Employee employee);

	// delete employee
	public void deleteEmployeeById(int id);

	// get employee details by ids
	public Employee getEmployeeById(int empId);

	// get employee by name
	public Employee getByName(String name);

	// find by designation using Sort by name
	public List<Employee> findByDesignation(String designation);

	// find by designation using pageable by name
	public List<Employee> findByDesignationPageable(String designation);

	// salary greater than 2500
	public List<Employee> salaryGreater();

}
