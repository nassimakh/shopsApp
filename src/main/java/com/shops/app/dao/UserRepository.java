package com.shops.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.shops.app.entities.User;
/**
 * UserRepository defines custom methods for interaction with the MongoRepository
 * @author Nassima
 *
 */
public interface UserRepository extends MongoRepository<User, String>{
	/**
	 * finds a user by email
	 * @param email
	 * @return User
	 */
	public User findByEmail(String email);
	/**
	 * finds a user by email and password
	 * @param email
	 * @param password
	 * @return User
	 */
	public User findByEmailAndPassword(String email, String password);
}
