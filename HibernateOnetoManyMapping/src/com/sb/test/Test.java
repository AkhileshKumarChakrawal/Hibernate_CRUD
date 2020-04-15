package com.sb.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sb.user.PhoneNumber;
import com.sb.user.User;

public class Test {

	public static void main(String[] args)throws Exception {
		PhoneNumber phone1= null;
		PhoneNumber phone2=null;
		Set<PhoneNumber> set =null;
		
		User user = new User();
		user.setUserId(1001);
		user.setFirstName("Ram");
		user.setLastName("Kumar");
		user.setAddrs("vns");
		phone1 =new PhoneNumber();
		phone1.setPhone(8888);
		phone1.setNumberType("residence");
		phone1.setProvider("airtel");
		
		phone2 = new PhoneNumber();
		phone2.setPhone(88888);
		phone2.setNumberType("office");
		phone2.setProvider("jio");
		
		set =new HashSet();
		set.add(phone1);
		set.add(phone2);
		user.setPhones(set);
		
		Configuration config=null;
		SessionFactory factory=null;
		Session session=null;
		Transaction tx = null;
		try {
		 config = new Configuration();
		config.configure("com/sb/user/hibernate.cfg.xml");;
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
