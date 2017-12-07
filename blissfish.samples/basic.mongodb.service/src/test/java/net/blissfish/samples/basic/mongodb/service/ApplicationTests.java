package net.blissfish.samples.basic.mongodb.service;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationTests.class);	

	@Autowired
	UserRepository userRepository;
	
	@Before
	public void setUp() {
		userRepository.deleteAll();
	}
	@After 
	public void shutDown() {
		userRepository.deleteAll();
		assertTrue(userRepository.count()==0);

	}
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void createUsers() {
		User user = new  User("mark.evertz@gmx.deee");
		userRepository.save(user);
		assertTrue(userRepository.count()==1);
		logger.debug("************************************** ApplicationTests.createUsers() "+user);

		//System.err.println("************************************** ApplicationTests.createUsers() "+user);
		userRepository.delete(user);
		assertTrue(userRepository.count()==0);		  
	}

}
