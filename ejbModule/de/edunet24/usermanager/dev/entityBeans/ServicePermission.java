package de.edunet24.usermanager.dev.entityBeans;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class ServicePermission extends EntityUnit {

	@ManyToOne
	private Service service;
	
	@ManyToOne
	private Permission permission;

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	
	
}
