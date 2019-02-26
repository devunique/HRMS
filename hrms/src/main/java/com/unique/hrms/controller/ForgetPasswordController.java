package com.unique.hrms.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.unique.hrms.model.Email;
import com.unique.hrms.model.User;
import com.unique.hrms.model.UserLogin;
import com.unique.hrms.repository.UserRepository;
import com.unique.hrms.service.EmailService;
import com.unique.hrms.service.UserService;
import com.unique.hrms.util.Constants;
import com.unique.hrms.util.EmailTemplate;


@RestController
@RequestMapping("/hrms")
@CrossOrigin(origins="http://localhost:4200",maxAge=3000)
public class ForgetPasswordController {
	 @PersistenceContext
	  private EntityManager manager;
	@Autowired
	EmailService emailservice;
	@Autowired
	private UserRepository userRep;
	@Autowired 
	UserService userService;
	UserLogin UserLogin;
	
	@RequestMapping(value="/user/forgetpassword", method= RequestMethod.POST)
	public boolean ResetpasswordEmailNotification( HttpServletRequest request,@RequestBody UserLogin UserLogin) {
		System.out.println(UserLogin.getStrLoginId());
		String strTo               = "";
		String strFrom             = "";
		String strSubject          = "";
		Optional <UserLogin> optional   = userService.finduserBystrLoginId(UserLogin.getStrLoginId());
		System.out.println(UserLogin.getStrLoginId());
		if(! optional.isPresent())
		{
			return false;
		}
		else {
			UserLogin=optional.get();
			strFrom                 = Constants.SYSTEM_MAIL_ADD;
			strSubject              = Constants.FORGET_PASSWORD_MAIL_SUB;
			strTo                   = UserLogin.getStrLoginId().toString();
			UserLogin.setStrResetToken(UUID.randomUUID().toString());
			userService.save(UserLogin);
			String appURL           = request.getScheme()+"://"+request.getServerName()+":"+request.getLocalPort();
			EmailTemplate template  = new EmailTemplate(Constants.FORGET_PASSWORD_MAIL_TEMP);
			Map<String,String> replacements = new HashMap<String,String>();
			replacements.put("user", UserLogin.getStrLoginId());
			replacements.put("today", String.valueOf(new Date()));
			//replacements.put("link",appURL+"/restpassword?token="+UserLogin.getStrResetToken() );
			replacements.put("link","http://localhost:4200/forgotpass?"+"token="+UserLogin.getStrResetToken());
			String strMessage       = template.getTemplate(replacements);
			//String strMessage="test mail";
			Email email             = new Email(strFrom,strTo,strSubject,strMessage);
			email.setHtml(true);
			emailservice.send(email);
			//String strLoginId=UserLogin.getStrLoginId();
			//return UserLogin;
			return true;
		}
		
	}

	@GetMapping("/user/reset/{password}/{token}")
	public boolean UpdatePassword(@PathVariable (value="password") String password,@PathVariable (value="token") String token) {
			System.out.println(token +" email id ");
			System.out.println(password +"  password");
		
			Optional <UserLogin> optional = userService.finduserBystrRestToken(token);
			if(! optional.isPresent()) {
				return false;
			}
			else {
				UserLogin =optional.get();
				UserLogin.setStrPassword(password);
				UserLogin.setStrResetToken(null);
				userService.save(UserLogin);
				return true;
			}
			
	}
}
