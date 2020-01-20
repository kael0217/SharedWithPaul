package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.java.dao.EmployeeRepo;
import com.java.dto.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired EmployeeRepo repo;

	@Override
	public Employee findById(int id) {
		Employee e = repo.findById(id).orElse(null);
//		if(e == null) {
//			throw new EmployeeNotFoundException("EmployeeNotFound") ;
//		}
		return e;
	}
	
	//not done yet
	@Override
	public Page<Employee> findByPage(int offset, int limit) {
		Pageable pageable = PageRequest.of(offset, limit);
		return repo.findAll(pageable);
	}

	@Override
	public void addEmployee(Employee e) {
		repo.save(e);
		
	}

	@Override
	public void deleteEmployee(Employee e) {
		repo.delete(e);
		
	}
	@Override
	public void deleteById(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public void updateEmployee(Employee e) {
		repo.save(e);	
	}



}
