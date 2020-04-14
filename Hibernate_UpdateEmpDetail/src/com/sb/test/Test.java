package com.sb.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sb.employee.Employee;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Configuration config =null;
		SessionFactory sessionFactory =null;
		Session session = null;
		Transaction tx=null;
		try {
	config = new Configuration();
		config.configure("com/sb/employee/hibernate.cfg.xml");
		sessionFactory = config.buildSessionFactory();
		session = sessionFactory.openSession();
		 tx = session.getTransaction();
		tx.begin();
		Employee employee =new Employee();
		employee.setEno(104);
		employee.setEname("Sharda");
		employee.setEsal(8000);
		employee.setEaddr("hyd");
		//int eno = (Integer)session.save(ts);
		session.update(employee);
		tx.commit();
		System.out.println("Employee updation successfull");
		}
		catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			System.out.println("updation failed");
		}
		finally {
			session.close();
			sessionFactory.close();	
		}
	}
}
