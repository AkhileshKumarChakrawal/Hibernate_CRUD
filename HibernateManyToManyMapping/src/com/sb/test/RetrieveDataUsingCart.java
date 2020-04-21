package com.sb.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sb.entity.Cart;
import com.sb.entity.Item;

public class RetrieveDataUsingCart {

	public static void main(String[] args) {
		SessionFactory factory=null;
		Session session = null;
	
		try {
		Configuration config = new Configuration();
		config.configure("com/sb/entity/hibernate.hbm.xml");
		 factory = config.buildSessionFactory();
		session = factory.openSession();
		/*Query query= session.createQuery("from Cart");
		List<Cart> list = query.list();
		for(Cart carts : list) {
			System.out.println("parent===>"+carts);
			System.out.println(carts.getId()+" "+carts.getItems()+" "+carts.getTotal());
		Set<Item> childs =	carts.getItems();
		for(Item item : childs) {
			System.out.println("child==>"+childs);
			
		}
		}*/
		
		Query query= session.createQuery("from Item");
		List<Item> list = query.list();
		for(Item item : list) {
			System.out.println("child==>"+item);
			System.out.println(item.getId()+" "+item.getDescription()+" "+item.getPrice());
			Set<Cart> carts = item.getCarts();
			for(Cart c : carts) {
				System.out.println("parent==>"+c);
				System.out.println(c.getId()+" "+c.getTotal());
			}
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		
			System.out.println("Retrieving data failed");
		}
		finally {
			session.close();
			factory.close();
		}
		
	}
}
