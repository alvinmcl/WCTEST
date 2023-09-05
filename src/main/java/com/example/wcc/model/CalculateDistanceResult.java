package com.example.wcc.model;

public class CalculateDistanceResult {
	private PostcodeDTO postcodeOne;
	private PostcodeDTO postcodeTwo;
	private double distance;
	private String distanceUnitType;
	
	public CalculateDistanceResult() {}

	public void setPostcodeDTOOne(Postcode postcodeObj) {
		this.postcodeOne = new PostcodeDTO(postcodeObj);
	}
	public PostcodeDTO getPostcodeOne() {
		return postcodeOne;
	}
	public void setPostcodeDTOTwo(Postcode postcodeObj) {
		this.postcodeTwo = new PostcodeDTO(postcodeObj);
	}
	public PostcodeDTO getPostcodeTwo() {
		return postcodeTwo;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getDistanceUnitType() {
		return distanceUnitType;
	}
	public void setDistanceUnitType(String distanceUnitType) {
		this.distanceUnitType = distanceUnitType;
	}
	
	
}
