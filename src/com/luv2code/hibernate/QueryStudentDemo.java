package com.luv2code.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void  main(String[] args) {
		
		SessionFactory factory= new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			System.out.println("All students: ");
			List<Student> students =  session.createQuery("from Student").getResultList();
			
			displayStudents(students);
			
			System.out.println("Student whose name is Hakan");
			students = session.createQuery("from Student s where s.firstName='Hakan'").getResultList();
			displayStudents(students);
			
			System.out.println("Student Who has name Ahmet or surname caymaz");
			students = session.createQuery("from Student s where s.firstName='Ahmet' OR s.lastName='Caymaz'").getResultList();
			displayStudents(students);
			
			System.out.println("Students who has hotmail: ");
			students = session.createQuery("from Student s where s.email LIKE '%hotmail.com'").list();
			displayStudents(students);
				
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
		
		
	}

	private static void displayStudents(List<Student> students) {
		for(Student student: students) {
			System.out.println(student);
		}
	}
}
