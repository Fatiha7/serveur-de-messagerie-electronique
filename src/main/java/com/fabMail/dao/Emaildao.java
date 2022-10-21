package com.fabMail.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.fabMail.entities.Email;
import com.fabMail.metier.IEmaildao;


public class Emaildao implements IEmaildao {
 

	@Override
	public Collection<Email> findAll(String from1) {
		Collection<Email> emails = new ArrayList<Email>();
		try {
			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM inbox where inbox.from=? ");
			stmt.setString(1,from1);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				String uuid = result.getString("id");
				String from = result.getString("from");
				String to = result.getString("to");
				String message = result.getString("message");
				String objet = result.getString("Subject");
				String createdAt = result.getString("created_at");

				Email email = new Email(uuid, from, to, message, objet, createdAt);
				emails.add(email);
			}
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		return emails;
	}
	public void delete(int id) {
		try {

		Connection conn = Singleton.getInstance().getConnection();
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM inbox WHERE id=?");
		stmt.setInt(1, id);
		stmt.execute();
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		
	}

	@Override
	public void add(Email email) {
		try {

			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO inbox VALUES (null, ?, ?, ?, ?, ?)");
			stmt.setString(1, email.getFrom());
			stmt.setString(2, email.getTo());
			stmt.setString(3, email.getMessage());
			stmt.setString(4, email.getSubject());
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();  
			   stmt.setString(5,dtf.format(now));


			stmt.execute();
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
	}
	@Override
	public Email findonebyID(int id) {
		Email email = new Email();
		try {
			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM inbox where id=?");
			stmt.setInt(1,id);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				String uuid = result.getString("id");
				String from = result.getString("from");
				String to = result.getString("to");
				String message = result.getString("message");
				String objet = result.getString("Subject");
				String createdAt = result.getString("created_at");
				email.setCreatedAt(createdAt);
				email.setFrom(from);
				email.setTo(to);
				email.setUuid(uuid);
				email.setSubject(objet);
				email.setMessage(message);
			}
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		return email;
	}
	@Override
	public Collection<Email> findAllGET(String tto) {
			Collection<Email> emails = new ArrayList<Email>();
			try {
				Connection conn = Singleton.getInstance().getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM inbox where inbox.to=? ");
				stmt.setString(1,tto);
				ResultSet result = stmt.executeQuery();
				while(result.next()) {
					String uuid = result.getString("id");
					String from = result.getString("from");
					String to = result.getString("to");
					String message = result.getString("message");
					String objet = result.getString("Subject");
					String createdAt = result.getString("created_at");

					Email email = new Email(uuid, from, to, message, objet, createdAt);
					emails.add(email);
				}
			} catch (SQLException ex) {
				System.out.println("Erreur SQL : " + ex.getMessage());
			}
			return emails;
	}

	

}