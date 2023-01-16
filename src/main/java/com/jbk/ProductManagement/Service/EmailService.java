package com.jbk.ProductManagement.Service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public boolean sendEmail(String subject, String message, String to) {

		Boolean f= false;
		String from = "dhirajctm@gmail.com";
		String host="smtp.gmail.com";
		
// get the system properties 
		Properties properties =System.getProperties();
		System.out.println("PROPERTIES" +properties);
		
//setting important information to properties object
//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
//step 1 get session object
		
		Session session = Session.getInstance(properties , new Authenticator(){

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("dhirajctm@gmail.com", "bekumjahnhjzglnw");
			}
		});
		
		session.setDebug(true);;
		
//step 2 compose the message
		MimeMessage m =new MimeMessage(session);
		
		//from email
		
	try {
		m.setFrom(from);
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		m.setSubject(subject);
		m.setText(message);
		
		//step 3: send message using Transport class
		Transport.send(m);
		System.out.println("Sent successfully");
		f= true;
		
		
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return f;
	}
    
   
		
	}


