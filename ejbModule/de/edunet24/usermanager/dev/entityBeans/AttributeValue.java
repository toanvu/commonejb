package de.edunet24.usermanager.dev.entityBeans;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class AttributeValue extends EntityUnit{

	@ManyToOne
	private Attribute attribute;
	
	private String value;

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
		
}
