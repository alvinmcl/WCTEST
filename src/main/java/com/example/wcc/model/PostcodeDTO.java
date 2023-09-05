package com.example.wcc.model;

import java.util.Optional;

public class PostcodeDTO {
	private String postcode;
	private double longitude;
	private double latitude;
	
	public PostcodeDTO(Postcode postcodeObj) {
		Optional<?> tempPostcodeObj = Optional.ofNullable(postcodeObj);
		if (tempPostcodeObj.isPresent()) {
			this.postcode = postcodeObj.getPostcode();
			this.longitude = postcodeObj.getLongitude();
			this.latitude = postcodeObj.getLatitude();
		}
	}

	public void setPostcodeDTO(Postcode postcodeObject) {
		this.postcode = postcodeObject.getPostcode();
		this.longitude = postcodeObject.getLongitude();
		this.latitude = postcodeObject.getLatitude();
	}
	
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
}
