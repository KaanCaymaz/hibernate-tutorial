package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student tempStudent = new Student("Hakan","Caymaz","hakan@hotmail.com");
			System.out.println("Student: "+ tempStudent);
			System.out.println("\n\n Student id: "+ tempStudent.getId());
			session.beginTransaction();
			
			session.save(tempStudent);
			System.out.println("\n\n Student id: "+ tempStudent.getId());
			session.getTransaction().commit();
			System.out.println("\n\n Student id: "+ tempStudent.getId());
			
			session= factory.getCurrentSession();
			session.beginTransaction();
			Student entityStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("\n\n Student: " + entityStudent);
			System.out.println("\n\n Student id:"+ entityStudent.getId());
			
		}
		finally {
			factory.close();
		}
		
	}

}
