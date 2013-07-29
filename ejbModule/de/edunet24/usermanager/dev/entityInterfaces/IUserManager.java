package de.edunet24.usermanager.dev.entityInterfaces;


import java.util.HashMap;
import java.util.List;

import javax.ejb.Remote;

import de.edunet24.usermanager.dev.entityBeans.Attribute;
import de.edunet24.usermanager.dev.entityBeans.AttributeValue;
import de.edunet24.usermanager.dev.entityBeans.Client;
import de.edunet24.usermanager.dev.entityBeans.Permission;
import de.edunet24.usermanager.dev.entityBeans.Role;
import de.edunet24.usermanager.dev.entityBeans.Service;
import de.edunet24.usermanager.dev.entityBeans.ServicePermission;
import de.edunet24.usermanager.dev.entityBeans.User;
import de.edunet24.usermanager.dev.entityBeans.UserEntity;

/**
 * add User (UserEntity)
 * 
 * getUser
 * 
 * updateUser
 * 
 * deleteUser
 * 
 * @author toan vu
 * 
 */

@Remote
public interface IUserManager {

	/**
	 * create user with default parameter and given username and password
	 * @param pw
	 * @param username
	 * @return
	 */
	public User createUser(String pw, String username);

	public User createUser(String firstname, String lastname,
			String email, String pw, String username);
	
	public Client creatClient(String pwd, String username);

	public User addUser(User user);

	public User getUser(String username);

	public User getUser(int id);
	
	public List<User> getAllUser();

	public User getUser(HashMap<String, String> critics);

	// //update user
	public void updateUser(User user, HashMap<String, Object> cond);

	// / delete user
	public void deleteUser(User user, HashMap<String, String> cond);
	
	//option attribute
	public Attribute getAttribute(HashMap<String, String> cond);
	
	public void createAttribute(Attribute att);
	
	public void modifyAttribute(Attribute attr);
	
	public void deleteAttribute(Attribute attr);
	
	
	
	//attribute value pair

	public void getAttributeValuePair(HashMap<String, String> cond);
	
	public void createAttributeValuePair(Attribute att,Object value);
	
	public void addAttributeValuePair(AttributeValue av);
	
	public void modifyAttributeValuePair(AttributeValue av);
	
	public void deleteAttributeValuePair(AttributeValue av);
	
	
	//create role
	public Role createRole(String name, ServicePermission servicePermission);
	
	
	//create service permission
	public ServicePermission createServicePermission(Service service, Permission permission);
	
	//create service
	public Service createService(String name);
	
	//create permission
	public Permission createPermission(String name);
	
	
}
