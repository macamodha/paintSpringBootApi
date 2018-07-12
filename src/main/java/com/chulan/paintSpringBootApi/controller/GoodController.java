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

import com.chulan.paintSpringBootApi.model.Good;
import com.chulan.paintSpringBootApi.service.GoodService;

@RestController
@RequestMapping("/good")
public class GoodController {
	
	@Autowired
	GoodService goodService;

	@PostMapping("/save")
	public Good createGood(@Valid @RequestBody Good good) {
		return goodService.save(good);
	}
	
	@GetMapping("/list")
	public List<Good> getAllGoods(){
		return goodService.findAll();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Good> getOneGood(@PathVariable(value="id")Long goodId) {
		Good gd = goodService.findOne(goodId);
		if(gd==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(gd);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Good> updateGood(@PathVariable(value="id")Long goodId, @Valid @RequestBody Good good) {
		Good gd = goodService.findOne(goodId);
		if(gd==null) {
			return ResponseEntity.notFound().build();
		}
		gd.setName(good.getName());
		gd.setOrders(good.getOrders());
		goodService.save(gd);
		return ResponseEntity.ok().body(gd);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Good> deleteGood(@PathVariable(value="id")Long goodId) {
		Good gd = goodService.findOne(goodId);
		if(gd==null) {
			return ResponseEntity.notFound().build();
		}
		goodService.delete(gd);
		return ResponseEntity.ok().build();
	}
}
