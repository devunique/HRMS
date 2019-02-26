package com.unique.hrms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unique.hrms.model.Employee;
import com.unique.hrms.model.User;
import com.unique.hrms.model.UserLogin;
import com.unique.hrms.repository.EmployeeRepository;
import com.unique.hrms.repository.UserRepository;

@RestController
@RequestMapping("/hrms")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping(value="/employee/add")
	public String addEmployeeSubmit(@Valid @RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "Employee added successfully!!!!";
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/employee/list")
	public List <Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	@GetMapping(value="/user/list")
	 public List<UserLogin>getAllUsers(){
		 
		 return userRepository.findAll();
	 }
	
	
	

}
