package com.fabMail.entities;

import java.util.Date;

public class Email {
	private String uuid;
    private String from;
    private String to;
    private String message;
    private String subject;
    private String createdAt;
    
    @Override
	public String toString() {
		return "Email [uuid=" + uuid + ", from=" + from + ", to=" + to + ", message=" + message + ", subject=" + subject
				+ ", createdAt=" + createdAt + "]";
	}
	public Email(){

    }
    public Email(String uuid,String from, String to, String message, String subject, String createdAt) {
        this.uuid = uuid;
    	this.from = from;
        this.to = to;
        this.message = message;
        this.subject = subject;
        this.createdAt = createdAt;
    }
    public Email(String from, String to, String message, String subject, String createdAt) {
    	this.from = from;
        this.to = to;
        this.message = message;
        this.subject = subject;
        this.createdAt = createdAt;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    

}
