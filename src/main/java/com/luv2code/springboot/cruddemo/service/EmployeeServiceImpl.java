package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.transaction.Transactional;

@Component
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
		
	}
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
	
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theID) {
		// TODO Auto-generated method stub
		employeeDAO.deleteById(theID);
		
	}

	
	
	
}
