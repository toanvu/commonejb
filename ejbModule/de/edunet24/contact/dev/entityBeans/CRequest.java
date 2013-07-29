package de.edunet24.contact.dev.entityBeans;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import de.edunet24.usermanager.dev.entityBeans.EntityUnit;
import de.edunet24.usermanager.dev.entityBeans.User;

@Entity
public class CRequest extends EntityUnit{
	
	@OneToOne
	User request;
	
	@OneToOne
	User response;
	
	String message;

	public User getRequest() {
		return request;
	}

	public void setRequest(User request) {
		this.request = request;
	}

	public User getResponse() {
		return response;
	}

	public void setResponse(User response) {
		this.response = response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
