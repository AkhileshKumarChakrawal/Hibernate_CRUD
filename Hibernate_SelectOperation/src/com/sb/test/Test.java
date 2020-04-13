package com.sb.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sb.employee.Employee;

public class Test {

	public static void main(String[] args) {
		Configuration config=null;
		SessionFactory factory =null;
		Session session =null;

		try {
			config = new Configuration();
			config.configure("com/sb/employee/hibernate.cfg.xml");
			factory = config.buildSessionFactory();
			session = factory.openSession();
			/*Employee emp= (Employee)session.get(Employee.class, 102);
			if(emp==null) {
				System.out.println("employee does not exist");
			}
			else {
			System.out.println("Employee details===");
			System.out.println(emp.getEno()+" "+emp.getEname()+" "+emp.getEsal()+" "+emp.getEaddr());;
			}*/
			
			Employee emp= (Employee)session.load(Employee.class, 102);
			System.out.println("Employee details===");
			System.out.println(emp.getEno()+" "+emp.getEname()+" "+emp.getEsal()+" "+emp.getEaddr());;
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
