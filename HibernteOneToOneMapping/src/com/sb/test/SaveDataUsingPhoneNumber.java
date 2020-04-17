package com.sb.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sb.user.PhoneNumber;
import com.sb.user.User;

public class SaveDataUsingPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		user = new User();
		user.setUserId(1006);
		user.setFirstName("Shiva");
		user.setLastName("Rao");
		user.setAddrs("hyd");
		
		number = new PhoneNumber();
		number.setNumberType("office");
		number.setPhone(9842584);
		number.setProvider("jio");
		number.setUser(user);
		tx=session.beginTransaction();
		session.save(number);
		tx.commit();
		System.out.println("object inserted");
		
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
