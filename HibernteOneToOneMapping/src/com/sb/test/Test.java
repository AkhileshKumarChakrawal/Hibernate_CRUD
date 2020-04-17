package com.sb.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sb.user.PhoneNumber;
import com.sb.user.User;

public class Test {

	public static void main(String[] args) {
		PhoneNumber phone1= null;
		User user = new User();
		user.setUserId(1003);
		user.setFirstName("Radhey");
		user.setLastName("Singh");
		user.setAddrs("UP");
		phone1 =new PhoneNumber();
		phone1.setPhone(952594755);
		phone1.setNumberType("office");
		phone1.setProvider("idea");
		
		//user.setPhones(phone1);
		
		Configuration config=null;
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
		
		try {
		 config = new Configuration();
		config.configure("com/sb/user/hibernate.cfg.xml");
		factory = config.buildSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
		
		int userId1 = (Integer)session.save(user);
		tx.commit();
			System.out.println("Users Record Inserted");
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
			System.out.println("Users insertion failur");
		}
		finally {
		session.close();
		factory.close();
		}
	}

}
