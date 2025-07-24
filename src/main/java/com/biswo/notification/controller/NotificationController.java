package com.biswo.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biswo.notification.dto.EmailRequest;

@RestController
@RequestMapping("/notify")
public class NotificationController {
	
	@Autowired 
	private JavaMailSender mailSender;
	
	@PostMapping("/send-email")
	public String sendMail(@RequestBody EmailRequest request) {
		System.out.println("Mail is call");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(request.getTo());
		message.setSubject(request.getSubject());
		message.setText(request.getBody());
		
		mailSender.send(message);
		
		return "Email Send Succesfully....";
	}
}
