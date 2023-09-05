package com.example.wcc.repository;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.example.wcc.model.Postcode;

public class CustomPostcodeRepositoryImpl implements CustomPostcodeRepository {

	private final MongoTemplate mongoTemplate;
	
	public CustomPostcodeRepositoryImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public List<Postcode> getPostcodes(String[] postcodes) {
		Query query = new Query().addCriteria(Criteria.where("postcode")
				.in(postcodes));
		
		return mongoTemplate.find(query, Postcode.class);
	}

}
