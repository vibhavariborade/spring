package com.cybage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> getByName(String name);
	List<Employee> getByDesignation(String name);
	List<Employee> getBySalary(double salary);
	
	List<Employee> getBySalaryGreaterThan(double salary);
	List<Employee> getBySalaryLessThan(double salary);
}
