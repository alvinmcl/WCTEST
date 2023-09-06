package com.example.wcc.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.wcc.model.RequestLog;
import com.example.wcc.service.RequestLogService;

@Controller
@RequestMapping("/requestlog")
public class RequestLogController {
	@Autowired
	private RequestLogService requestLogService;
	
	@GetMapping("/search/{greaterThanEqualDate}/{lessThanDate}")
	public ResponseEntity<?> getAllRequestLogBetweenDate(@PathVariable String greaterThanEqualDate, @PathVariable String lessThanDate) {
		Optional<List<RequestLog>> result = requestLogService.getAllRequestLogBetweenDate(greaterThanEqualDate, lessThanDate);
		
		if (result.isPresent()) {
			return ResponseEntity.ok(result);
		} else {
			return new ResponseEntity<Object>(new String("something occured"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
