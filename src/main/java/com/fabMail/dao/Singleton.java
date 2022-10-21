package com.fabMail.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class Singleton {
	private static Singleton uniqueInstance;
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.1.5:3306/fmail_db","fmail_user","123456789");
			 System.out.println("Connection Successfully to Mysql");
		}
		catch(ClassNotFoundException ex) {
			System.out.println("Erreur de pilote : " + ex.getMessage());
		}
		catch(SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		return conn;
	}
        
}

