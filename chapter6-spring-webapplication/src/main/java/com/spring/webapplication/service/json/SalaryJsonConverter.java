package com.spring.webapplication.service.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.webapplication.dao.entity.Salary;

public class SalaryJsonConverter {

	public String convertToJson(Salary salary) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(salary);
	}
	
}
