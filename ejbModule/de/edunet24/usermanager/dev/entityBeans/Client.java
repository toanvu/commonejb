package de.edunet24.usermanager.dev.entityBeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Client extends UserEntity{

	@Column(name="client_id") @GeneratedValue(strategy=GenerationType.AUTO)
	public Long clientId;
	
	
}
