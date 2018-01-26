package net.blissfish.samples.basic.restful.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private static final Map<String, User> users = new HashMap<String, User>();
	
	static {
        users.put("1", new User("1","hans","hans@email.com"));
        users.put("2", new User("2","peter","peter@email.com"));
        users.put("3", new User("3","mark","mark@email.com"));		
	}
	

	@RequestMapping("/user")
	public User getUser(@RequestParam(value = "id", defaultValue = "1") String id) throws UserNotFoundException {
		User user = users.get(id);
		if (user == null) {
			throw new UserNotFoundException("User with id ["+id+"] does not exist!");
		}
		return user;
	}
}