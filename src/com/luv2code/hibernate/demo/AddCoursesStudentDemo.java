package com.luv2code.hibernate.demo;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Review;
import com.luv2code.demo.entity.Student;

public class AddCoursesStudentDemo {
	
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
			
			Course tempCourse=new Course("JavaUdemy-spring-hibernate");
			
			session.save(tempCourse);
			System.out.println(tempCourse+" course saved");
			
			Student tstudent1=new Student("lionel", "messi", "messi10@gmail.com");
			Student tstudent2=new Student("Cristiano", "ronaldo", "ronaldo7@gmail.com");
			Student tstudent3=new Student("virat", "kohli", "virat18@gmail.com");
			
			tempCourse.addStudent(tstudent1);
			tempCourse.addStudent(tstudent2);
			tempCourse.addStudent(tstudent3);
			
			session.save(tstudent1);
			session.save(tstudent2);
			session.save(tstudent3);
			System.out.println("students saved"+tempCourse.getStudents());

			session.getTransaction().commit();
			System.out.println("done saving");
			
			
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
