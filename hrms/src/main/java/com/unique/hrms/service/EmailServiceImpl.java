package com.unique.hrms.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.unique.hrms.model.Email;
import com.unique.hrms.repository.EmailServiceRepository;
import com.unique.hrms.util.Constants;
import com.unique.hrms.util.EmailTemplate;

@Component
public class EmailServiceImpl implements EmailService{

	@Autowired
	private JavaMailSender mailsender;
	
	@Autowired
	private EmailServiceRepository emailRepository;
	
	public void send(Email eParams) {
		if(eParams.isHtml()) {
			try {
				sendHTMLMail(eParams);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}else {
			try {
				sendPlainTextMail(eParams);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}

	private void sendPlainTextMail(Email eParams) throws MessagingException {
		MimeMessage message = mailsender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		helper.setTo(eParams.getToList().toArray(new String [eParams.getToList().size()]));
		helper.setReplyTo(eParams.getStrFrom());
		helper.setFrom(eParams.getStrFrom());
		helper.setSubject(eParams.getStrSubject());
		helper.setText(eParams.getStrMessage());
		if(eParams.getCcList().size() > 0) {
			helper.setCc(eParams.getCcList().toArray(new String[eParams.getCcList().size()]));
		}
		try {
		    mailsender.send(message);
		    eParams.setStrMailStatus('S');
		    eParams.setDtCreatedDate(new Date());
		    eParams.setStrErr("Email sent successfully!!!!");
		    save(eParams);
		
		}catch(MailSendException|MailAuthenticationException e) {
			eParams.setStrMailStatus('F');
			eParams.setDtCreatedDate(new Date());
			eParams.setStrErr(e.toString());
			save(eParams);
		}
	}

	private void sendHTMLMail(Email eParams) throws MessagingException {
	    
		boolean isHTML =true;		
		
		MimeMessage message=mailsender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		helper.setTo(eParams.getToList().toArray(new String [eParams.getToList().size()]));
		helper.setReplyTo(eParams.getStrFrom());
		helper.setFrom(eParams.getStrFrom());
		helper.setSubject(eParams.getStrSubject());
		helper.setText(eParams.getStrMessage(),isHTML);
		
		if(eParams.getCcList().size()>0) {
			helper.setCc(eParams.getCcList().toArray(new String[eParams.getCcList().size()]));
		}
		try {
		    mailsender.send(message);
		    eParams.setStrMailStatus('S');
			eParams.setDtCreatedDate(new Date());
			eParams.setStrErr("Email sent successfully!!!!");
			save(eParams);
		}
		catch(MailSendException|MailAuthenticationException e) {
			eParams.setStrMailStatus('F');
			eParams.setDtCreatedDate(new Date());
			eParams.setStrErr(e.toString());
			save(eParams);
		}
	}

	@Override
	public void save(Email eParams) {
		emailRepository.save(eParams);
	}
}
