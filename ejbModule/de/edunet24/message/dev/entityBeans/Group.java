package de.edunet24.message.dev.entityBeans;

import java.util.List;

import javax.persistence.*;

import de.edunet24.usermanager.dev.entityBeans.EntityUnit;
import de.edunet24.usermanager.dev.entityBeans.User;

@Entity
public class Group extends EntityUnit {
	
	@ManyToMany
	List<User> users;

	@ManyToMany
	List<Message> msgs;
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Message> getMsgs() {
		return msgs;
	}

	public void setMsgs(List<Message> msgs) {
		this.msgs = msgs;
	}
	
}
