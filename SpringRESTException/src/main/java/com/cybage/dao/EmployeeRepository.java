package com.cybage.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cybage.pojo.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query("select e from Employee e where e.name = :name")
//	@Query(value="select * from employee where name = ?1",nativeQuery=true)
	Employee getByName(@Param("name") String name);
	
	@Query("FROM Employee WHERE designation = ?1")
	List<Employee> findByDesignation(String designation,Sort sort);
	
	@Query("FROM Employee WHERE designation = ?1")
	List<Employee> findByDesignationPageable(String designation,Pageable pageable);

	@Query("select e from Employee e where e.salary > 25000")
	List<Employee> findBySalarygreater();

}
