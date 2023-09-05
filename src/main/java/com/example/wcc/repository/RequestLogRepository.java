package com.example.wcc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.wcc.model.RequestLog;

public interface RequestLogRepository extends MongoRepository<RequestLog, String> {

}
