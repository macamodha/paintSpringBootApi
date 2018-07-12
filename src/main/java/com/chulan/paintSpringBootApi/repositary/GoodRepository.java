package com.chulan.paintSpringBootApi.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chulan.paintSpringBootApi.model.Good;

@Repository("goodRepository")
public interface GoodRepository extends JpaRepository<Good, Long>{

}
