package de.edunet24.usermanager.dev.entityImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;








import org.jboss.ejb3.annotation.SecurityDomain;

import de.edunet24.usermanager.dev.entityBeans.Attribute;
import de.edunet24.usermanager.dev.entityBeans.AttributeValue;
import de.edunet24.usermanager.dev.entityBeans.Client;
import de.edunet24.usermanager.dev.entityBeans.Permission;
import de.edunet24.usermanager.dev.entityBeans.Role;
import de.edunet24.usermanager.dev.entityBeans.Service;
import de.edunet24.usermanager.dev.entityBeans.User;
import de.edunet24.usermanager.dev.entityBeans.UserEntity;
import de.edunet24.usermanager.dev.entityInterfaces.IUserManager;
import de.edunet24.usermanager.dev.entityBeans.ServicePermission;

@Stateless
@Remote(IUserManager.class)
@SecurityDomain(value="thingbook")
public class UserManager implements IUserManager{

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("edunet1");
	private EntityManager em = emf.createEntityManager();
	
	/**
	 * create default User with given password and username
	 * @param pw password should be hash before
	 * @param username 
	 */
	@Override
	@RolesAllowed({"admin","superadmin"})
	public User createUser(String pw, String username) {		
		User defaultUser = new User();
		//default user
		defaultUser.setFirstname("Mustermann");
		defaultUser.setLastname("Max");
		defaultUser.setEmail("max.mustermann@edunet24.de");
		//set pwd and username
		defaultUser.setPassword(pw);
		defaultUser.setUsername(username);
		return defaultUser;
	}

	/**
	 * create user with some given parameters 
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param username
	 * @param password
	 */
	@Override
	@RolesAllowed({"admin","superadmin"})
	public User createUser(String firstname, String lastname,
			String email, String pw, String username) {
		User defaultUser = new User();
		//default user
		defaultUser.setFirstname(firstname);
		defaultUser.setLastname(lastname);
		defaultUser.setEmail(email);
		//set pwd and username
		defaultUser.setPassword(pw);
		defaultUser.setUsername(username);
		
		return defaultUser;		
	}

	/**
	 * check user and and add to Database
	 * @param user 
	 */
	@Override	
	public User addUser(User user) {			
		//if something fails then rollback and give
		try{	
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return user;
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
			//TODO: throw error here
			return null;
		}
		
		
		
	}

	@Override
	public User getUser(String username) {
		String sql = "select * from user where user.username like '%:username%'";
		Query query = em.createQuery(sql);
		query.setParameter("username", username);
		
		User user = (User) query.getSingleResult();
		return user;
	}

	@Override
	public User getUser(int id) {		
		User user = em.find(User.class, id);		
		return user;
	}

	@Override
	public User getUser(HashMap<String, String> critics) {
		
		return null;
	}

	@Override
	@RolesAllowed({"admin","superadmin"})
	public void updateUser(User user, HashMap<String, Object> critics) {
		try{
			em.getTransaction().begin();
			em.merge(user);			
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	@RolesAllowed({"admin","superadmin"})
	public void deleteUser(User user, HashMap<String, String> critics) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RolesAllowed({"admin","superadmin"})
	public Client creatClient(String pwd, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RolesAllowed({"admin","superadmin"})
	public Attribute getAttribute(HashMap<String, String> cond) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RolesAllowed({"admin","superadmin"})
	public void createAttribute(Attribute att) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RolesAllowed({"admin","superadmin"})
	public void modifyAttribute(Attribute attr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RolesAllowed({"admin","superadmin"})
	public void deleteAttribute(Attribute attr) {
		// TODO Auto-generated method stub
		
	}

	@Override	
	public void getAttributeValuePair(HashMap<String, String> cond) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RolesAllowed({"admin","superadmin"})
	public void createAttributeValuePair(Attribute att, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RolesAllowed({"admin","superadmin"})
	public void addAttributeValuePair(AttributeValue av) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RolesAllowed({"admin","superadmin"})
	public void modifyAttributeValuePair(AttributeValue av) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RolesAllowed({"admin","superadmin"})
	public void deleteAttributeValuePair(AttributeValue av) {
		// TODO Auto-generated method stub
		
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<User> getAllUser() {
		Query query = em.createQuery("select u from "+User.class.getName()+" u");
		List<User> users = query.getResultList();
		return users;
	}

	@Override
	@RolesAllowed({"admin","superadmin"})
	public Role createRole(
			String name,
			ServicePermission servicePermission) {
		Role role = new Role();
		role.setName(name);
		List<ServicePermission> sps = new ArrayList<ServicePermission>();
		sps.add(servicePermission);
		role.setServicePermission(sps);
		try{
			em.getTransaction().begin();
			em.persist(role);
			em.getTransaction().commit();
			return role;
		
		}catch(Exception e){
			e.printStackTrace();
			return null;
			//TODO: throw exception
		}
	}

	@Override
	@RolesAllowed({"admin","superadmin"})
	public ServicePermission createServicePermission(
			Service service, Permission permission) {
		ServicePermission sp = new ServicePermission();
		sp.setService(service);
		sp.setPermission(permission);
		try{
			em.getTransaction().begin();
			em.persist(sp);
			em.getTransaction().commit();
			return sp;
		
		}catch(Exception e){
			e.printStackTrace();
			return null;
			//TODO: throw exception
		}
	}

	@Override
	@RolesAllowed({"admin","superadmin"})
	public Service createService(String name) {
		Service service = new Service();
		service.setName(name);
		try{
			em.getTransaction().begin();
			em.persist(service);
			em.getTransaction().commit();
			return service;
		
		}catch(Exception e){
			e.printStackTrace();
			return null;
			//TODO: throw exception
		}
		
	}

	@Override
	@RolesAllowed({"admin","superadmin"})
	public Permission createPermission(String name) {
		Permission permission = new Permission();
		permission.setName(name);
		try{
			em.getTransaction().begin();
			em.persist(permission);
			em.getTransaction().commit();
			return permission;
		
		}catch(Exception e){
			e.printStackTrace();
			return null;
			//TODO: throw exception
		}
	}
	
	
	

}
