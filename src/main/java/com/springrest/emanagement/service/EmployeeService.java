package com.springrest.emanagement.service;

import java.util.List;

import com.springrest.emanagement.entities.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();
	
	public Employee getEmployee(int employeeId);
	
	public void addEmployee(Employee employee);
	
	public void deleteEmployee(int employeeId); 
	
	public void updateEmployee(Employee employee,int employeeId);
}
