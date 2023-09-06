package com.example.wcc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.wcc.model.CalculateDistanceResult;
import com.example.wcc.model.Postcode;
import com.example.wcc.model.PostcodeDTO;
import com.example.wcc.service.PostcodeService;

@RestController
@RequestMapping("/postcode")
public class PostcodeController {
	@Autowired
	private PostcodeService postcodeService;
	
	@GetMapping("/{postcodeOne}/{postcodeTwo}")
	public ResponseEntity<?> calculatePostcodeDistance(
			@PathVariable String postcodeOne, @PathVariable String postcodeTwo) {
		Optional<CalculateDistanceResult> result = postcodeService.getCalculateDistance(postcodeOne, postcodeTwo);
		
		if (result.isPresent()) {
//			return ResponseEntity.ok(result.get());
			return ResponseEntity.ok(result);
		} else {
			return new ResponseEntity<Object>(new String("something occured"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/{postcode}")
	public ResponseEntity<?> testingPostcode(@PathVariable String postcode) {
		Optional<PostcodeDTO> result = postcodeService.getSinglePostcode(postcode);
		
		if (result.isPresent()) {
			return ResponseEntity.ok(result);
		} else {
			return new ResponseEntity<Object>(new String("something occured"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updatePostcode(@RequestBody PostcodeDTO postcodeObj) {
		Optional<PostcodeDTO> result = postcodeService.updatePostcode(postcodeObj);
		
		if (result.isPresent()) {
			return ResponseEntity.ok(result);
		} else {
			return new ResponseEntity<Object>(new String("something occured"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/search/{postcode}")
	public ResponseEntity<?> getAllPostcodeLimited(@PathVariable String postcode) {
		Optional<List<PostcodeDTO>> result = postcodeService.getAllPostcodeSearchLike(postcode);
		
		if (result.isPresent()) {
			return ResponseEntity.ok(result);
		} else {
			return new ResponseEntity<Object>(new String("something occured"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
