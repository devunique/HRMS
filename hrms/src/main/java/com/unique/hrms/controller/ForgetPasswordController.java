package com.unique.hrms.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.unique.hrms.model.Email;
import com.unique.hrms.model.User;
import com.unique.hrms.service.EmailService;
import com.unique.hrms.service.UserService;
import com.unique.hrms.util.Constants;
import com.unique.hrms.util.EmailTemplate;

//@CrossOrigin(origins="http://localhost:4200",maxAge=3000)
@RestController
@RequestMapping("/hrms")
public class ForgetPasswordController {

	@Autowired
	EmailService emailservice;
	
	@Autowired 
	UserService userService;
	
	@RequestMapping(value="/user/forgetpassword", method= RequestMethod.POST)
	public String ResetpasswordEmailNotification( HttpServletRequest request,@RequestBody User user) {
		String strTo               = "";
		String strFrom             = "";
		String strSubject          = "";
		Optional <User> optional   = userService.finduserBystrEmail(user.getStrEmail());
		
		if(! optional.isPresent())
		{
			return "Enter valid email address!";
		}
		else {
			user=optional.get();
			strFrom                 = Constants.SYSTEM_MAIL_ADD;
			strSubject              = Constants.FORGET_PASSWORD_MAIL_SUB;
			strTo                   = user.getStrEmail().toString();
			user.setResetToken(UUID.randomUUID().toString());
			userService.save(user);
			String appURL           = request.getScheme()+"://"+request.getServerName()+":"+request.getLocalPort();
			EmailTemplate template  = new EmailTemplate(Constants.FORGET_PASSWORD_MAIL_TEMP);
			Map<String,String> replacements = new HashMap<String,String>();
			replacements.put("user", user.getStrFstname());
			replacements.put("today", String.valueOf(new Date()));
			replacements.put("link",appURL+"/restpassword?token="+user.getResetToken() );
			String strMessage       = template.getTemplate(replacements);
			Email email             = new Email(strFrom,strTo,strSubject,strMessage);
			email.setHtml(true);
			emailservice.send(email);
			return "mail send sucessfully";
		}
		
	}

	@PostMapping("/user/reset")
	public String UpdatePassword() {
		 return "Password Updated Sucessfully!!!";
	}
}
