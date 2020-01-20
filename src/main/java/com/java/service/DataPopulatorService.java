package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.java.dao.EmployeeRepo;
import com.java.dto.Address;
import com.java.dto.Employee;


@Service
@Profile("!prod")
public class DataPopulatorService implements CommandLineRunner{
	
	@Autowired EmployeeRepo rep;

	@Override
	public void run(String... args) throws Exception {
		Address address1 = new Address(18, "Erquan road", "Wuxi", "Jiangsu");
		Address address2 = new Address(3809, "Illinois Ave.", "Chicago","IL");
		Address address3 = new Address(1318, "Covington ct.", "St. Charles", "IL");
		
		Employee e1 = new Employee(1, "Alice", address1);
		Employee e2 = new Employee(2, "Bob", address2);
		Employee e3 = new Employee(3, "Charles", address3);
		
		rep.save(e1);
		rep.save(e2);
		rep.save(e3);
	}

}
