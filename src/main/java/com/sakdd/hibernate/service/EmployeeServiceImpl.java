package com.sakdd.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakdd.hibernate.model.Employee;
import com.sakdd.hibernate.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = null;
		try {
			employees = employeeRepository.findAll();
			return employees.isEmpty() ? null : employees;
		} catch (Exception ex) {
			return null;
		} finally {

		}
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = null;
		try {
			employee = employeeRepository.findById(id).get();
			return employee == null ? null : employee;
		} catch (Exception ex) {
			return null;
		} finally {

		}
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee = null;
		try {
			savedEmployee = employeeRepository.save(employee);
			return savedEmployee != null ? savedEmployee : null;
		} catch (Exception ex) {
			return null;
		} finally {

		}
	}

	@Override
	public boolean deleteEmployeeById(int id) {
		boolean deleteStatus = false;
		try {
			Employee employee = employeeRepository.findById(id).get();
			if (employee != null) {
				employeeRepository.deleteById(id);
				deleteStatus = true;
			} else {
				deleteStatus = false;
			}
			return deleteStatus;
		} catch (Exception ex) {
			return false;
		} finally {

		}
	}
}
