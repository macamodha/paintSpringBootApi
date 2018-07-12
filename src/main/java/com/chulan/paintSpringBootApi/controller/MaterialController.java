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

import com.chulan.paintSpringBootApi.model.Material;
import com.chulan.paintSpringBootApi.service.MaterialService;

@RestController
@RequestMapping("/material")
public class MaterialController {
	
	@Autowired
	MaterialService materialService;
	
	@PostMapping("/save")
	public Material createMaterial(@Valid @RequestBody Material material) {
		return materialService.save(material);
	}
	
	@GetMapping("/list")
	public List<Material> getAll() {
		return materialService.findAll();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Material> getOne(@PathVariable(value="id")Long matId) {
		Material mat = materialService.findOne(matId);
		if(mat==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(mat);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Material> updateMaterial(@PathVariable(value="id") Long matId,@Valid @RequestBody Material material ) {
		
		Material mat = materialService.findOne(matId);
		mat.setMatName(material.getMatName());
		mat.setMatStatus(material.getMatStatus());
		
		materialService.save(mat);
		return ResponseEntity.ok().body(mat);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Material> deleteMaterial(@PathVariable(value="id") Long matId) {
		Material mat = materialService.findOne(matId);
		if(mat==null) {
			return ResponseEntity.notFound().build();
		}
		materialService.delete(mat);
		return ResponseEntity.ok().build();
	}

}
