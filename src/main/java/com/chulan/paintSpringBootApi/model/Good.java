package com.chulan.paintSpringBootApi.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="good")
@EntityListeners(AuditingEntityListener.class)
public class Good {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="good_id")
	private Long id;
	
	@NotBlank
	@Size(min=1,max=20)
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date dateCreated;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {
					CascadeType.PERSIST,
					CascadeType.MERGE
			}, mappedBy="goods")
	private Set<ItemOrder> orders = new HashSet<ItemOrder>();


	//getters and setters goes here
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Set<ItemOrder> getOrders() {
		return orders;
	}

	public void setOrders(Set<ItemOrder> orders) {
		this.orders = orders;
	}
	
	
	

}
