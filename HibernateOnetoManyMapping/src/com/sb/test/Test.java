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
		PhoneNumber phone3=null;
		PhoneNumber phone4=null;
		Set<PhoneNumber> set =null;
		
		User user = new User();
		user.setUserId(1004);
		user.setFirstName("Jagdish");
		user.setLastName("Kumar");
		user.setAddrs("Ranchi");
		phone1 =new PhoneNumber();
		phone1.setPhone(865484);
		phone1.setNumberType("personal");
		phone1.setProvider("jio");
		
		phone2 = new PhoneNumber();
		phone2.setPhone(785875);
		phone2.setNumberType("office");
		phone2.setProvider("jio");
		/*
		phone3 = new PhoneNumber();
		phone3.setPhone(958485);
		phone3.setNumberType("business");
		phone3.setProvider("idea");
		phone4= new PhoneNumber();
		phone4.setPhone(99485);
		phone4.setNumberType("personal");
		phone4.setProvider("vodaphone");*/
		set =new HashSet();
		set.add(phone1);
		set.add(phone2);
		/*set.add(phone3);
		set.add(phone4);*/
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
