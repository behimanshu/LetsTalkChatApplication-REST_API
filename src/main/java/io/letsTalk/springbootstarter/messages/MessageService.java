package io.letsTalk.springbootstarter.messages;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.TomcatPrincipal;
import org.apache.catalina.User;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.letsTalk.springbootstarter.users.UserDetails;
import io.letsTalk.springbootstarter.users.UserRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private UserRepository userRepository;

	// method to retrieve all the messages from the database and adding into a
	// list
	public List<MessageDetails> getMessages() {
		List<MessageDetails> messagesList = new ArrayList<>();
		messageRepository.findAll().forEach(messagesList::add);
		return messagesList;
	}

	// method to add a single message onto the database
	public void addSingleMessage(MessageDetails message) throws Exception {
		UserDetails user = userRepository.findOne(message.getReceiver().getUsername());
		if (user == null)
			throw new Exception();
		else
			messageRepository.save(message);
	}

	// method to delete one message from the database
	public void deleteMessage(int messageId) {
		messageRepository.delete(messageId);
	}

	// method to retrieve all received messages of a particular userName
	public List<MessageDetails> getReceivedMessages(String username) {
		List<MessageDetails> receivedMessagesList = new ArrayList<>();
		messageRepository.findByReceiverUsername(username).forEach(receivedMessagesList::add);
		return receivedMessagesList;
	}

	// method to retrieve all sent messages of a particular userName
	public List<MessageDetails> getSentMessages(String username) {
		List<MessageDetails> sentMessagesList = new ArrayList<>();
		messageRepository.findBySenderUsername(username).forEach(sentMessagesList::add);
		return sentMessagesList;
	}

}
