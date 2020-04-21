package com.spring.webapplication.service;

import java.util.List;

import com.spring.webapplication.dao.entity.Salary;

public interface SalaryService {

	public List<Salary> getAll();
	public List<Salary> getSalariesOfEmployee(Long empNo);
}
