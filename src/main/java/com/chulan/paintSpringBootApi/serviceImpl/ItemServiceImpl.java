package com.chulan.paintSpringBootApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chulan.paintSpringBootApi.model.Item;
import com.chulan.paintSpringBootApi.repositary.ItemRepository;
import com.chulan.paintSpringBootApi.service.ItemService;

@Service("itemService")
public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemRepository itemRepository;
	
	
	public Item save(Item item) {
		return itemRepository.save(item);
	}

	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	public Item findOne(Long itemId) {
		return itemRepository.findOne(itemId);
	}

	public void delete(Item item) {
		itemRepository.delete(item);
	}

}
