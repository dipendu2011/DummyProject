package com.example.demo.response;

import java.util.UUID;

public class FetchEmployeeDetail {

	public String status;
	public String message;

	public String name;
	public String city;
	public UUID id;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
		return "FetchEmployeeDetail [status=" + status + ", message=" + message + ", name=" + name + ", city=" + city
				+ "]";
	}

}
