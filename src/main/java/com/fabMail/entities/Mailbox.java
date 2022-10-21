package com.fabMail.entities;

import java.util.Date;

public class Mailbox {
	private int id ;
	private String username;
	private String Name;
	private String password;	
	private int active;
	private String domain_id;
	private Date created;
	private Date modified;
	
	
	public Mailbox( Date created, Date modified, String username) {
		super();
		
		this.created = created;
		this.modified = modified;
		this.username = username;
	}
	public Mailbox() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mailbox(int active, Date created, String domain, String maildir, Date modified, String name, String password,
			 String username) {
		super();
		this.active = active;
		this.created = created;
		this.domain_id = domain;
		this.modified = modified;
		this.Name = name;
		this.password = password;
		this.username = username;
	}
	public Mailbox(int id,String username,String name, String password,int active,Date created, Date modified) {
		super();
		this.id=id;
		this.active = active;
		this.created = created;
		//this.domain_id = domain_id;
		this.modified = modified;
		this.Name = name;
		this.password = password;
		this.username = username;
	}
	public Mailbox(String name, String password, String username) {
		super();
		Name = name;
		this.password = password;
		this.username = username;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getDomain() {
		return domain_id;
	}
	public void setDomain(String domain) {
		this.domain_id = domain;
	}
	
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

	
}

