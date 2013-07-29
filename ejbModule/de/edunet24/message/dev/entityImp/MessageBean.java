package de.edunet24.message.dev.entityImp;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.edunet24.message.dev.entityBeans.Group;
import de.edunet24.message.dev.entityBeans.Message;
import de.edunet24.message.dev.entityInterfaces.IMessage;
import de.edunet24.usermanager.dev.entityBeans.User;

@Stateless
@Remote (IMessage.class)
public class MessageBean implements IMessage{
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("edunet1");
	EntityManager em = emf.createEntityManager();
	
	@Override
	public Group createGroup(List<User> users) {
		Group group = new Group();
		group.setUsers(users);
		try{
			em.getTransaction().begin();
			em.persist(group);
			em.getTransaction().commit();
		}
		catch (Exception e){
			em.getTransaction().rollback();
			return null;
		}
		return group;
	}

	@Override
	public Group getGroupByUsers(List<User> users) {
		Group group = null;
		
		
		
		return group;
	}

	@Override
	public Message sendMsg(Group group, User subcriber) {
		Message msg = new Message();
		msg.setGroup(group);
		msg.setSubcriber(subcriber);
		
		try{
			em.getTransaction().begin();
			em.persist(msg);
			em.getTransaction().commit();
			
		}
		catch(Exception e){
			em.getTransaction().rollback();
			return null;
		}
		
		return msg;
	}

	@Override
	public List<Message> showMsgs(Group group) {
		// TODO Auto-generated method stub
		return null;
	}

}
