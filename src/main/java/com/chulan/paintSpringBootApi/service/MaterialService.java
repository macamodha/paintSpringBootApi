package com.chulan.paintSpringBootApi.service;

import java.util.List;

import com.chulan.paintSpringBootApi.model.Material;

public interface MaterialService {

	  Material save(Material material);
	  List<Material> findAll();
	  Material findOne(Long mTypeId);
	  void delete(Material material);
}
