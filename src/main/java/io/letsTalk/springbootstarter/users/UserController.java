package io.letsTalk.springbootstarter.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/letsTalk/users")
	public List<UserDetails> getAllUsers()
	{
		return userService.getUsers();
	}
	
	@RequestMapping("/letsTalk/users/{uniqueUserName}")
	public UserDetails getUser(@PathVariable String uniqueUserName)
	{
		return userService.getSingleUser(uniqueUserName);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/letsTalk/register")
	public void addUser(@RequestBody UserDetails user)
	{
		userService.addSingleUser(user);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/letsTalk/register/{uniqueUserName}")
	public void updateUser(@RequestBody UserDetails user, @PathVariable String uniqueUserName)
	{
		userService.updateSingleUser(uniqueUserName, user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/letsTalk/users/{uniqueUserName}")
	public void updateUser(@PathVariable String uniqueUserName)
	{
		userService.deleteUser(uniqueUserName);
	}
	
	
}
