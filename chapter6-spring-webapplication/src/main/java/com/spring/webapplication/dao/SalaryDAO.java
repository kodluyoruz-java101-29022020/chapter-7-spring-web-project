package com.spring.webapplication.dao;

import java.util.List;

import com.spring.webapplication.dao.entity.Salary;


public interface SalaryDAO {

	public List<Salary> getAll();
	public List<Salary> getSalariesOfEmployee(Long empNo);
}
