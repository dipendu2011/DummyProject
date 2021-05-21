package com.example.demo.helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.request.EmployeeRequest;
import com.example.demo.response.BaseEmployeeResponse;
import com.example.demo.response.FetchEmployeeDetail;

@Component
public class EmployeeHelper {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAll() {
		logger.debug("Enter into EmployeeHelper.getAll, Description: get All Employees {}", new Date());
		List<Employee> employee = new ArrayList<Employee>();
		long count = employeeRepository.count();
		if (count != 0) {
			employee = employeeRepository.findAll();

		} else {
			logger.info("error while call EmployeeHelper.getAll method : {}");
		}
		logger.debug("response of getAll : {} and time {}", new Date());
		return employee;
	}

	public FetchEmployeeDetail getById(UUID id) {
		logger.debug("Enter into EmployeeHelper.getById, Description: get Employee id{}", new Date());
		FetchEmployeeDetail response = new FetchEmployeeDetail();
		Employee employee = employeeRepository.findId(id);
		if (null != employee) {
			response.setName(employee.getName());
			response.setCity(employee.getCity());
			response.setId(employee.getId());
			response.setMessage("Fetch Employee Successful");
			response.setStatus(Boolean.TRUE.toString());
		} else {
			logger.info("error while call EmployeeHelper.getById method : {}");
			response.setMessage("Fetch Failed---Employee id-" + id.toString() + "  not found---");
			response.setStatus(Boolean.FALSE.toString());
		}
		logger.debug("response of getById : {} and time {}", response, new Date());
		return response;
	}

	public BaseEmployeeResponse removeById(UUID id) {
		logger.debug("Enter into EmployeeHelper.removeById, Description: remove Employee  by id{}", new Date());
		BaseEmployeeResponse response = new BaseEmployeeResponse();
		Employee employee = employeeRepository.findId(id);
		if (null != employee) {
			employeeRepository.deleteById(id);
			response.setMessage("Deleted Successfully");
			response.setStatus(Boolean.TRUE.toString());
		} else {
			logger.info("error while call EmployeeHelper.removeById method : {}");
			response.setMessage("Delete Failed---Employee id-" + id.toString() + "  not found---");
			response.setStatus(Boolean.FALSE.toString());
		}
		logger.debug("response of removeById : {} and time {}", response, new Date());
		return response;
	}

	public BaseEmployeeResponse create(EmployeeRequest request) {
		logger.debug("Enter into EmployeeHelper.create, Request : EmployeeRequest : {} ", request, new Date());
		BaseEmployeeResponse response = new BaseEmployeeResponse();
		Employee employee = new Employee();
		employee.setId(UUID.randomUUID());
		employee.setName(request.getName());
		employee.setCity(request.getCity());
		employee = employeeRepository.save(employee);
		if (null != employee) {
			response.setMessage("Data Entered Successfully");
			response.setStatus(Boolean.TRUE.toString());
		} else {
			logger.info("error while call EmployeeHelper.create method : {}");
			response.setMessage("Data Entered Failed");
			response.setStatus(Boolean.FALSE.toString());
		}
		logger.debug("response of create : {} and time {}", response, new Date());
		return response;
	}

	public BaseEmployeeResponse removeAll() {
		logger.debug("Enter into EmployeeHelper.removeAll, Description: remove All Employees : {}", new Date());
		BaseEmployeeResponse response = new BaseEmployeeResponse();
		long count = employeeRepository.count();
		if (count != 0) {
			employeeRepository.deleteAll();
			response.setMessage("All Employees Removed");
			response.setStatus(Boolean.TRUE.toString());
		} else {
			logger.info("error while call EmployeeHelper.removeAll method : {}");
			response.setMessage("No Employee Present to Remove");
			response.setStatus(Boolean.FALSE.toString());
		}
		logger.debug("response of removeAllEmployee : {} and time {}", response, new Date());
		return response;
	}

	public BaseEmployeeResponse update(UUID id, EmployeeRequest request) {
		logger.debug("Enter into EmployeeHelper.update, Request : EmployeeRequest : {} ", request, new Date());
		BaseEmployeeResponse response = new BaseEmployeeResponse();

		if (employeeRepository.findById(id).isPresent()) {
			Employee employee = employeeRepository.findId(id);
			if (null != employee) {
				employee.setCity(request.getCity());
				employee.setName(request.getName());
				employeeRepository.save(employee);
				response.setMessage("Data Updated Successfully");
				response.setStatus(Boolean.TRUE.toString());
			} else {
				logger.info("error while call EmployeeHelper.update method : {}");
				response.setMessage("Update Failed");
				response.setStatus(Boolean.FALSE.toString());
			}
		} else {
			logger.info("error while call EmployeeHelper.update method : {}");
			response.setMessage("Update Failed---Employee id-" + id.toString() + "  not found---");
			response.setStatus(Boolean.FALSE.toString());
		}
		logger.debug("response of update : {} and time {}", response, new Date());
		return response;
	}

	public int findName(EmployeeRequest request) {
		return employeeRepository.findByName(request.getName());
	}

}
