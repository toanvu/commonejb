package de.edunet24.contact.dev.entityBeans;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import de.edunet24.usermanager.dev.entityBeans.EntityUnit;
import de.edunet24.usermanager.dev.entityBeans.User;

@Entity
public class Contact extends EntityUnit{
	
	@OneToOne
	User user1;
	
	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	@OneToOne
	User user2;
	
	
}
