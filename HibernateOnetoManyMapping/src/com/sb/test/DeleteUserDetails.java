package com.sb.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sb.user.PhoneNumber;
import com.sb.user.User;

public class DeleteUserDetails {

	public static void main(String[] args) {
		Configuration config=null;
		SessionFactory factory=null;
		Session session=null;
		Transaction tx = null;
		
		try {
		 config = new Configuration();
		config.configure("com/sb/user/hibernate.cfg.xml");;
		factory = config.buildSessionFactory();
		 session = factory.openSession();
		 User user= session.load(User.class, 1001);
		tx = session.beginTransaction();
		session.delete(user);
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
