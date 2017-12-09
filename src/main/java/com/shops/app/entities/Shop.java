package com.shops.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * This Class represents the entity Shop, this is mapped to the Document "shops"
 * @author Nassima
 *
 */
@Document(collection="shops")
public class Shop {
	@Id
	String id;
	String picture;
	String name;
	String email;
	String city;
	Location location;
	/**
	 * Default Constructor
	 */
	public Shop() {
		
	}
	/**
	 * Constructor for Shop using Fields
	 * @param picture
	 * @param name
	 * @param email
	 * @param city
	 * @param location
	 */
	public Shop(String picture, String name, String email, String city, Location location) {
		this.picture = picture;
		this.name = name;
		this.email = email;
		this.city = city;
		this.location = location;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	

}
