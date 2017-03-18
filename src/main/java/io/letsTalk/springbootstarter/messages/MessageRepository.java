package io.letsTalk.springbootstarter.messages;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.letsTalk.springbootstarter.users.UserDetails;

public interface MessageRepository extends CrudRepository<MessageDetails, Integer>{

	public List<MessageDetails> findBySenderUniqueUserName(String uniqueUserName);
	public List<MessageDetails> findByReceiverUniqueUserName(String uniqueUserName);
	
}
