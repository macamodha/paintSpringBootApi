package com.chulan.paintSpringBootApi.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chulan.paintSpringBootApi.model.Material;

@Repository("materialRepositary")
public interface MaterialRepositary extends JpaRepository<Material, Long> {

}
