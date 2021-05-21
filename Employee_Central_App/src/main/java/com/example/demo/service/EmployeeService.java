package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.*;
import com.example.demo.request.EmployeeRequest;
import com.example.demo.response.BaseEmployeeResponse;
import com.example.demo.response.FetchEmployeeDetail;

public interface EmployeeService {

	List<Employee> getAll();

	BaseEmployeeResponse create(EmployeeRequest request);

	public FetchEmployeeDetail getById(UUID id);

	public BaseEmployeeResponse removeById(UUID id);

	public BaseEmployeeResponse removeAll();

	BaseEmployeeResponse update(UUID id, EmployeeRequest request);

}
