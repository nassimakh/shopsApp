package com.shops.app.entities;

/**
 * The Location class represents a geographic location (latitude and longitude)
 * @author Nassima
 *
 */
public class Location {

	double latitude;
	double longitude;
	
	public Location() {
		
	}
	/**
	 * Constructor for Location
	 * @param latitude
	 * @param longitude
	 */
	public Location(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
}
