package com.license.demo.login;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.license.demo.entity.User;

public class LoginService {
	
	public static boolean validateLogin(String username, String password) {
		
		boolean isValidAccount = false;
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		
		try {			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			List<User> matchedAccount = session.createQuery("FROM User acc WHERE acc.username = '" + username 
					+ "' AND acc.password = '" + password + "'").getResultList();
	
			session.getTransaction().commit();
			
			if(matchedAccount.size() == 1)
				isValidAccount = true;
			
		} finally {
			factory.close();
		}
		
		return isValidAccount;
	}

}
