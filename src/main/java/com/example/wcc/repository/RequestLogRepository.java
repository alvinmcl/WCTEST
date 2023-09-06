package com.example.wcc.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.wcc.model.RequestLog;

public interface RequestLogRepository extends MongoRepository<RequestLog, String> {
	
	@Aggregation(pipeline= {"{$match: {timeStamp: {$gte: ?0,$lt: ?1}}},{ $limit: 20 }"})
	List<RequestLog> searchRequestLogBetweenDate(Date greaterThanEqualDate, Date lessThanDate);
}
