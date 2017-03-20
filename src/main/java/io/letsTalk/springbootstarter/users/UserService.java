package io.letsTalk.springbootstarter.users;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.TomcatPrincipal;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	//Method to retrieve all the users from the database
	public List<UserDetails> getUsers() {

		List<UserDetails> usersList = new ArrayList<>();
		userRepository.findAll().forEach(usersList::add);
		return usersList;
	}

	//Method to retrieve the details of a single userName on the basis of its username
	public UserDetails getSingleUser(String username) {
		UserDetails user = userRepository.findOne(username);
		return userRepository.findOne(username);
	}

	//Method to add a new user onto the database
	public void addSingleUser(UserDetails user) {
		userRepository.save(user);
		Role role = new Role();
		role.setUsername(user.getUsername());
		role.setRole("ROLE_USER");
		roleRepository.save(role);
	}

	//Method to update the details of the user, on the basis of its userName
	public void updateSingleUser(String username, UserDetails user) {
		userRepository.save(user);
	}

	//Method to delete a user from the database
	public void deleteUser(String username) {
		userRepository.delete(username);
	}

}
