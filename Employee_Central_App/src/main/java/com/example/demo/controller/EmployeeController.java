
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Employee;
import com.example.demo.request.EmployeeRequest;
import com.example.demo.response.BaseEmployeeResponse;
import com.example.demo.response.FetchEmployeeDetail;
import com.example.demo.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.example.demo.base.constant.ResourceEndpoints;

@RestController
@RequestMapping(ResourceEndpoints.BASE_ROUTE)
@Api(value = "Employee", description = "Employee Managament")
public class EmployeeController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmployeeService employeeService;

	/**
	 * 
	 * 
	 * @return List of EmployeeDetails
	 */
	@ApiOperation(value = "Get Employee Information")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Status OK"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(ResourceEndpoints.RETRIEVE_ALL)
	public List<Employee> getEmployees() {
		logger.debug("Enter into EmployeeController.getEmployees, Description: get All Employeess{}", new Date());
		List<Employee> response = new ArrayList<Employee>();
		response = employeeService.getAll();
		logger.debug("response of getEmployees : {} and time {}", response, new Date());
		return response;
	}

	/**
	 * 
	 * @param id
	 * @param request
	 * @return EmployeeDetails
	 */
	@ApiOperation(value = "Get Employee By Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Status OK"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(ResourceEndpoints.BYID)
	public FetchEmployeeDetail getEmployeeById(@PathVariable("id") UUID id, HttpServletRequest request) {
		logger.debug("Enter into EmployeeController.getEmployeeById, Description: get Employee id  Request: {}",
				request, new Date());
		return employeeService.getById(id);
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "Add Employee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Status OK"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 404, message = "Not Found") })
	@PostMapping(value = ResourceEndpoints.EMP_ADD, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseEmployeeResponse createEmployee(@RequestBody EmployeeRequest request) {
		logger.debug("Enter into EmployeeController.createEmployee, Request : EmployeeRequest : {} ", request,
				new Date());
		BaseEmployeeResponse response = employeeService.create(request);
		logger.debug("response of create : {} and time {}", response, new Date());
		return response;
	}

	// Delete Employee By id
	@ApiOperation(value = "Remove Employee By Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Status OK"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 404, message = "Not Found") })
	@DeleteMapping(ResourceEndpoints.REMOVE_BYID)
	public BaseEmployeeResponse removeByEmployeeId(@PathVariable("id") UUID id, HttpServletRequest request) {
		logger.debug(
				"Enter into EmployeeController.removeByEmployeeId, Description: remove Employee  by id  Request: {}",
				request, new Date());
		BaseEmployeeResponse response = employeeService.removeById(id);
		logger.debug("response of removeByEmployeeId : {} and time {}", response, new Date());
		return response;
	}

	@PutMapping(value = ResourceEndpoints.EMPPUT)
	public BaseEmployeeResponse updateEmployee(@PathVariable("id") UUID id, @RequestBody EmployeeRequest request) {
		logger.debug("Enter into EmployeeController.updateEmployee, Request : EmployeeRequest : {} ", request,
				new Date());
		BaseEmployeeResponse response = employeeService.update(id, request);
		logger.debug("response of update : {} and time {}", response, new Date());
		return response;
	}

	@ApiOperation(value = "Remove ALL Employees")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Status OK"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 404, message = "Not Found") })
	@DeleteMapping(ResourceEndpoints.REMOVE_ALL)
	public BaseEmployeeResponse removeAllEmployee(HttpServletRequest request) {
		logger.info("Enter into EmployeeController.removeAllEmployee, Description: remove All Employees : {}", request,
				new Date());
		BaseEmployeeResponse response = employeeService.removeAll();
		logger.debug("response of removeAllEmployees : {} and time {}", response, new Date());
		return response;

	}
}
