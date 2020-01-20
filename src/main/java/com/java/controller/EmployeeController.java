package com.java.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.java.dto.Employee;
import com.java.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
//	@Autowired RabbitTemplate template;
	@Autowired EmployeeService service;
	
	@GetMapping(path="/{id}",produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Employee> findEmployeeById(@PathVariable(name = "id") int id){
		Employee employee = service.findById(id);
		if(employee==null) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok().body(employee);
		}
	}
	
	// @GetMapping(params = {"offset","limit"}) if we put params here ,THEN this method will be called only if passed in these two params
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Page<Employee>> getEmployeeByPage(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "20") int limit){
		Page<Employee> employees = service.findByPage(offset, limit);
		return ResponseEntity.ok().body(employees);
	}
	
	
	//create new employee
	@PostMapping(consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> addNewEmployee(@RequestBody Employee e){//, HttpRequest request, UriComponentsBuilder builder){
		
		service.addEmployee(e);
		
		//URI uri = request.getURI();
		//UriComponents uriComponents = builder.uri(uri).path(""+e.getId()).build();
		//UriComponents uriComponents = builder.uri(uri).build();
		
		return ResponseEntity.ok().build();
		//return ResponseEntity.created(uriComponents.toUri()).build();
	}
	
	@DeleteMapping()
	public ResponseEntity<Object> deleteEmployeeById(@RequestParam int id){
		service.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@PatchMapping(consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee e){
		service.updateEmployee(e);
		return ResponseEntity.ok().build();
		
	}
	
	
//	@GetMapping("/apply/{id}/{days}")
//	public ResponseEntity<Object> applyLeave(@PathVariable(name = "id") int id, @PathVariable(name ="days") int days){
//		//template.convertAndSend("apply", (new Application(id,days)));
//		Application application = new Application(id,days);
//		template.convertAndSend("apply-exchange", "apply", application);
//		return ResponseEntity.ok().build();
//	}
//	
//	@PostMapping("/publish")
//	public void sendMessage() {
//		Application application = new Application(1,3);
//		template.convertAndSend("apply-exchange","apply", application);
//	}
	
}
