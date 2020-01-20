package com.java.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.dto.Employee;

@Repository
@Transactional
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
