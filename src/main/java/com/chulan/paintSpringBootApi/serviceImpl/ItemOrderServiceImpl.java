package com.chulan.paintSpringBootApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chulan.paintSpringBootApi.model.ItemOrder;
import com.chulan.paintSpringBootApi.repositary.ItemOrderRepository;
import com.chulan.paintSpringBootApi.service.ItemOrderService;

@Service("itemOrderService")
public class ItemOrderServiceImpl implements ItemOrderService{

	@Autowired
	ItemOrderRepository itemOrderRepository;
	
	public ItemOrder save(ItemOrder order) {
		return itemOrderRepository.save(order);
	}

	public List<ItemOrder> findAll() {
		return itemOrderRepository.findAll();
	}

	public ItemOrder findOne(Long orderId) {
		return itemOrderRepository.findOne(orderId);
	}

	public void delete(ItemOrder order) {
		itemOrderRepository.delete(order);
	}

}
