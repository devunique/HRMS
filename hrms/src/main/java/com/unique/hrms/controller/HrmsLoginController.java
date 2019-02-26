package com.unique.hrms.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unique.hrms.model.Email;
import com.unique.hrms.model.UserLogin;
import com.unique.hrms.repository.UserRepository;
import com.unique.hrms.service.EmailService;
import com.unique.hrms.service.UserService;
import com.unique.hrms.util.Constants;
import com.unique.hrms.util.EmailTemplate;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class HrmsLoginController {
	
	@Autowired
	private UserRepository userRep;
	@Autowired
	EmailService emailservice;
	
	@Autowired 
	UserService userService;
	
	@RequestMapping("/test")
	public String Test() {
		return "hi";
	}
	
	
	/*@GetMapping("/pass/{name}/{password}")
	public boolean getPassword(@PathVariable (value="name") String name,@PathVariable (value="password") String password) {
	
     User  user =	userRep.findByuserName(name);
     String username=user.getUserName();
      String pass  = user.getPassword();
       
     if(name.equals(username)&&password.equals(pass)) {
    	 return true;
     } else {
    	  return false;
      }
     }*/
	
	@GetMapping("/pass/{name}/{password}")
	public boolean getPassword(@PathVariable (value="name") String name,@PathVariable (value="password") String password) {
	System.out.println(name +" name ");
	System.out.println(password +" password ");
	
     UserLogin  user =userRep.findByuserName(name);	
      String username=user.getStrLoginId();
      String pass  = user.getStrPassword();
       
      System.out.println(username +" name ");
  	  System.out.println(pass +" password ");
     if(name.equals(username)&&password.equals(pass)) {
    	 return true;
     } else {
    	  return false;
      }
     }
  
	
	}
	
	

