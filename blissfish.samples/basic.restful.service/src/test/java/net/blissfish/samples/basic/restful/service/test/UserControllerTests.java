package net.blissfish.samples.basic.restful.service.test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void noParamUserShouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/user")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.email").value("hans@email.com"));
	}

	@Test
	public void paramUserShouldReturnTailoredMessage() throws Exception {
		this.mockMvc.perform(get("/user").param("id", "2"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.email").value("peter@email.com"));
	}

}