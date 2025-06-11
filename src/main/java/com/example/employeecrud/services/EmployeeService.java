package com.example.employeecrud.services;

import com.example.employeecrud.model.Employee;
import java.util.*;

public interface EmployeeService {
	Employee createEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Optional<Employee> getEmployeeById(Long id);
	Employee updateEmployee(Long id, Employee employee);
	void deleteEmployee(Long id);
	void deleteAllEmployees();
}
