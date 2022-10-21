package com.fabMail.sending;



import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;
import javax.activation.*;  
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * A utility class for sending e-mail messages
 * @author www.codejava.net
 *
 */
public class EmailUtility {
	public static void sendEmail(String host,String port,final String userName,final String password,String toAddress,String subject,String message1) throws AddressException,
			MessagingException {

		
		Properties properties = new Properties();
        Session session;
        MimeMessage message;
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port","25");
        properties.put("mail.smtp.auth","true");
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName,password);
            }
        };
        session = Session.getDefaultInstance(properties,authenticator);
        try {
            InternetAddress[] recipients = new InternetAddress[1];
            recipients[0] = new InternetAddress(toAddress);
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName));
            message.addRecipients(Message.RecipientType.TO,recipients);
            message.setSubject(subject);
            LocalDateTime createdAt= LocalDateTime.now();
           // Date date = java.util.Date.from(createdAt.atZone(ZoneId.systemDefault()).toInstant());
			//message.setSentDate(date);
            message.setText(message1);
            Transport.send(message);
            System.out.println("Mail sent");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

		// sets SMTP server properties
				


	}
}

