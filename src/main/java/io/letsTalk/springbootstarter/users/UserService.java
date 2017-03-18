package io.letsTalk.springbootstarter.users;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.TomcatPrincipal;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;

	public List<UserDetails> getUsers() {

		List<UserDetails> usersList = new ArrayList<>();
		userRepository.findAll().forEach(usersList::add);
		return usersList;
	}

	public UserDetails getSingleUser(String uniqueUserName) {
		UserDetails user = userRepository.findOne(uniqueUserName);
		return userRepository.findOne(uniqueUserName);
	}

	public void addSingleUser(UserDetails user) {
		userRepository.save(user);
	}

	public void updateSingleUser(String uniqueUserName, UserDetails user) {
		userRepository.save(user);
	}

	public void deleteUser(String uniqueUserName) {
		userRepository.delete(uniqueUserName);
	}

}
