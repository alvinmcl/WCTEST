package com.example.wcc.model;



import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "requestlog")
public class RequestLog {
	@Id
	private String _id;
	private String postcodeOne;
	private String postcodeTwo;
	private CalculateDistanceResult calculateDistanceResult;
	private Instant timeStamp;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getPostcodeOne() {
		return postcodeOne;
	}
	public void setPostcodeOne(String postcodeOne) {
		this.postcodeOne = postcodeOne;
	}
	public String getPostcodeTwo() {
		return postcodeTwo;
	}
	public void setPostcodeTwo(String postcodeTwo) {
		this.postcodeTwo = postcodeTwo;
	}
	public CalculateDistanceResult getCalculateDistanceResult() {
		return calculateDistanceResult;
	}
	public void setCalculateDistanceResult(CalculateDistanceResult calculateDistanceResult) {
		this.calculateDistanceResult = calculateDistanceResult;
	}
	public Instant getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Instant timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
