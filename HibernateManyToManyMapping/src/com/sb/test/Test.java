package com.sb.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sb.entity.Cart;
import com.sb.entity.Item;

public class Test {

	public static void main(String[] args) {
		
		Item iphone =new Item();
		iphone.setId(10001);
		iphone.setPrice(100000);
		iphone.setDescription("iphone");
		
		Item ipod =new Item();
		ipod.setId(10002);
		ipod.setPrice(50000);
		ipod.setDescription("ipod");
		
		Set<Item> items = new HashSet();
		items.add(iphone);
		items.add(ipod);
		
		Cart cart =new Cart();
		cart.setId(2001);
		cart.setItems(items);
		cart.setTotal(150000);
		
		Cart cart1 = new Cart();
		Set<Item>items1 = new HashSet();
		items1.add(iphone);
		cart1.setId(2002);
		cart1.setItems(items1);
		cart1.setTotal(100000);
		SessionFactory factory=null;
		Session session = null;
		Transaction tx=null;
		try {
		Configuration config = new Configuration();
		config.configure("com/sb/entity/hibernate.hbm.xml");
		 factory = config.buildSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
		session.save(cart);
		session.save(cart1);
		tx.commit();
		System.out.println("Record insertion successfully");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
			System.out.println("Reecord insertion fail");
		}
		finally {
			session.close();
			factory.close();
		}
		
	}
}
