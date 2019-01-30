package com.unique.hrms.service;

import com.unique.hrms.model.Email;

public interface EmailService {

	public void send(Email eparams);
	
	public void save(Email eParams);
}
