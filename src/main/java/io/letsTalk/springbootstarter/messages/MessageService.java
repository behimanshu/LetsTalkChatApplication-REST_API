package io.letsTalk.springbootstarter.messages;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.TomcatPrincipal;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;

	public List<MessageDetails> getMessages() {

		List<MessageDetails> messagesList = new ArrayList<>();
		messageRepository.findAll().forEach(messagesList::add);
		return messagesList;

	}


	public void addSingleMessage(MessageDetails message) {
		messageRepository.save(message);
	}

	public void deleteMessage(int messageId) {

		messageRepository.delete(messageId);

	}


	public List<MessageDetails> getReceivedMessages(String uniqueUserName) {
		List<MessageDetails> receivedMessagesList = new ArrayList<>();
		messageRepository.findByReceiverUniqueUserName(uniqueUserName)
		.forEach(receivedMessagesList::add);
		return receivedMessagesList;
	}

	public List<MessageDetails> getSentMessages(String uniqueUserName) {
		List<MessageDetails> sentMessagesList = new ArrayList<>();
		messageRepository.findBySenderUniqueUserName(uniqueUserName)
		.forEach(sentMessagesList::add);
		return sentMessagesList;
	}

}
