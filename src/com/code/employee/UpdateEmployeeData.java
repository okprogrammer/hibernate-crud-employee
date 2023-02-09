package com.code.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.employee.entity.Employee;

public class UpdateEmployeeData {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {
			// start the session
			session.beginTransaction();
			// update the id : 1 employee data
			int id = 1;
			// fetch employee data with id 1
			Employee e = session.get(Employee.class, id);
			// update the data
			e.setCompany("Apple");
			// commit the transaction
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}
}
