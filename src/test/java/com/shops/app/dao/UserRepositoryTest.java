package com.shops.app.dao;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.shops.app.SpringMongoConfiguration;
import com.shops.app.entities.User;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringMongoConfiguration.class})
public class UserRepositoryTest {
	@Autowired
	UserRepository uRepo;
	
	@Before
	public void init() {
		User u = new User("name@email.com","password","name");
		uRepo.save(u);
	}

	@Test
	public void findByEmailTest() {
		User user = uRepo.findByEmail("name@email.com");
		Assert.assertNotNull(user);
	}

	@Test
	public void findByEmailAndPasswordTest_whenError() {
		User user = uRepo.findByEmailAndPassword("email", "password11");
		Assert.assertNull(user);
	}
}
