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

import com.chulan.paintSpringBootApi.model.ItemOrder;
import com.chulan.paintSpringBootApi.service.ItemOrderService;

@RestController
@RequestMapping("/order")
public class ItemOrderController {

	@Autowired
	ItemOrderService itemOrderService;
	
	@PostMapping("/save")
	public ItemOrder createOrder(@Valid @RequestBody ItemOrder order) {
		return itemOrderService.save(order);
	}
	
	@GetMapping("/list")
	public List<ItemOrder> getAllOrders() {
		return itemOrderService.findAll();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ItemOrder> getOneOrder(@PathVariable(value="id") Long orderId) {
		ItemOrder ord = itemOrderService.findOne(orderId);
		if(ord==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ord);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ItemOrder> updateOrder(@PathVariable(value="id") Long orderId,@Valid @RequestBody ItemOrder order) {
		ItemOrder ord = itemOrderService.findOne(orderId);
		if(ord==null) {
			return ResponseEntity.notFound().build();
		}
		ord.setOrderName(order.getOrderName());
		ord.setGoods(order.getGoods());
		itemOrderService.save(ord);
		return ResponseEntity.ok().body(ord);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ItemOrder> deleteOrder(@PathVariable(value="id")Long orderId) {
		ItemOrder ord = itemOrderService.findOne(orderId);
		if(ord==null) {
			return ResponseEntity.notFound().build();
		}
		itemOrderService.delete(ord);
		return ResponseEntity.ok().build();
	}
}
