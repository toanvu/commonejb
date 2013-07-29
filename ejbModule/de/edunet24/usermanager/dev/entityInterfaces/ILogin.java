package de.edunet24.usermanager.dev.entityInterfaces;

import javax.ejb.Remote;

import de.edunet24.usermanager.dev.entityBeans.User;

@Remote
public interface ILogin {
	
	public boolean login(String username, String password);
	
	public void logout();
	
	public User getUser();
	
	public boolean isLogin();

}
