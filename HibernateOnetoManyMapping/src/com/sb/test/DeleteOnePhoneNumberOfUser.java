package com.sb.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sb.user.PhoneNumber;
import com.sb.user.User;

public class DeleteOnePhoneNumberOfUser {

	public static void main(String[] args) {
		Configuration config=null;
		SessionFactory factory=null;
		Session session=null;
		Transaction tx = null;
		
		try {
		 config = new Configuration();
		config.configure("com/sb/user/hibernate.cfg.xml");
		factory = config.buildSessionFactory();
		 session = factory.openSession();
		 User user= session.load(User.class, 1004);
		Set<PhoneNumber> childs =  user.getPhones();
		tx = session.beginTransaction();
		childs.clear();
		tx.commit();
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
