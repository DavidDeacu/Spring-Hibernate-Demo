package com.license.demo.catalog;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.license.demo.entity.Student;
import com.license.demo.entity.User;

public class SearchService2 {
	
	public static List<Student> searchStudents(String firstName, String lastName, String city) {
		
		List<Student> matchedStudents;
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(User.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			//Create the Criteria Instance
//			Criteria crit = session.createCriteria(Student.class);
//			crit.setMaxResults(50);
//			matchedStudents = crit.list();
//			
//			//Narrowing the result set
//			matchedStudents = session.createCriteria(Student.class)
//					.add(Restrictions.)
			
			
			matchedStudents = session.createQuery("FROM Student std WHERE std.firstName = '" + firstName 
					+ "' OR " + firstName + " AND std.lastName = '" + lastName + "' AND std.city = '" + city + "'").getResultList();

			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
		System.out.println(matchedStudents.get(0));
		return matchedStudents;
	}
}
