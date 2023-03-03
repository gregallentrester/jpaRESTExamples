package com.example.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;


@Entity
public class Vendor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String appellation;
	private String product;

	protected Vendor() { }

	public Vendor(String moniker, String productVal) {
		appellation = moniker;
		product = productVal;
	}

	@Override
	public String toString() {
		return
			"Vendor [" +
			"id= " + id +
			", appellation= " + appellation +
			", product= " + product + "]";
	}

	public Long getId() { return id; }
	public String getAppellation() { return appellation; }
	public String getProduct() { return product; }
}
