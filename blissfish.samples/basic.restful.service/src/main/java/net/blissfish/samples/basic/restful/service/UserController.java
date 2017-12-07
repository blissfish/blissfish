package net.blissfish.samples.basic.restful.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/user")
	public User getUser(@RequestParam(value = "email", defaultValue = "Hans") String email) {
		return new User(String.format(email));
	}
}