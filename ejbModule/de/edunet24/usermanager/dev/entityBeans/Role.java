package de.edunet24.usermanager.dev.entityBeans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
/**
 * each role has one servicepermission pair
 * for example: admin has service 1 with write-permission
 * normal user has service 1 with write-permission
 * @author toan vu
 *
 */
@Entity
public class Role extends EntityUnit{
	
	@Basic
	private String name;
	
	
	
	@ManyToMany
	@JoinTable(
			name="Role_ServicePermission", 
			joinColumns={ @JoinColumn(name="Role_Id", referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="ServicePermission_Id",referencedColumnName="id")}
	)
	private List<ServicePermission> servicePermission = new ArrayList<ServicePermission>();



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public List<ServicePermission> getServicePermission() {
		return servicePermission;
	}



	public void setServicePermission(List<ServicePermission> servicePermission) {
		this.servicePermission = servicePermission;
	}
	
	

}
