package com.example.wcc.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "postcode")
public class Postcode {
	
	@Id
	private String _id;
	private String postcode;
	private double longitude;
	private double latitude;
	
	public Postcode(String _id, String postcode, double longitude, double latitude) {
		super();
		this._id = _id;
		this.postcode = postcode;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public Postcode() {	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
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
