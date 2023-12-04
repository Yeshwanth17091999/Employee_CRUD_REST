package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl  implements EmployeeDAO{

	
	//define the fields for emtityManager
	
	private  EntityManager entityManager;
	
	
	// set up constructor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		
		// create a query
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);

		// execute query and get result set
		List<Employee> employees= theQuery.getResultList();
		// return the result
		return employees;
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		
		Employee theEmployee = entityManager.find(Employee.class, id);
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		
		Employee dbEmployee = entityManager.merge(theEmployee);
		return dbEmployee;
	}

	@Override
	public void deleteById(int theID) {
		// TODO Auto-generated method stub
		Employee theEmployee = entityManager.find(Employee.class, theID);
		
		entityManager.remove(theEmployee);
	}


	

}
