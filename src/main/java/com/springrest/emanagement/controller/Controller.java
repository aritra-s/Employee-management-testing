package com.springrest.emanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.emanagement.entities.Employee;
import com.springrest.emanagement.service.EmployeeService;

@RestController
public class Controller {
	
	@Autowired
	private EmployeeService employeeService;
		
	//get a list of all employees
	@GetMapping("/employee")
	public List<Employee> getEmployees(){
		
		return employeeService.getEmployees();
		
	}
	
	//fetch details of a particular employee
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		return employeeService.getEmployee(employeeId);
	}
	
	//add employees
	@PostMapping("/employee")
	public void addEmployees(@RequestBody Employee employee){
		employeeService.addEmployee(employee);

	}
	
	//delete a particular employee
	@DeleteMapping("/employee/{employeeId}")
	public void deleteEmployee(@PathVariable int employeeId) {
		employeeService.deleteEmployee(employeeId);
	} 
	
	//update details of an employee
	@PutMapping("/employee/{employeeId}")
	public void updateEmployee(@RequestBody Employee employee,@PathVariable int employeeId) {
		
		employeeService.updateEmployee(employee,employeeId);
	}
	
}
