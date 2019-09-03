package com.sakdd.hibernate.service;

import java.util.List;

import com.sakdd.hibernate.model.Employee;

public interface EmployeeService {
	List<Employee> getEmployees();

	Employee getEmployeeById(int id);

	Employee saveEmployee(Employee employee);

	boolean deleteEmployeeById(int id);
}
