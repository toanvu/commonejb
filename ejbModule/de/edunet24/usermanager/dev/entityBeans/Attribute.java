package de.edunet24.usermanager.dev.entityBeans;

import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
public class Attribute extends EntityUnit{

	@Basic
	private String name;
	
	@Basic
	private String valueType;
	
	@Basic
	private boolean isNeededByRegister= false;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public boolean isNeededByRegister() {
		return isNeededByRegister;
	}

	public void setNeededByRegister(boolean isNeededByRegister) {
		this.isNeededByRegister = isNeededByRegister;
	}
	
	
	
}
