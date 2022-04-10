package com.asset.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	public Category(String cat_name, String cat_description) {
		super();
		this.cat_name = cat_name;
		this.cat_description = cat_description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cat_id;

	private String cat_name;

	@Column(length = 1000)
	private String cat_description;

}
