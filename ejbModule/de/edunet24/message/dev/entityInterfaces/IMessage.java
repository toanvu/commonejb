package de.edunet24.message.dev.entityInterfaces;

import java.util.List;

import javax.ejb.Remote;

import de.edunet24.message.dev.entityBeans.Group;
import de.edunet24.message.dev.entityBeans.Message;
import de.edunet24.usermanager.dev.entityBeans.User;

@Remote
public interface IMessage {

	public Group createGroup(List<User> users);
	
	public Group getGroupByUsers(List<User> users);
	
	// create new Message object
	public Message sendMsg(Group group, User subcriber);

	public List<Message> showMsgs(Group group);
	
}
