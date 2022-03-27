package com.springrest.emanagement.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import com.employee.emanagement.entity.Employee;

@Entity
@Table(name="Employee_records")
public class Employee {

	@Id
	private Integer employeeId;
	private String employeeName;
	private String employeeDepartment;
	public Employee() {
		super();
	}
	public Employee(Integer employeeId, String employeeName, String employeeDepartment) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeDepartment = employeeDepartment;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeDepartment="
				+ employeeDepartment + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		 if (obj == this) {
	            return true;
	        }
		 
		 if (obj == null)
			    return false;

			  if (this.getClass() != obj.getClass())
			    return false;
			  
		 Employee employee=(Employee)obj;
		 
		 if (!(obj instanceof Employee)) {
	            return false;
		 }
	         
	        
	        return Integer.compare(this.employeeId, employee.employeeId) == 0
	                && this.employeeName.equals(employee.employeeName) ;
		 
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	
	
}
