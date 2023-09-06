package com.example.wcc.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wcc.model.RequestLog;
import com.example.wcc.repository.RequestLogRepository;

@Service
public class RequestLogService {
	@Autowired
	private RequestLogRepository requestLogRepository;
	
	public Optional<List<RequestLog>> getAllRequestLogBetweenDate(String greaterThanEqualDate, String lessThanDate){
		
		try {
			Date greaterThanEqualDateVal = new SimpleDateFormat("dd-MM-yyyy").parse(greaterThanEqualDate);
			Date lessThanDateVal = new SimpleDateFormat("dd-MM-yyyy").parse(lessThanDate);
			return Optional.ofNullable(requestLogRepository.searchRequestLogBetweenDate(greaterThanEqualDateVal, lessThanDateVal));
		} catch(Exception e) {
			return Optional.empty();
		}
	}
}
