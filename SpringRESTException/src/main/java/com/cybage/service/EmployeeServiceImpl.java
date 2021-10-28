package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cybage.dao.EmployeeRepository;
import com.cybage.pojo.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public List<Employee> listAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	
	
	@Override
	public void deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
	}
	@Override
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		
	}

	@Override
	public Employee getEmployeeById(int empId) {
		return employeeRepository.findById(empId).get();
	}

	
	
	@Override
	public List<Employee> findByDesignation(String designation) {
		return employeeRepository.findByDesignation(designation, Sort.by(Direction.DESC,"name"));
	}
	
	@Override
	public List<Employee> findByDesignationPageable(String designation) {
		Pageable pageable = PageRequest.of(0, 10);
		return employeeRepository.findByDesignationPageable(designation, pageable);
	}
	
	@Override
	public List<Employee> salaryGreater() {
		return employeeRepository.findBySalarygreater();
	}

	@Override
	public Employee getByName(String name) {
		return employeeRepository.getByName(name);
	}
	

	
}
