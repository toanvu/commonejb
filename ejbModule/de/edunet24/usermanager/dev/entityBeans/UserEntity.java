package de.edunet24.usermanager.dev.entityBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;

/**
 * user entity is used for mapping data from databank to object
 * @author edunet24
 *
 */
@MappedSuperclass
public abstract class UserEntity extends EntityUnit{
	
	@Basic
	private String firstname;
	
	@Basic
	private String lastname;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Email
	private String email;
	
	@Basic
	private String password;
	
	@Basic
	private String username;
	
	@Basic
	private String gender;
	
	@ManyToMany 
	@JoinTable(
			name="User_Role", 
			joinColumns={ @JoinColumn(name="User_Id", referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="Role_Id",referencedColumnName="id")}
	)	
	private List<Role> roles = new ArrayList<Role>();
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Transient
	public String getFullName(){
		return this.firstname+" , "+this.lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
}
