package com.example.demo.response;

public class BaseEmployeeResponse {
	String status;
	String message;

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

	@Override
	public String toString() {
		return "BaseEmployeeResponse [status=" + status + ", message=" + message + "]";
	}

}
