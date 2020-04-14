package com.sb.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sb.employee.Employee;

public class Test {

	public static void main(String[] args)throws Exception {
		Configuration config= new Configuration();
		config.configure("com/sb/employee/hibernate.cfg.xml");
		SessionFactory sessionFactory= config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Employee emp = new Employee();
		emp.setEno(104);
		emp.setEname("Sharda");
		emp.setEsal(9000);
		emp.setEaddr("Ndls");
		//int eno = (Integer)session.save(ts);
		session.persist(emp);
		tx.commit();
		System.out.println("Employee inserted successfully");
		/*tx.commit();
		if(eno==102) {
			System.out.println("Employee Record Inserted");
		}
		else {
			System.out.println("Employee insertion failur");
		}*/
		
		session.close();
		sessionFactory.close();
	}
}
