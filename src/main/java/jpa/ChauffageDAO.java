package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import domain.Chauffage;

public class ChauffageDAO implements GenericDAO<Chauffage, Long> {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");

	/**
	 * 
	 */
	public Chauffage create(Chauffage t) {
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
	public Chauffage read(Long id) {
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		List<Chauffage> resultList = new ArrayList<Chauffage>();

		// Debut de la transaction
		tx.begin();
		
		//Instanciation et persistence des objets
		try {
			TypedQuery<Chauffage> query = manager.createQuery("Select a From Chauffage a Where a.id = :id", Chauffage.class);
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
	public Chauffage update(Chauffage t) {
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
	public void delete(Chauffage t) {
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
	public List<Chauffage> list(){
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		List<Chauffage> resultList = new ArrayList<Chauffage>();

		// Debut de la transaction
		tx.begin();
		
		//Instanciation et persistence des objets
		try {
			resultList = manager.createQuery("Select a From Chauffage a", Chauffage.class).getResultList();
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
