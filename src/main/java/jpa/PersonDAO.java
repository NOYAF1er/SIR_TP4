package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import domain.Person;

public class PersonDAO implements GenericDAO<Person, Long> {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");

	/**
	 * 
	 */
	public Person create(Person t) {
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		// Debut de la transaction
		tx.begin();
		
		//Instanciation et persistence des objets
		try {
			manager.persist(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Fermeture de la transaction
		tx.commit();
		
		//Fermeture de l'unité de travail JPA
		manager.close();
		
		return t;
	}

	/**
	 * 
	 */
	public Person read(Long id) {
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		List<Person> resultList = new ArrayList<Person>();

		// Debut de la transaction
		tx.begin();
		
		//Instanciation et persistence des objets
		try {
			TypedQuery<Person> query = manager.createQuery("Select a From Person a Where a.id = :id", Person.class);
			query.setParameter("id", id);
			resultList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Fermeture de la transaction
		tx.commit();
		
		//Fermeture de l'unité de travail JPA
		manager.close();
		
		return resultList.get(0);
	}

	/**
	 * 
	 */
	public Person update(Person t) {
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		// Debut de la transaction
		tx.begin();
		
		//Instanciation et persistence des objets
		try {
			manager.merge(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Fermeture de la transaction
		tx.commit();
		
		//Fermeture de l'unité de travail JPA
		manager.close();
		
		return t;
	}

	/**
	 * 
	 */
	public void delete(Person t) {
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		
		// Debut de la transaction
		tx.begin();
		
		//Instanciation et persistence des objets
		try {
			manager.remove(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Fermeture de la transaction
		tx.commit();
		
		//Fermeture de l'unité de travail JPA
		manager.close();		
	}
	
	/**
	 * 
	 */
	public List<Person> list(){
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		List<Person> resultList = new ArrayList<Person>();

		// Debut de la transaction
		tx.begin();
		
		//Instanciation et persistence des objets
		try {
			resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Fermeture de la transaction
		tx.commit();
		
		//Fermeture de l'unité de travail JPA
		manager.close();
		
		return resultList;
	}

}
