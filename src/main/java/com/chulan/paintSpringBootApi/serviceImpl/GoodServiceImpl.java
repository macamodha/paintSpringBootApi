package com.chulan.paintSpringBootApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chulan.paintSpringBootApi.model.Good;
import com.chulan.paintSpringBootApi.repositary.GoodRepository;
import com.chulan.paintSpringBootApi.service.GoodService;

@Service("goodService")
public class GoodServiceImpl implements GoodService {

	@Autowired
	GoodRepository goodRepository;
	
	public Good save(Good good) {
		return goodRepository.save(good);
	}

	public List<Good> findAll() {
		return goodRepository.findAll();
	}

	public Good findOne(Long goodId) {
		return goodRepository.findOne(goodId);
	}

	public void delete(Good good) {
		goodRepository.delete(good);
	}

}
