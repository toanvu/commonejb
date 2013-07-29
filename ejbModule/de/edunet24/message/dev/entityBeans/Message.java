package de.edunet24.message.dev.entityBeans;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import de.edunet24.usermanager.dev.entityBeans.EntityUnit;
import de.edunet24.usermanager.dev.entityBeans.User;

@Entity
public class Message extends EntityUnit{
	
	@ManyToOne
	User subcriber;

	@ManyToOne
	Group group;
		
	String text;

	public User getSubcriber() {
		return subcriber;
	}

	public void setSubcriber(User subcriber) {
		this.subcriber = subcriber;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
