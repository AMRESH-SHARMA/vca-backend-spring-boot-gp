package com.vca.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "subcategories")
public class SubCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

//  @ManyToOne(fetch = FetchType.EAGER, optional = false)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "category_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Category category;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

}
