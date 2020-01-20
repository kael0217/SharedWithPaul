package com.java.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.java.dto.Employee;

@Service
public interface EmployeeService {
	public Employee findById(int id);
	public Page<Employee> findByPage(int offset, int limit);
	public void addEmployee(Employee e);
	public void deleteEmployee(Employee e);
	public void deleteById(int id);
	public void updateEmployee(Employee e);
}
