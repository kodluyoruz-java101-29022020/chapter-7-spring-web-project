package com.spring.webapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.webapplication.dao.SalaryDAO;
import com.spring.webapplication.dao.entity.Salary;
import com.spring.webapplication.service.SalaryService;

public class SalaryServiceImpl implements SalaryService {

	@Autowired
	private SalaryDAO salaryDao;
	
	
	@Override
	public List<Salary> getAll() {
		
		return salaryDao.getAll();
	}

	@Override
	public List<Salary> getSalariesOfEmployee(Long empNo) {
		
		return salaryDao.getSalariesOfEmployee(empNo);
	}

}
