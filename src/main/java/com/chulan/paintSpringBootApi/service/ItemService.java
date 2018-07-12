package com.chulan.paintSpringBootApi.service;

import java.util.List;

import com.chulan.paintSpringBootApi.model.Item;

public interface ItemService {

	Item save(Item item);
	List<Item> findAll();
	Item findOne(Long itemId);
	void delete(Item item);
}
