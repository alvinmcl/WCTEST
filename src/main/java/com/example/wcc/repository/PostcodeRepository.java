package com.example.wcc.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.wcc.model.Postcode;

public interface PostcodeRepository extends MongoRepository<Postcode, String>{
	
	@Query("{'postcode':{'$in': ?0}}")
	List<Postcode> getPostcodes(String[] postcodes);
	
	
	@Query("{postcode:?0}")
	Postcode getSinglePostcode(String postcode);


	Optional<Postcode> findByPostcode(String postcode);
	
	@Aggregation(pipeline= {"{$match: {postcode: {$regex: ?0,$options: 'm'}}},{ $limit: 20 }"})
	Optional<List<Postcode>> getAllPostcodeSearchLike(String postcode);

}
