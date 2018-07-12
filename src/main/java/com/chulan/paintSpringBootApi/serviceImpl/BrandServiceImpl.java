package com.chulan.paintSpringBootApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chulan.paintSpringBootApi.model.Brand;
import com.chulan.paintSpringBootApi.repositary.BrandRepositary;
import com.chulan.paintSpringBootApi.service.BrandService;

@Service("brandService")
public class BrandServiceImpl implements BrandService{

	@Autowired
	BrandRepositary brandRepositary;
	
	public Brand save(Brand brand) {
		return brandRepositary.save(brand);
	}

	public List<Brand> findAll() {
		return brandRepositary.findAll();
	}

	public Brand findOne(Long brandId) {
		return brandRepositary.findOne(brandId);
	}

	public void delete(Brand brand) {
		brandRepositary.delete(brand);
	}

}
