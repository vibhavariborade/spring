package com.cybage.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cybage.model.Employee;
import com.cybage.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getAllEmployees")
	public ModelAndView getAllEmployees(){
		List<Employee> employeeList = employeeService.getAllEmployees();
		return new ModelAndView("employee","employees",employeeList);
	}
	
	@GetMapping("/add")
	public String addEmployee(Model model){
		model.addAttribute("employee",new Employee());
		return "addEmployee";
	}
	
	@PostMapping("/add")
	public String addEmployee(@Valid @ModelAttribute("employee") Employee employee,BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			return "addEmployee";
		}
		
		employeeService.addEmployee(employee);
		return "redirect:/getAllEmployees";
	}
	
	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable int id,Model model){
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "updateEmployee";		
	}
	
	@PostMapping("/edit")
	public String editEmployee(@Valid @ModelAttribute("employee") Employee employee,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "updateEmployee";
		}
		
		employeeService.editEmployee(employee);
		return "redirect:/getAllEmployees";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id){
		
		employeeService.deleteEmployeeById(id);
		
		return "redirect:/getAllEmployees";
	}
	
	@PostMapping("/name")
	public String filterByName(@RequestParam(value="name") String name,Model model){
		List<Employee> employees = employeeService.getByName(name);
		model.addAttribute("employees",employees);
		return "employee";
	}
	
	@PostMapping("/designation")
	public String filterByDesignation(@RequestParam(value="designation") String designation,Model model){
		List<Employee> employees = employeeService.getByDesignation(designation);
		model.addAttribute("employees",employees);
		return "employee";
	}
	
	@PostMapping("/salary")
	public String filterBySalary(@RequestParam(value="salary") double salary,Model model){
		List<Employee> employees = employeeService.getBySalayr(salary);
		model.addAttribute("employees",employees);
		return "employee";
	}
	
	@PostMapping("/greaterthan")
	public String filterByLessSalary(@RequestParam(value="salary") double salary,Model model){
		List<Employee> employees = employeeService.getByMinSalary(salary);
		model.addAttribute("employees",employees);
		return "employee";
	}
	
	@PostMapping("/lessthan")
	public String filterByGreaterSalary(@RequestParam(value="salary") double salary,Model model){
		List<Employee> employees = employeeService.getByMaxSalary(salary);
		model.addAttribute("employees",employees);
		return "employee";
	}
	
	
}
