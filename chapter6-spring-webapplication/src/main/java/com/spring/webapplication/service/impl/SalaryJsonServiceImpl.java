package com.spring.webapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.webapplication.dao.entity.Salary;
import com.spring.webapplication.service.json.SalaryJsonConverter;

@Component
public class SalaryJsonServiceImpl {

	@Autowired
	private SalaryJsonConverter jsonConverter;
	
	
	public String convertToJson(Salary salary) throws JsonProcessingException {
		
		return jsonConverter.convertToJson(salary);
	}
}
