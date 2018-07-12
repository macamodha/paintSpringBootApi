package com.chulan.paintSpringBootApi.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chulan.paintSpringBootApi.model.ItemOrder;

@Repository("itemOrderRepository")
public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long>{

}
