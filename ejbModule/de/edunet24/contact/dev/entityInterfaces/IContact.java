package de.edunet24.contact.dev.entityInterfaces;

import java.util.List;

import javax.ejb.Remote;

import de.edunet24.usermanager.dev.entityBeans.User;
import de.edunet24.contact.dev.entityBeans.CRequest;
import de.edunet24.contact.dev.entityBeans.Contact;

@Remote
public interface IContact {
	
	public void addContact(User u1, User u2);
	
	public void deleteContact(User u1, User u2);
	
	public Contact getContact(User u); 
	
	public List<Contact> getContacts(User u);
	
	public CRequest getRequestByRequest(User request);
	
	public CRequest getRequestByResponse(User response);
	
}
