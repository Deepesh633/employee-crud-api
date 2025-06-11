package com.example.employeecrud.services;

import com.example.employeecrud.exception.ResourceNotFoundException;
import com.example.employeecrud.model.Employee;
import com.example.employeecrud.repository.EmployeeRepository;
import com.example.employeecrud.services.EmployeeService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import java.util.*;

public class EmployeeServiceImpl implements EmployeeService  {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	@Override 
	public Optional<Employee> getEmployeeById(Long id){
		return employeeRepository.findById(id); 
	}
	
	@Override
	public Employee updateEmployee(Long id, Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmail(employeeDetails.getEmail());
		
		return employeeRepository.save(employee);
	}
	
	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
	
	@Override
	public void deleteAllEmployees() {
		employeeRepository.deleteAll();
	}
}
