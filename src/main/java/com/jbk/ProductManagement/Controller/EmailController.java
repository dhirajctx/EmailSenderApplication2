package com.jbk.ProductManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.ProductManagement.Model.EmailRequestModel;
import com.jbk.ProductManagement.Model.EmailResponse;
import com.jbk.ProductManagement.Service.EmailService;

@RestController
@CrossOrigin
public class EmailController {
	
	@Autowired
	private EmailService service;
	//Dhiraj
	
	@RequestMapping (value ="/Welcome")
	public String Welcome() {
		
		return "This is my emailAPI";
	}
	
	
	
	@RequestMapping(value = "/sendemail", method = RequestMethod.POST)
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequestModel model) {
		
		boolean result = this.service.sendEmail(model.getSubject(),model.getMessage(),model.getTo());
		System.out.println(model);
		
		if(result) {
			return ResponseEntity.ok(new EmailResponse("Email sent successfully"));
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email not sent"));
	
			
		}
		
		
		
	}
	

}
