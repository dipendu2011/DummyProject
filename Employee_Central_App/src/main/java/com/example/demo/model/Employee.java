package com.example.demo.model;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("Employee")
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3641610702833898395L;
	@PrimaryKey
	private UUID id;
	private String name;
	private String city;

	public Employee() {

	}

	public Employee(UUID id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
}