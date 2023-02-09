package com.code.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.employee.entity.Employee;

public class DeleteEmployeeData {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			// start the transaction
			session.beginTransaction();
			// delete id: 1
			session.createQuery("delete from Employee where id='2'").executeUpdate();
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			session.close();
		}
	}
}
