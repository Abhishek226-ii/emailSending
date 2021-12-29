package com.code.email_sending;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("preparing to send message");
        String message="Message for security check";
        String subject="regsrding project";
        String to="abhishekanand.cse2018@rceroorkee.in";
        String from="anirudh89368@gmail.com";
        
        sendEmail(message,subject,to,from);
    }
    // this method is responsible to send email...
	private static void sendEmail(String message, String subject, String to, String from) {
		
		// variable for gmail host
		
		String host="smtp.gmail.com";
		
		// get the system properties
		
		Properties properties =System.getProperties();
		System.out.println("PROPERTIES"+properties);
		
		//setting important info to properties object
		
		//setting host
		//mail.smtp is used as key to hsot
		
	 properties.put("mail.smtp.host", host);
	 properties.put("mail.smtp.port", "465");
	 properties.put("mail.smtp.ssl.enable", "true");
	 properties.put("mail.smtp.auth", "true");
	 
	 // step 1: TO GET THE SESSION OBJECST	
	Session session=Session.getInstance(properties, new Authenticator() {

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			// TODO Auto-generated method stub
			return new PasswordAuthentication("****", "***");
		}
			
		
	});
	
	
	//step 2: compose the message
	session.setDebug(true);
	
	 MimeMessage m = new MimeMessage(session);
	 
	 try {
		m.setFrom(from);
		
		//adding recipient
		
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		// adding subject to message
		m.setSubject(subject);
		
		//addding message
		
		m.setText(message);
		
		// send
		
		//Step 3 :s end the message
		
		Transport.send(m);
		
		System.out.println("send succesfully");
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 //sendAttach(message, subject,to,from) this is useful in sending the attachement
	 
	 // attachement..
	 
	 // path of the file set
	 //>string path="";
	 //new method
	 // MimeMultipart method
	 //m.setContent(mimeMultipart);
	 //include it in try catch block
	
	
		
	}
}
