package com.sb.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sb.user.PhoneNumber;
import com.sb.user.User;

public class RetrieveUserPhoneInfo {

	public static void main(String[] args) {
		Configuration config=null;
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
		
		User user=null;
		PhoneNumber number =null;
		try {
		 config = new Configuration();
		config.configure("com/sb/user/hibernate.cfg.xml");;
		factory = config.buildSessionFactory();
		session = factory.openSession();
		
		Query query = session.createQuery("from PhoneNumber");
		List<PhoneNumber> list = query.list();
		for(PhoneNumber numbers : list) {
			System.out.println("Child===>"+numbers);
			System.out.println(numbers.getProvider()+" "+numbers.getPhone());
			User users = numbers.getUser();
			System.out.println("parent==>"+users);
			System.out.println(users.getUserId()+" "+users.getFirstName()+" "+users.getAddrs());
		}
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
