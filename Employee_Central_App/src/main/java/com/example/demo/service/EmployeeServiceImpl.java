package com.example.demo.service;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.base.utils.CommonUtils;
import com.example.demo.helper.EmployeeHelper;
import com.example.demo.model.*;
import com.example.demo.request.EmployeeRequest;
import com.example.demo.response.BaseEmployeeResponse;
import com.example.demo.response.FetchEmployeeDetail;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EmployeeHelper employeeHelper;

	@Override
	public List<Employee> getAll() {
		logger.debug("Enter into EmployeeServiceImpl.getAll, Description: get All Employees {}", new Date());
		List<Employee> response = new ArrayList<Employee>();
		try {
			response = employeeHelper.getAll();
		} catch (Exception e) {
			logger.error("Error while getAll employees : ", e);
		}
		logger.debug("response of getAll : {} and time {}", response, new Date());
		return response;
	}

	@Override
	public FetchEmployeeDetail getById(UUID id) {
		logger.debug("Enter into EmployeeServiceImpl.getById, Description: get Employee id{}", new Date());
		FetchEmployeeDetail response = new FetchEmployeeDetail();
		try {
			if (!CommonUtils.isEmpty(id)) {
				response = employeeHelper.getById(id);
			} else {
				logger.info("error while call EmployeeServiceImpl.getById method : {}");
				response.setStatus(Boolean.FALSE.toString());
				response.setMessage("Enter valid Data");
			}
		} catch (Exception e) {
			logger.error("Error while get employee : ", e);
			response.setStatus(Boolean.FALSE.toString());
			response.setMessage("exception in getbyid");
		}
		logger.debug("response of getById : {} and time {}", response, new Date());
		return response;
	}

	@Override
	public BaseEmployeeResponse removeById(UUID id) {
		logger.debug("Enter into EmployeeServiceImpl.removeById, Description: remove Employee  by id{}", new Date());
		BaseEmployeeResponse response = new BaseEmployeeResponse();
		try {
			if (!CommonUtils.isEmpty(id)) {
				response = employeeHelper.removeById(id);
			} else {
				logger.info("error while call EmployeeServiceImpl.removeById method : {}");
				response.setStatus(Boolean.FALSE.toString());
				response.setMessage("Enter valid Data");
			}
		} catch (Exception e) {
			logger.error("Error while remove employee : ", e);
			response.setStatus(Boolean.FALSE.toString());
			response.setMessage("exception in removebyid");
		}
		logger.debug("response of removeById : {} and time {}", response, new Date());
		return response;

	}

	@Override
	public BaseEmployeeResponse create(EmployeeRequest request) {
		logger.debug("Enter into EmployeeServiceImpl.create, Request : EmployeeRequest : {} ", request, new Date());
		int name_count = 0;
		BaseEmployeeResponse response = new BaseEmployeeResponse();
		try {
			if (!CommonUtils.isEmpty(request.getName()) && !CommonUtils.isEmpty(request.getCity())) {
				name_count = employeeHelper.findName(request);
				if (name_count == 0) {
					if (!CommonUtils.check(request.getName()))
						response = employeeHelper.create(request);
					else {
						logger.info("start name with alphabet");
						response.setStatus(Boolean.FALSE.toString());
						response.setMessage("start name with alphabet");
					}
				} else {
					logger.info("name already exist");
					response.setStatus(Boolean.FALSE.toString());
					response.setMessage("name already exist");
				}
			} else {
				logger.info("error while call EmployeeServiceImpl.create method : {}");
				response.setStatus(Boolean.FALSE.toString());
				response.setMessage("Enter valid Data");
			}
		} catch (Exception e) {
			logger.error("Error while create : ", e);
			response.setStatus(Boolean.FALSE.toString());
			response.setMessage("exception in create");
		}
		logger.debug("response of create : {} and time {}", response, new Date());
		return response;
	}

	@Override
	public BaseEmployeeResponse removeAll() {
		logger.debug("Enter into EmployeeServiceImpl.removeAll, Description: remove All Employees : {}", new Date());
		BaseEmployeeResponse response = new BaseEmployeeResponse();
		try {
			response = employeeHelper.removeAll();
		} catch (Exception e) {
			logger.error("Error while removeAll : ", e);
		}
		logger.debug("response of removeAll : {} and time {}", response, new Date());
		return response;
	}

	@Override
	public BaseEmployeeResponse update(UUID id, EmployeeRequest request) {
		logger.debug("Enter into EmployeeServiceImpl.update, Request : EmployeeRequest : {} ", request, new Date());
		BaseEmployeeResponse response = new BaseEmployeeResponse();
		int name_count = 0;
		try {
			if (!CommonUtils.isEmpty(request.getName()) && !CommonUtils.isEmpty(request.getCity())) {
				name_count = employeeHelper.findName(request);
				if (name_count == 0) {
					response = employeeHelper.update(id, request);

				} else {
					logger.info("name already exist");
					response.setStatus(Boolean.FALSE.toString());
					response.setMessage("name already exist");
				}
			} else {
				logger.info("error while call EmployeeServiceImpl.update method : {}");
				response.setStatus(Boolean.FALSE.toString());
				response.setMessage("Enter valid Data");
			}
		} catch (Exception e) {
			logger.info("error while call EmployeeServiceImpl.update method ", e);
			response.setStatus(Boolean.FALSE.toString());
			response.setMessage("Enter valid Data");
		}
		logger.debug("response of update : {} and time {}", response, new Date());
		return response;
	}

}