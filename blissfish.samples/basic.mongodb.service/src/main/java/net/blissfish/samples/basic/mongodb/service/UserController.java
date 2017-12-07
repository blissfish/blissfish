package net.blissfish.samples.basic.mongodb.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
		return userRepository.findAll(sortByCreatedAtDesc);
	}

	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping(value = "/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
		User user = userRepository.findOne(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}

	@PutMapping(value = "/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") String id, @Valid @RequestBody User user) {
		User userData = userRepository.findOne(id);
		if (userData == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userData.setEmail(user.getEmail());
		User updatedUser = userRepository.save(userData);
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping(value = "/users/{id}")
	public void deleteUser(@PathVariable("id") String id) {
		userRepository.delete(id);
	}
}
