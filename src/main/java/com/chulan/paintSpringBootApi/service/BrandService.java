package com.chulan.paintSpringBootApi.service;

import java.util.List;

import com.chulan.paintSpringBootApi.model.Brand;

public interface BrandService {

	Brand save(Brand brand);
	List<Brand> findAll();
	Brand findOne(Long brandId);
	void delete(Brand brand);
}
