package com.shops.app.controllers;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.shops.app.dao.UserRepository;
import com.shops.app.entities.User;
/**
 * Rest web service for User
 * the path: "/user"
 * @author Nassima
 *
 */
@RestController
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	UserRepository userRepository;
	/**
	 * the adduser method creates a new user if the given email is not already used
	 * @param name
	 * @param email
	 * @param password
	 * @return true when creating the user successfully
	 */
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public Boolean addUser(@QueryParam("name")String name,@QueryParam("email") String email,@QueryParam("password") String password){
		//Check if the email is already used, if it not: Add the new user
		User u = userRepository.findByEmail(email);
		if(u!=null) return false;
		u =new User(email, password, name);
		userRepository.save(u);
		return true;
	}
	/**
	 * the signin method returns a user using email and password
	 * @param email
	 * @param password
	 * @return User
	 */
	@RequestMapping(value="/signin",method=RequestMethod.GET)
	public User signin(@QueryParam("email") String email, @QueryParam("password") String password) {
		return userRepository.findByEmailAndPassword(email,password);
	}

	@RequestMapping(value="/connect",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> connect(@QueryParam("email") String email, @QueryParam("password") String password) {
		User u =userRepository.findByEmailAndPassword(email,password);
		return ResponseEntity.ok(u);
	}
}
