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

public class getUserDetailsWithPhoneNumber {

	public static void main(String[] args) {
		
	Configuration config=null;
	SessionFactory factory=null;
	Session session=null;
	Transaction tx = null;
	Query query =null;
	List<User>list=null;
	Set<PhoneNumber> childs = null;

	
	try {
	 config = new Configuration();
	config.configure("com/sb/user/hibernate.cfg.xml");;
	factory = config.buildSessionFactory();
	 session = factory.openSession();
	tx = session.beginTransaction();
	query = session.createQuery("from User");
	list =query.list();
	for(User user : list) {
		System.out.println("parent==>"+user);
		System.out.println(user.getUserId()+" "+user.getFirstName()+" "+user.getLastName()+" "+user.getAddrs());
		childs = user.getPhones();
		for(PhoneNumber ph: childs) {
			System.out.println("child===>"+ph);
			System.out.println(ph.getNumberType()+" "+ph.getPhone()+ph.getProvider());
		}
	}
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
