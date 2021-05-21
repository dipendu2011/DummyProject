package com.example.demo.converter;

import java.util.Optional;

import com.example.demo.model.Employee;

public class EmployeeConverter {

	public static Employee convertToEmployee(Employee domain) {
		if (domain != null) {
			Employee employee = new Employee();
			employee.setId(domain.getId());
			employee.setName(domain.getName());
			employee.setCity(domain.getCity());
			return employee;
		}
		return null;
	}

}
