package com.chulan.paintSpringBootApi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="item_order")
public class ItemOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="itemOrder_id")
	private Long id;
	
	@NotBlank
	@Size(min=1,max=20)
	private String orderName;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(name="map_order_goods",
		joinColumns = {@JoinColumn(name="itemOrder_id")},
		inverseJoinColumns = {@JoinColumn(name="good_id")})
	private Set<Good> goods = new HashSet<Good>();

	
	//Getters setters goes here
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Set<Good> getGoods() {
		return goods;
	}

	public void setGoods(Set<Good> goods) {
		this.goods = goods;
	}
	
	
	
}
