package com.chulan.paintSpringBootApi.service;

import java.util.List;

import com.chulan.paintSpringBootApi.model.ItemOrder;

public interface ItemOrderService {
	ItemOrder save(ItemOrder itemOrder);
	List<ItemOrder> findAll();
	ItemOrder findOne(Long itemOrderId);
	void delete(ItemOrder itemOrder);
}
