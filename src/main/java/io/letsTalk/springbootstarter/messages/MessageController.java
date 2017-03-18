package io.letsTalk.springbootstarter.messages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.letsTalk.springbootstarter.users.UserDetails;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	@RequestMapping("/letsTalk/users/{uniqueUserName}/sentMessages")
	public List<MessageDetails> getAllSentMessages(@PathVariable String uniqueUserName) {
		return messageService.getSentMessages(uniqueUserName);
	}

	@RequestMapping("/letsTalk/users/{uniqueUserName}/receivedMessages")
	public List<MessageDetails> getAllReceivedMessages(@PathVariable String uniqueUserName) {
		return messageService.getReceivedMessages(uniqueUserName);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/letsTalk/users/{sender}/sendMessage/{receiver}")
	public void addUser(@RequestBody MessageDetails message, @PathVariable String sender,
			@PathVariable String receiver) {
		message.setSender(new UserDetails(sender, "", "", 0, "", "", ""));
		message.setReceiver(new UserDetails(receiver, "", "", 0, "", "", ""));
		messageService.addSingleMessage(message);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/letsTalk/users/{uniqueUserName}/messages/{messageId}")
	public void updateUser(@PathVariable String uniqueUserName, @PathVariable int messageId) {
		messageService.deleteMessage(messageId);
	}

}
