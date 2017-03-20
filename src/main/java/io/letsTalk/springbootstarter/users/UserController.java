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
	
	//Controller method to retrieve all the users from the database
	@RequestMapping("/letsTalk/users")
	public List<UserDetails> getAllUsers()
	{
		return userService.getUsers();
	}
	
	//Controller method to retrieve a user of particular userName
	@RequestMapping("/letsTalk/users/{username}")
	public UserDetails getUser(@PathVariable String username)
	{
		return userService.getSingleUser(username);
	}
	
	//Controller method to register a new user
	@RequestMapping(method = RequestMethod.POST, value = "/letsTalk/register")
	public void addUser(@RequestBody UserDetails user)
	{
		userService.addSingleUser(user);
	}
	
	//Controller method to update the details of a particular user
	@RequestMapping(method = RequestMethod.PUT, value = "/letsTalk/users/{username}")
	public void updateUser(@RequestBody UserDetails user, @PathVariable String username)
	{
		userService.updateSingleUser(username, user);
	}
	
	//Controller method to delete a particular user from the database
	@RequestMapping(method = RequestMethod.DELETE, value = "/letsTalk/users/{username}")
	public void updateUser(@PathVariable String username)
	{
		userService.deleteUser(username);
	}
	
	
}
