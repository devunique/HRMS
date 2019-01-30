package com.unique.hrms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unique.hrms.model.User;
import com.unique.hrms.repository.UserRepository;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class HrmsLoginController {
	
	@Autowired
	private UserRepository userRep;

	@RequestMapping("/test")
	public String Test() {
		return "hi";
	}
	
	
	@GetMapping("/pass/{name}/{password}")
	public boolean getPassword(@PathVariable (value="name") String name,@PathVariable (value="password") String password) {
	
     User  user =	userRep.findByuserName(name);
     String username=user.getUserName();
      String pass  = user.getPassword();
       
     if(name.equals(username)&&password.equals(pass)) {
    	 return true;
     } else {
    	  return false;
      }
     }
  
		
	}
	
	

