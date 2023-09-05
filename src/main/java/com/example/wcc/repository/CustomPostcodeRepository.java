package com.example.wcc.repository;

import java.util.List;

import com.example.wcc.model.Postcode;

public interface CustomPostcodeRepository {
	List<Postcode> getPostcodes(String[] postcodes);
}
