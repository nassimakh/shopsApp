package com.shops.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.shops.app.controllers.UserController;
import com.shops.app.dao.UserRepository;
import com.shops.app.entities.User;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
    private UserRepository userRepository;
	
	@Test
    public void connect() throws Exception {
		User u = new User("name@email.com", "password","name" );
		 given(userRepository.findByEmailAndPassword("name@email.com","password"))
         .willReturn(u);
		 String responseBody = "{\"content\":\"email\":\"name@email.com\",\"password\":\"password\",\"name\":\"name\"}";
 this.mockMvc.perform(get("/user/connect?email=name@email.com&password=password")
         .accept(MediaType.APPLICATION_JSON))
         .andExpect(status().isOk())
         .andExpect(content().string(responseBody));
		
	}

}
