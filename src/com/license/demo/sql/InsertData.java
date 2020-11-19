package com.license.demo.sql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.license.demo.entity.Student;
import com.license.demo.entity.User;

public class InsertData {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(User.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		
		try {
			
//			Student tempStudent = new Student("David", "Deacu", "Constanta");
//			User tempUser = new User("David", "123");
//			
//			tempStudent.setUser(tempUser);
//			
//			Student tempStudent1 = new Student("Nour", "Boga", "Bucharest");
//			User tempUser1 = new User("Nour", "123");
//			
//			tempStudent1.setUser(tempUser1);
//			
//			Student tempStudent2 = new Student("Vladut", "Maican", "Buzau");
//			User tempUser2 = new User("Vladut", "123");
//			
//			tempStudent2.setUser(tempUser2);
//			
//			Student tempStudent3 = new Student("David", "Parks", "Bucharest");
//			User tempUser3 = new User("DavidParks", "123");
//			
//			tempStudent3.setUser(tempUser3);
//			
//			Student tempStudent4 = new Student("Malak", "Boga", "Constanta");
//			User tempUser4 = new User("Malak", "123");
//			
//			tempStudent4.setUser(tempUser4);
//			
//			Student tempStudent5 = new Student("Emma", "Parks", "Bucharest");
//			User tempUser5 = new User("Emma", "123");
//			
//			tempStudent5.setUser(tempUser5);
			
			Student tempStudent7 = new Student("David", "Brooks", "Constanta");
			User tempUser7 = new User("Dvd", "123");
			
			tempStudent7.setUser(tempUser7);
			
			Student tempStudent8 = new Student("Stefi", "Brooks", "Constanta");
			User tempUser8 = new User("StefiStefi", "123");
			
			tempStudent8.setUser(tempUser8);
			
			Student tempStudent9 = new Student("Cristi", "Deacu", "Constanta");
			User tempUser9 = new User("Cristi", "123");
			
			tempStudent9.setUser(tempUser9);
			
			session.beginTransaction();
			
			session.save(tempStudent7);
			session.save(tempStudent8);
			session.save(tempStudent9);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
