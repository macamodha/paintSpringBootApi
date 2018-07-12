package com.chulan.paintSpringBootApi.service;

import java.util.List;

import com.chulan.paintSpringBootApi.model.Good;

public interface GoodService {
	Good save(Good good);
	List<Good> findAll();
	Good findOne(Long goodId);
	void delete(Good good);
}
