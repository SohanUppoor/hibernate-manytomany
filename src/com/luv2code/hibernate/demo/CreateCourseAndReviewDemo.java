package com.luv2code.hibernate.demo;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Review;

public class CreateCourseAndReviewDemo {
	
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Course tempCourse=new Course("programming-spring");
			
			tempCourse.addReview(new Review("good course -thanks for the extra information"));
			tempCourse.addReview(new Review("excellent training with project"));
			tempCourse.addReview(new Review("please provide more information related to interview point of view"));

			System.out.println("reviews "+tempCourse.getReviews());
			session.save(tempCourse);
			System.out.println("almost done");
			
			session.getTransaction().commit();
			System.out.println("done saving");
			
			
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
