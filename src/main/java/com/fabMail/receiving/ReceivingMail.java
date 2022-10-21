package com.fabMail.receiving;
	import com.fabMail.entities.Email;
	import com.fabMail.entities.Mailbox;
	import com.sun.mail.pop3.POP3Folder;

	import javax.mail.*;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Properties;

	public  class ReceivingMail {
		
	    public  List<Email>  receiving(Mailbox user)  {
	        List<Email> emails = new ArrayList<>();
	        String MAIL_HOST="192.168.1.5";
	        try {
	            Properties properties = new Properties();
	            Session session;

	            properties.put("mail.pop3.host", MAIL_HOST);
	            properties.put("mail.pop3.port","110");
	            properties.put("mail.pop3.auth","true");
	            properties.put("mail.pop3.user", user.getUsername());
	            properties.put("mail.store.protocol", "pop3");
	            Authenticator authenticator = new Authenticator() {
	                @Override
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(user.getUsername(),user.getPassword());
	                }
	            };
	            session = Session.getDefaultInstance(properties,authenticator);
	            Store store = session.getStore("pop3");
	            store.connect(MAIL_HOST, user.getUsername(),user.getPassword());
	            Folder folder = store.getFolder("inbox");

	            folder.open(Folder.READ_WRITE);
	            Message[] messages = folder.getMessages();

	            for(Message message : messages){
	                POP3Folder pf = (POP3Folder)folder;
	                Email email = new Email();
	                //email.setMessage((String) message.getContent());
	                email.setFrom(message.getFrom()[0].toString());
	                email.setSubject(message.getSubject());
	                email.setCreatedAt(message.getSentDate().toString());
	                email.setUuid(pf.getUID(message));
	                emails.add(email);
	            }
	            folder.close(true);
	            store.close();
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return emails;
	    }
	}


