package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student student1= new Student("Ali","Atýf","ali@hotmail.com");
			Student student2=new Student("Ahmet","Cengiz","ahmet@hotmail.com");
			Student student3=new Student("Osman","Yýlmaz","osman@hotmail.com");
			
			session.beginTransaction();
			
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			session.getTransaction().commit();
			
			
		}
		finally {
			factory.close();
		}

	}

}
