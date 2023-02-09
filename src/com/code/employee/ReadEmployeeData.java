package com.code.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.employee.entity.Employee;

public class ReadEmployeeData {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {
			// start the session
			session.beginTransaction();

			// employee id: 1
			int id = 1;
			// read employee data
			Employee employee = session.get(Employee.class, id);
			// retrieved employee data
			System.out.println("Employee Data " + employee);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			session.close();
		}
	}

}
