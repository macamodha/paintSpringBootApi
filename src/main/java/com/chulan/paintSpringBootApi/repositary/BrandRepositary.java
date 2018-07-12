package com.chulan.paintSpringBootApi.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chulan.paintSpringBootApi.model.Brand;

@Repository("brandRepositary")
public interface BrandRepositary extends JpaRepository<Brand, Long>{

}
