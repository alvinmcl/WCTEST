package com.example.wcc.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wcc.model.CalculateDistanceResult;
import com.example.wcc.model.Postcode;
import com.example.wcc.model.PostcodeDTO;
import com.example.wcc.repository.PostcodeRepository;

@Service
public class PostcodeService {
	@Autowired
	private PostcodeRepository repository;
	
	private final static double EARTH_RADIUS = 6371; // radius in kilometers
	
	
	public Optional<CalculateDistanceResult> getCalculateDistance(String postcodeOne, String postcodeTwo) {
		CalculateDistanceResult tempResultObject = new CalculateDistanceResult();
		Optional<CalculateDistanceResult> result = Optional.empty();
		List<Postcode> postcodeList = repository.getPostcodes(new String[] {postcodeOne, postcodeTwo});

		if(postcodeList != null && !postcodeList.isEmpty()) {
			tempResultObject.setPostcodeDTOOne(postcodeList.get(0));
			tempResultObject.setPostcodeDTOTwo(postcodeList.get(1));
			tempResultObject.setDistance(new BigDecimal(calculateDistance(tempResultObject.getPostcodeOne().getLatitude(),
					tempResultObject.getPostcodeOne().getLongitude(), 
					tempResultObject.getPostcodeTwo().getLatitude(), 
					tempResultObject.getPostcodeTwo().getLongitude())).setScale(3, RoundingMode.HALF_UP).doubleValue());
			tempResultObject.setDistanceUnitType("km");
			
			result = Optional.of(tempResultObject);
		}
		
		return result;
	}
	
	public Optional<PostcodeDTO> getSinglePostcode(String postcode) {
		Postcode tempPostcode = repository.getSinglePostcode(postcode);
		
		if (tempPostcode == null) {
			return Optional.empty();
		} else {
			return Optional.of(new PostcodeDTO(repository.getSinglePostcode(postcode)));
		}
	}
	
	private double calculateDistance(double latitude, double longitude, double latitude2, double longitude2) {
		double lon1Radians = Math.toRadians(longitude);
		double lon2Radians = Math.toRadians(longitude2);
		double lat1Radians = Math.toRadians(latitude);
		double lat2Radians = Math.toRadians(latitude2);
		double a = haversine(lat1Radians, lat2Radians)
		+ Math.cos(lat1Radians) * Math.cos(lat2Radians) * haversine(lon1Radians, lon2Radians);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return (EARTH_RADIUS * c);
	}
	private double haversine(double deg1, double deg2) {
		return square(Math.sin((deg1 - deg2) / 2.0));
	}
	private double square(double x) {
		return x * x;
	}
}
