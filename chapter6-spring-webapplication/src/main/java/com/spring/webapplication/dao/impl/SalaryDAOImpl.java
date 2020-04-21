package com.spring.webapplication.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.webapplication.dao.SalaryDAO;
import com.spring.webapplication.dao.entity.Salary;

@Component
public class SalaryDAOImpl implements SalaryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Salary> getAll() {
		
		Session session = sessionFactory.openSession();
		
		Query<Salary> query = session.createQuery("select s from Salary s", Salary.class);
		
		List<Salary> result = query.getResultList();
		
		session.close();
		
		return result;
	}
	
	@Override
	public List<Salary> getSalariesOfEmployee(Long empNo) {
		
		Session session = sessionFactory.openSession();
		
		Query<Salary> query = session.createQuery("select s from Salary s where s.id.empNo = :empNo", Salary.class);
		
		query.setParameter("empNo", empNo);
		
		List<Salary> result = query.getResultList();
		
		session.close();
		
		return result;
	}
	
}
