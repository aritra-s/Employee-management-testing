package com.springrest.emanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.emanagement.dao.EmployeeDao;
import com.springrest.emanagement.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getEmployees() {
		
		List<Employee> list=(List<Employee>) employeeDao.findAll();
		return list;
	}


	@Override
	public Employee getEmployee(int employeeId) {
		
		Employee employee=null;
		employee=employeeDao.findById(employeeId);
		
		return employee;
	}


	@Override
	public Employee addEmployee(Employee employee) {
		employeeDao.save(employee);
		return employee;
	}


	@Override
	public void deleteEmployee(int employeeId) {
		employeeDao.deleteById(employeeId);
	}


	@Override
	public void updateEmployee(Employee employee, int employeeId) {
		employee.setEmployeeId(employeeId);
		employeeDao.save(employee);
		
	}

}
