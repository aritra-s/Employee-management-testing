package com.springrest.emanagement.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springrest.emanagement.entities.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

	public Employee findById(int id);
	
}
