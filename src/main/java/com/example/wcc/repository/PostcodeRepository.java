package com.example.wcc.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.wcc.model.Postcode;

public interface PostcodeRepository extends MongoRepository<Postcode, String>{
	
	@Query("{'postcode':{'$in': ?0}}")
	List<Postcode> getPostcodes(String[] postcodes);
//	@Query("{$or:[{'postcode':?0},{'postcode':?1}]}")
//	List<Postcode> findByPostcodeOrPostcode(String postcodeOne,String postcodeTwo);
	
	
	@Query("{postcode:?0}")
	Postcode getSinglePostcode(String postcode);

}
