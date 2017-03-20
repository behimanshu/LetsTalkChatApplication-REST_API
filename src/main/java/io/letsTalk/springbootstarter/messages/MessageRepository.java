package io.letsTalk.springbootstarter.messages;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.letsTalk.springbootstarter.users.UserDetails;


//Repository class to interact with database and fetch the results
public interface MessageRepository extends CrudRepository<MessageDetails, Integer>{
	
	//Method to pull the records by mapping the sender column of MessageDetails and userName column of UserDetails
	public List<MessageDetails> findBySenderUsername(String username);
	
	//Method to pull the records by mapping the receiver column of MessageDetails and userName column of UserDetails
	public List<MessageDetails> findByReceiverUsername(String username);
	
}
