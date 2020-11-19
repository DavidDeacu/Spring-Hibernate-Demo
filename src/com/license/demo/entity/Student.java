package com.license.demo.entity;

import java.util.LinkedHashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="city")
	private String city;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@javax.persistence.Transient
	private LinkedHashMap<String, String> listOfCities;
	
	public Student () {
		listOfCities = new LinkedHashMap<>();
		listOfCities.put("Bucharest", "Bucharest");
		listOfCities.put("Cluj-Napoca", "Cluj-Napoca");
		listOfCities.put("Timisoara", "Timisoara");
		listOfCities.put("Iasi", "Iasi");
		listOfCities.put("Constanta", "Constanta");
		listOfCities.put("Craiova", "Craiova");
		listOfCities.put("Brasov", "Brasov");
		listOfCities.put("Galati", "Galati");
		listOfCities.put("Ploiesti", "Ploiesti");
		listOfCities.put("Oradea", "Oradea");
		listOfCities.put("Braila", "Braila");
		listOfCities.put("Arad", "Arad");
		listOfCities.put("Pitesti", "Pitesti");
		listOfCities.put("Sibiu", "Sibiu");
		listOfCities.put("Bacau", "Bacau");
		listOfCities.put("Targu Mures", "Targu Mures");
		listOfCities.put("Baia Mare", "Baia Mare");
		listOfCities.put("Buzau", "Buzau");
		listOfCities.put("Botosani", "Botosani");
		listOfCities.put("Satu Mare", "Satu Mare");
		listOfCities.put("Ramnicu Valcea", "Ramnicu Valcea");
		listOfCities.put("Drobeta-Turnu Severin", "Drobeta-Turnu Severin");
		listOfCities.put("Suceava", "Suceava");
		listOfCities.put("Piatra Neamt", "Piatra Neamt");
		listOfCities.put("Targu Jiu", "Targu Jiu");
		listOfCities.put("Targoviste", "Targoviste");
		listOfCities.put("Focsani", "Focsani");
		listOfCities.put("Bistrita", "Bistrita");
		listOfCities.put("Tulcea", "Tulcea");
		listOfCities.put("Resita", "Resita");
		listOfCities.put("Slatina", "Slatina");
		listOfCities.put("Calarasi", "Calarasi");
		listOfCities.put("Alba Iulia", "Alba Iulia");
		listOfCities.put("Giurgiu", "Giurgiu");
		listOfCities.put("Deva", "Deva");
		listOfCities.put("Hunedoara", "Hunedoara");
		listOfCities.put("Zalau", "Zalau");
		listOfCities.put("Sfantu Gheorghe", "Sfantu Gheorghe");
		listOfCities.put("Barlad", "Barlad");
		listOfCities.put("Vaslui", "Vaslui");
		listOfCities.put("Roman", "Roman");
		listOfCities.put("Turda", "Turda");
		listOfCities.put("Medias", "Medias");
		listOfCities.put("Slobozia", "Slobozia");
		listOfCities.put("Alexandria", "Alexandria");
		listOfCities.put("Voluntari", "Voluntari");
		listOfCities.put("Lugoj", "Lugoj");

		// To be continued...

	}
	
	
	public Student(String firstName, String lastName, String city) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LinkedHashMap<String, String> getListOfCities() {
		return listOfCities;
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + "]";
	}
	
	
}
