package de.edunet24.usermanager.dev.entityBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class User extends UserEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne	
	private Role role;
	
	@Column(name="school_id")
	private Long schoolId;
	
	@OneToMany(cascade={CascadeType.ALL})
	private List<AttributeValue> optAttributes = new ArrayList<AttributeValue>();

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public List<AttributeValue> getOptAttributes() {
		return optAttributes;
	}

	public void setOptAttributes(List<AttributeValue> optAttributes) {
		this.optAttributes = optAttributes;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	} 
	
	 
}