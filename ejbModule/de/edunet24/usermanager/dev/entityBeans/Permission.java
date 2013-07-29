package de.edunet24.usermanager.dev.entityBeans;

import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
public class Permission extends EntityUnit{

	@Basic
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
