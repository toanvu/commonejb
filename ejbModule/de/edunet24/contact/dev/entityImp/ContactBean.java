package de.edunet24.contact.dev.entityImp;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import de.edunet24.contact.dev.entityBeans.CRequest;
import de.edunet24.contact.dev.entityBeans.Contact;
import de.edunet24.contact.dev.entityInterfaces.IContact;
import de.edunet24.usermanager.dev.entityBeans.User;

@Stateless
@Remote (IContact.class)
public class ContactBean implements IContact{

	@Override
	public void addContact(User u1, User u2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContact(User u1, User u2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contact getContact(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> getContacts(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CRequest getRequestByRequest(User request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CRequest getRequestByResponse(User response) {
		// TODO Auto-generated method stub
		return null;
	}

}
