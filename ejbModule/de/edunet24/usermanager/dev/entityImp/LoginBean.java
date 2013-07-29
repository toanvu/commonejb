package de.edunet24.usermanager.dev.entityImp;

import java.util.concurrent.TimeUnit;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import de.edunet24.usermanager.dev.entityBeans.User;
import de.edunet24.usermanager.dev.entityInterfaces.ILogin;

	

@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 30) //60 s = 1min
@Remote(ILogin.class)

public class LoginBean implements ILogin{

	private User user ;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("edunet1");
	private EntityManager em = emf.createEntityManager();

	@Override
	public boolean login(String username, String password) {

		Query query = em.createQuery("Select u from User u where u.username=:username and u.password=:password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		this.user =  (User) query.getSingleResult();
		if(this.user.getId()>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void logout() {
		this.user = null;
	}

	@Override
	public User getUser() {
		return this.user;
	}
	
	public boolean isLogin(){
		return this.getUser().getId()>0;
	}
	
}
