package com.springrest.emanagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springrest.emanagement.dao.EmployeeDao;
import com.springrest.emanagement.entities.Employee;
import com.springrest.emanagement.service.EmployeeServiceImpl;


@SpringBootTest
class EmployeeCrudApplicationTests {


	@Autowired
	private EmployeeServiceImpl eService;

	@MockBean
	EmployeeDao repository;

	@Test
	void getEmployeesTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Employee(2324, "Ram", "Android_development"), new Employee(9324, "Hari", "Frontend")).collect(Collectors.toList()));
		assertEquals(2, eService.getEmployees().size());
	}
	
	@Test
	void saveEmployeesTest() {
		Employee employee = new Employee(9991, "Pritam", "Backend");
		when(repository.save(employee)).thenReturn(employee);
		//assertEquals(employee, eService.addEmployee(employee));
		assertThat(employee).isEqualTo(eService.addEmployee(employee));
	}
	
//	@Test
//	void getEmployeeByIdTest() {
//		int id=1234;
//		when(repository.getEmployee(id)).thenReturn(Stream
//				.of(new Employee(1234, "Ram", "Android_development")).collect(Collectors.toList()));
//		assertEquals(1, eService.getEmployee(id).size());
////		when(repository.getEmployee(id))
////				.thenReturn(Stream.of(new Employee(1234, "Ram", "Android_development").collect(Collectors.toList());
////		assertEquals(1, eService.getAllEmployees().size());
//	}

	
	@Test
	void deleteEmployeeTest() {
		Employee employee = new Employee(9991, "Pritam", "Backend");
		eService.deleteEmployee(employee.getEmployeeId());
		verify(repository, times(1)).deleteById(employee.getEmployeeId());
	}


}
