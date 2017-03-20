package io.letsTalk.springbootstarter.messages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.letsTalk.springbootstarter.users.UserDetails;

//Controller class to interact with the Resource URIs
@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	//Controller method to gather all the sent messages of a particular user
	@RequestMapping(method = RequestMethod.GET, value = "/letsTalk/users/{username}/sentMessages")
	public List<MessageDetails> getAllSentMessages(@PathVariable String username) {
		return messageService.getSentMessages(username);
	}

	//Controller method to gather all the received messages of a particular user
	@RequestMapping(method = RequestMethod.GET, value ="/letsTalk/users/{username}/receivedMessages")
	public List<MessageDetails> getAllReceivedMessages(@PathVariable String username) {
		return messageService.getReceivedMessages(username);
	}
	
	//Controller method to send a message from one user to another
	@RequestMapping(method = RequestMethod.POST, value = "/letsTalk/users/{sender}/sendMessage/{receiver}")
	public void addUser(@RequestBody MessageDetails message, @PathVariable String sender,
			@PathVariable String receiver) throws Exception {
		message.setSender(new UserDetails(sender, "", "", 0, "", "", ""));
		message.setReceiver(new UserDetails(receiver, "", "", 0, "", "", ""));
		messageService.addSingleMessage(message);
	}

	//Admin controller method to delete a message by its messageID
	@RequestMapping(method = RequestMethod.DELETE, value = "/letsTalk/users/{username}/messages/{messageId}")
	public void updateUser(@PathVariable String username, @PathVariable int messageId) {
		messageService.deleteMessage(messageId);
	}

}
