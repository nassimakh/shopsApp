package com.shops.app.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
	* This class represents the entite 'user', wich is mapped to Document "users"
	* @author Nassima
*/

@Document(collection="users")
public class User {
	@Id
	String id;
	String email;
	String password;
	String name;
	List<String> preferredShopsIds;
	
	public User() {
		preferredShopsIds = new ArrayList<String>();
	}
	/**
	 * Constructor of User
	 * @param email
	 * @param password
	 * @param name
	 */
	public User(String email, String password, String name) {
		this.email = email;
		this.password = password;
		this.name = name;
		preferredShopsIds = new ArrayList<String>();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPreferredShops() {
		return preferredShopsIds;
	}
	public void setPreferredShops(List<String> preferredShopsIds) {
		this.preferredShopsIds = preferredShopsIds;
	}
	
}
