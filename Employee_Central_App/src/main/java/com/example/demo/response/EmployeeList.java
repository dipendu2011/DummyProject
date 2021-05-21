package com.example.demo.response;

import java.util.List;

public class EmployeeList {

	private List<FetchEmployeeDetail> fetchResponse = null;
//	public String status;
//	public String message;

	public List<FetchEmployeeDetail> getFetchResponse() {
		return fetchResponse;
	}

	public void setFetchResponse(List<FetchEmployeeDetail> fetchResponse) {
		this.fetchResponse = fetchResponse;
	}

}
