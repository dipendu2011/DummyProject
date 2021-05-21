package com.example.demo.request;

import java.util.UUID;

public class EmployeeRequest {
	String name;
	String city;
	UUID id;

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
		return "EmployeeRequest [name=" + name + ", city=" + city + "]";
	}

}
