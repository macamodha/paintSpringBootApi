package com.chulan.paintSpringBootApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chulan.paintSpringBootApi.model.Material;
import com.chulan.paintSpringBootApi.repositary.MaterialRepositary;
import com.chulan.paintSpringBootApi.service.MaterialService;

@Service("materialService")
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	MaterialRepositary materialRepositary;

	 public Material save(Material material) {
		return materialRepositary.save(material);
	}

	public List<Material> findAll() {
		return materialRepositary.findAll();
	}

	public Material findOne(Long mTypeId) {
		return materialRepositary.findOne(mTypeId);
	}

	public void delete(Material material) {
		materialRepositary.delete(material);
	}
	
}
