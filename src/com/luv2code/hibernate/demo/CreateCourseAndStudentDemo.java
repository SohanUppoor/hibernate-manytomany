package com.luv2code.hibernate.demo;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Review;
import com.luv2code.demo.entity.Student;

public class CreateCourseAndStudentDemo {
	
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			int studentId=2;
			Student tempStudent=session.get(Student.class, studentId);
			
			
			System.out.println("student loaded "+tempStudent);
			
			Course tcourse1=new Course("Html and css ");
			Course tcourse2=new Course("python development");
			
			tcourse1.addStudent(tempStudent);
			tcourse2.addStudent(tempStudent);
			
			session.save(tcourse1);
			session.save(tcourse2);
			
			session.getTransaction().commit();
			System.out.println("done saving");
			
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
