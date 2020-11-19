package com.license.demo.catalog;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.license.demo.entity.Student;
import com.license.demo.entity.User;

public class SearchService {

	private static SessionFactory factory;
	
public static List<Student> searchStudents(String firstName, String lastName, String city) {
		
		//Final list that will contain matched students based on criteria
		List<Student> matchedStudents;
		
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(User.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {			
			session = factory.getCurrentSession();
			session.beginTransaction();

			//Get Criteria Builder
			CriteriaBuilder builder = session.getCriteriaBuilder();
			
			//Create Criteria
			CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
			Root<Student> studentRoot = criteria.from(Student.class);
			
			Predicate isFirstNameNull = builder.isNotNull(studentRoot.get("firstName"));
			Predicate equalToFirstName = builder.like(studentRoot.get("firstName"), firstName);
			
			Predicate isLastNameNull = builder.isNotNull(studentRoot.get("lastName"));
			Predicate equalToLastName = builder.like(studentRoot.get("lastName"), lastName);
			
			criteria.select(studentRoot).where(
					builder
					.and(builder.or(isFirstNameNull, equalToFirstName)),
						builder.or(isLastNameNull, equalToLastName),
						builder.equal(studentRoot.get("city"), city)
					);
			
			//Use criteria to query with session to fetch all students
			Query query = session.createQuery(criteria);
			matchedStudents = query.getResultList();
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
		return matchedStudents;
	}
}
