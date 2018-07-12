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

import com.chulan.paintSpringBootApi.model.Item;
import com.chulan.paintSpringBootApi.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@PostMapping("/save")
	public Item createItem(@Valid @RequestBody Item item) {
		return itemService.save(item);
	}
	
	@GetMapping("/list")
	public List<Item> getItemList() {
		return itemService.findAll();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Item> getOneItem(@PathVariable(value="id") Long itemId) {
		Item itm = itemService.findOne(itemId);
		if(itm==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(itm);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Item> updateOneItem(@PathVariable(value="id")Long itemId, @Valid @RequestBody Item item) {
		itemService.save(item);
		return ResponseEntity.ok().body(item);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Item> deleteItem(@PathVariable(value="id")Long itemId) {
		Item itm = itemService.findOne(itemId);
		if(itm==null) {
			return ResponseEntity.notFound().build();
		}
		itemService.delete(itm);
		return ResponseEntity.ok().build();
	}

}
