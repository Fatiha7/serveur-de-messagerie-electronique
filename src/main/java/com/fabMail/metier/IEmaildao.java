package com.fabMail.metier;
import java.util.Collection;

import com.fabMail.entities.Email;
public interface IEmaildao {
	public Collection<Email> findAll(String from) ;
	public void add(Email email);
	public void delete(int id);
	public Email findonebyID(int id);
	public Collection<Email> findAllGET(String to);

}
