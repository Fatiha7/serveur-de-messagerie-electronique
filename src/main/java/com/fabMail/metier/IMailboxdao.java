package com.fabMail.metier;

import java.util.Collection;

import com.fabMail.entities.Mailbox;

public interface IMailboxdao {
	public Mailbox findOneMailbox(String password);
	public Collection<Mailbox> findallMailbox();
	public void addMailbox(Mailbox mailbox);
	public void updateMailbox(Mailbox mailbox, String username);
	public void DeleteMailbox(int id);
    public void  blockMailbox(int id);
    public void  unblockMailbox(int id);
    public String Vpassword(String username,String password);
    public int Vaccount(String username);
    public boolean EmailValidation(String username);
    public  boolean isValidPassword(String password);
    public Mailbox findOne(String username);
    public Mailbox findOnee(String username);
}
