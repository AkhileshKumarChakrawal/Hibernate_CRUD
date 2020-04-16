package com.sb.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sb.user.PhoneNumber;
import com.sb.user.User;

public class DeleteUserPhoneNumber {

public static void main(String[] args) {

		Configuration config=null;
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
		
		try {
		 config = new Configuration();
		config.configure("com/sb/user/hibernate.cfg.xml");;
		factory = config.buildSessionFactory();
		session = factory.openSession();
		PhoneNumber number = session.load(PhoneNumber.class, 1003);
		tx=session.beginTransaction();
		session.delete(number);
		tx.commit();
		System.out.println("user data deleted");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
			System.out.println("User deletion failur");
		}
		finally {
		session.close();
		factory.close();
		}
}
}
