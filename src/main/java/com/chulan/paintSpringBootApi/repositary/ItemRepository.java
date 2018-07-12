package com.chulan.paintSpringBootApi.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chulan.paintSpringBootApi.model.Item;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Long> {

}
