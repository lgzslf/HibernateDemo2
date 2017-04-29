package com.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lgz.Person;

public class HibernateTest {

	private SessionFactory factory = null;
	private Session session = null;

	@Before
	public void setUp() throws Exception {
		System.out.println("----初始化数据----");

		Configuration cfg = new Configuration().configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		factory = cfg.buildSessionFactory(sr);
		session = factory.openSession();

	}

	@After
	public void tearDown() throws Exception {
		System.out.println("----释放数据----");

		if (session.isOpen()) {
			session.close();
		}
		if (!factory.isClosed()) {
			factory.close();
		}
	}

	@Test
	public void testAdd() {
		Person p = new Person("lgz", 1234, new Date());
		Transaction tr = session.beginTransaction();
		session.persist(p);
		tr.commit();

	}

	@Test
	public void testUpdate() {
		Person p = (Person) session.get(Person.class, 2);

		p.setName("eqwrt");
		Transaction tr = session.beginTransaction();
		session.update(p);
		tr.commit();

	}

	@Test
	public void testGetCount() {
		Person p = (Person) session.get(Person.class, 2);
		System.out.println(p.getCount());

	}
	
	@Test
	public void testGet(){
		
		Person p = (Person)session.get(Person.class, 2);
		System.out.println(p);
		
		System.out.println("------------------------------------");
		
		Person p2 = (Person)session.get(Person.class, 2);
		System.out.println(p2);
		
	}
	

}
