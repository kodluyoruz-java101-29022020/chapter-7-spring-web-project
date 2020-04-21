package com.spring.webapplication.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.webapplication.dao.entity.Salary;
import com.spring.webapplication.service.SalaryService;
import com.spring.webapplication.service.impl.SalaryJsonServiceImpl;

@RestController
@RequestMapping("/salary/api/v1")
public class SalaryController {

	@Autowired
	private SalaryService salaryService;
	
	@Autowired
	private SalaryJsonServiceImpl salaryJsonServiceImpl;
	
	
	@Cacheable(value = "salaries", cacheManager = "salaryCacheManager")
	@RequestMapping(value = "/salary/list", method = RequestMethod.GET)
	public List<Salary> getAll() {
		
		return salaryService.getAll();
	}
	
	@RequestMapping(value = "/salary/employee/{id}", method = RequestMethod.GET)
	public List<Salary> getSalariesOfEmployee(@PathVariable("id") Long empNo) {
		
		return salaryService.getSalariesOfEmployee(empNo);
	}
	
	@RequestMapping(value = "/data/json", method = RequestMethod.GET)
	public String prepareSalaryToJson(@RequestParam("id") Long id) throws JsonProcessingException {
		
		Salary salary = new Salary();
		salary.setSalary(id);
		salary.setToDate(new Date());
		
		return salaryJsonServiceImpl.convertToJson(salary);
	}
	
}
