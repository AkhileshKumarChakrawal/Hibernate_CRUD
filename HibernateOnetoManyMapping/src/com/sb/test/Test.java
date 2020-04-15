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
		Configuration config = new Configuration();
		config.configure("com/sb/user/hibernate.cfg.xml");;
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
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
		int userId1 = (Integer)session.save(user);
		tx.commit();
		if(userId1 == 1001) {
			System.out.println("Users Record Inserted");
		}
		else {
			System.out.println("Users insertion failur");
		}
		
		session.close();
		factory.close();
	}

}
