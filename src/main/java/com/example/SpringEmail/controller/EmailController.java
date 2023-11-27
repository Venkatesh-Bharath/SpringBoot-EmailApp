package com.example.SpringEmail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringEmail.model.Email;

@RestController
public class EmailController {
    
	@Autowired(required=true)
	private JavaMailSender mailSend;
	
	@PostMapping("/mail")
	public Email sendEmail(@RequestBody Email email) {
		SimpleMailMessage sms=new SimpleMailMessage();
		sms.setTo(email.getTo());
		sms.setSubject(email.getSubject());
		sms.setText(email.getText());
		mailSend.send(sms);
		return email;
	}
	
	
}
