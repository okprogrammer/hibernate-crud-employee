package com.code.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.employee.entity.Employee;

public class CreateEmployeeData {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {
			// create new employee object
			Employee e1 = new Employee("Mohit", "Kumar", "mohit@gmail.com");
			Employee e2 = new Employee("Raju", "Saxena", "raju@gmail.com");
			Employee e3 = new Employee("divya", "pathak", "divya@gmail.com");
			Employee e4 = new Employee("chitra", "joshi", "chitra@gmail.com");
			// start the session
			session.beginTransaction();
			// save the employee
			session.save(e1);
			session.save(e2);
			session.save(e3);
			session.save(e4);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			session.close();
		}
	}

}
