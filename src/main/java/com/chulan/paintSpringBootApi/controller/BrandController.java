package com.chulan.paintSpringBootApi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chulan.paintSpringBootApi.model.Brand;
import com.chulan.paintSpringBootApi.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	BrandService brandService;
	
	@PostMapping("/save")
	public Brand createBrand(@Valid @RequestBody Brand brand) {
		return brandService.save(brand);
	}
	
	@GetMapping("/list")
	public List<Brand> getAllBrands(){
		return brandService.findAll();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Brand> getOneBrand(@PathVariable(value="id")Long brandId) {
		Brand br = brandService.findOne(brandId);
		if(br==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(br);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Brand> updateBrand(@PathVariable(value="id") Long brandId, @Valid @RequestBody Brand brand) {
		brandService.save(brand);
		return ResponseEntity.ok().body(brand);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Brand> deletebrand(@PathVariable(value="id")Long brandId){
		Brand br = brandService.findOne(brandId);
		if(br==null) {
			return ResponseEntity.notFound().build();
		}
		brandService.delete(br);
		return ResponseEntity.ok().build();
		
	}
}
