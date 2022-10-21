package com.fabMail.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.regex.*;

import com.fabMail.entities.Mailbox;
import com.fabMail.metier.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Mailboxdao implements IMailboxdao {
	
	public void addMailbox(Mailbox mailbox) {try {
		Connection con = Singleton.getInstance().getConnection();
		PreparedStatement stmt = con.prepareStatement("INSERT INTO users(id,email,nom,password,active,domaine_id,created,modified) VALUES (null, ?, ?, ENCRYPT(?,'dovecot'),?, ?, ?, ?)");
		stmt.setString(1,mailbox.getUsername());
	System.out.println(mailbox.getUsername());
		stmt.setString(2,mailbox.getName());
		stmt.setString(3,mailbox.getPassword());
		System.out.println(mailbox.getPassword());
		//System.out.println(mailbox.getName());
		//System.out.println(mailbox.getUsername());
		//stmt.setDouble(5, mailbox.getQuote());
		// int Domain_id = mailbox.getUsername().substring(mailbox.getUsername().indexOf("@") + 1);
		// System.out.println(Domain);
		//stmt.setString(5,Domain);
		stmt.setInt(4, 1);
		stmt.setInt(5,3);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   stmt.setString(6,dtf.format(now));
		stmt.setString(7,dtf.format(now));
		//System.out.println(dtf.format(now));
		
		stmt.execute();
	} catch (SQLException ex) {
		System.out.println("Erreur SQL : " + ex.getMessage());
	}
		}
		public void DeleteMailbox(int ID) {
			try {

				Connection conn = Singleton.getInstance().getConnection();
				PreparedStatement stmt = conn.prepareStatement("DELETE FROM users WHERE id = ?");
				stmt.setInt(1, ID);
				stmt.execute();
			} catch (SQLException ex) {
				System.out.println("Erreur SQL : " + ex.getMessage());
			}
		}
		
		public void updateMailbox(Mailbox mailbox,String username) {
			try {

			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE users SET nom = ?, password = ENCRYPT(?,'dovecot'), modified = ? WHERE email = ?");
			stmt.setString(1,mailbox.getName());
			stmt.setString(2, mailbox.getPassword());
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			stmt.setString(3,dtf.format(now));
            stmt.setString(4, username);	
			stmt.execute();
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		}
		public boolean EmailValidation(String username) {
			 boolean valid;
			 String regex = "^(.+)@(.+)$";  
			 Pattern pattern = Pattern.compile(regex);
			 Matcher matcher = pattern.matcher(username);
			 valid=matcher.matches();
			
			return valid;
			
		}
	    public boolean isValidPassword(String password)
	    {System.out.println(password);
	        String regex =  "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
	        Pattern p = Pattern.compile(regex);
	        if (password == null) {
	            return false;
	        }
	        Matcher m = p.matcher(password);
	        return m.matches();
	    }
		public Mailbox findOneMailbox(String password) {
			Mailbox mailbox =new Mailbox();
			try {
			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE password=ENCRYPT(?,'dovecot') ");
			stmt.setString(1,password);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {	
				 int id = result.getInt("id") ;
				 String Name = result.getString("nom");
				 String password1 =result.getString("password");	
				 int active=result.getInt("active");
				 int domain_id=result.getInt("domaine_id");
				 Date created=result.getDate("created");
				 Date modified=result.getDate("modified");
			String username = result.getString("email");
			
			 mailbox =new Mailbox(id,username,Name,password1,active,created,modified);
			
			PreparedStatement stmtt = conn.prepareStatement("SELECT name FROM domains WHERE id=? ");
			stmtt.setInt(1,domain_id);
			ResultSet resultt = stmtt.executeQuery();
			
			while(resultt.next()) {	
				 String Domain_name = resultt.getString("name") ;
				 mailbox.setDomain( Domain_name);}}
		} catch(SQLException ex) { 
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
			
		return mailbox;
		
		}	@Override
		public String Vpassword(String username,String password) {
			String email=null;
				try {
				Connection conn = Singleton.getInstance().getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT email FROM users WHERE password=ENCRYPT(?,'dovecot') ");
				stmt.setString(1,password);
				ResultSet result = stmt.executeQuery();
				while(result.next()) {			 
					email = result.getString("email");
				}
			} catch(SQLException ex) { 
				System.out.println("Erreur SQL : " + ex.getMessage());
			}
				return email;
		}
		public Mailbox findOne(String username) {
			Mailbox mailbox =new Mailbox();
			try {
			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE email=? ");
			stmt.setString(1,username);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {	
				String password =result.getString("password");
				PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM users WHERE password=?");
				stmt2.setString(1,password);
				ResultSet result2 = stmt2.executeQuery();
				
				while(result2.next()) {	
					 int id = result2.getInt("id") ;
					 String Name = result2.getString("nom");
					String password1 =result2.getString("password");	
					 int active=result2.getInt("active");
					 int domain_id=result2.getInt("domaine_id");
					 Date created=result2.getDate("created");
					 Date modified=result2.getDate("modified");
					 String username1 = result2.getString("email");
					 mailbox =new Mailbox(id,username1,Name,password1,active,created,modified);
					 PreparedStatement stmtt = conn.prepareStatement("SELECT * FROM domains WHERE id=? ");
						stmtt.setInt(1,domain_id);
						ResultSet resultt = stmtt.executeQuery();
						
						while(resultt.next()) {	
							 String Domain_name = resultt.getString("name") ;
							 mailbox.setDomain( Domain_name);}}}
		} catch(SQLException ex) { 
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
			
		return mailbox;
		}
		public int Vaccount(String username) {
			int Active=0;
			try {
			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE email=? ");
			stmt.setString(1,username);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {			 
				Active = result.getInt("active");
			}
		} catch(SQLException ex) { 
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		return Active;
		}
		public Collection<Mailbox> findallMailbox() {
			Collection<Mailbox> mailboxs =new ArrayList<Mailbox>();
			try {

				Connection conn = Singleton.getInstance().getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users");
				ResultSet result = stmt.executeQuery();
				while(result.next()) {
					 int id = result.getInt("id") ;
					 String Name = result.getString("nom");
					 String password1 =result.getString("password");	
					 int active=result.getInt("active");
					 int domain_id=result.getInt("domaine_id");
					 Date created=result.getDate("created");
					 Date modified=result.getDate("modified");
				     String username = result.getString("email");  
					 Mailbox mailbox = new Mailbox(id,username,Name,password1,active,created,modified);
					 PreparedStatement stmtt = conn.prepareStatement("SELECT name FROM domains WHERE id=? ");
						stmtt.setInt(1,domain_id);
						ResultSet resultt = stmtt.executeQuery();
						
						while(resultt.next()) {	
							 String Domain_name = resultt.getString("name") ;
							 mailbox.setDomain( Domain_name);}
					 mailboxs.add(mailbox);
					 
				}
			} catch (SQLException ex) {
				System.out.println("Erreur SQL : " + ex.getMessage());
			}
		
			return mailboxs ;
		}
		
		public void blockMailbox(int id) {
			try {
				Connection conn = Singleton.getInstance().getConnection();	    
				PreparedStatement stmt = conn.prepareStatement("UPDATE users SET active = ? WHERE id = ?");
				stmt.setInt(1,0);
				stmt.setInt(2,id);
				stmt.execute();
			} catch (SQLException ex) {
				System.out.println("Erreur SQL : " + ex.getMessage());
			}
		}
		
		public void unblockMailbox(int id) {
			try {
				Connection conn = Singleton.getInstance().getConnection();	    
				PreparedStatement stmt = conn.prepareStatement("UPDATE users SET active = ? WHERE id = ?");
				stmt.setInt(1,1);
				stmt.setInt(2,id);
				stmt.execute();
			} catch (SQLException ex) {
				System.out.println("Erreur SQL : " + ex.getMessage());
			}
		}
		@Override
		public Mailbox findOnee(String username) {
			Mailbox mailbox =new Mailbox();
			try {
			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE email=? ");
			stmt.setString(1,username);
			ResultSet result2 = stmt.executeQuery();
				while(result2.next()) {	
					 int id = result2.getInt("id") ;
					 String Name = result2.getString("nom");
					String password1 =result2.getString("password");	
					 int active=result2.getInt("active");
					 int domain_id=result2.getInt("domaine_id");
					 Date created=result2.getDate("created");
					 Date modified=result2.getDate("modified");
					 String username1 = result2.getString("email");
					 mailbox =new Mailbox(id,username1,Name,password1,active,created,modified);
					 PreparedStatement stmtt = conn.prepareStatement("SELECT * FROM domains WHERE id=? ");
						stmtt.setInt(1,domain_id);
						ResultSet resultt = stmtt.executeQuery();
						
						while(resultt.next()) {	
							 String Domain_name = resultt.getString("name") ;
							 mailbox.setDomain( Domain_name);}}
				} catch(SQLException ex) { 
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
			
		return mailbox;
		}
		
		
	
}
