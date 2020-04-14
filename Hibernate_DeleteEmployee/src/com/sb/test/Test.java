package com.sb.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sb.employee.Employee;

public class Test {

	public static void main(String[] args)throws Exception {
		Configuration config=new Configuration();
		config.configure("com/sb/employee/employee.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session =factory.openSession();
		Transaction tx = session.beginTransaction();
		Employee emp =new Employee();
		emp.setEno(103);
		session.delete(emp);
		tx.commit();
		System.out.println("employee record deleted");
		session.close();
		factory.close();
	}

}
