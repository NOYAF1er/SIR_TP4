package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import domain.SmartDevice;

public class SmartDeviceDAO implements GenericDAO<SmartDevice, Long> {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");

	/**
	 * 
	 */
	public SmartDevice create(SmartDevice t) {
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
	public SmartDevice read(Long id) {
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		List<SmartDevice> resultList = new ArrayList<SmartDevice>();

		// Debut de la transaction
		tx.begin();
		
		//Instanciation et persistence des objets
		try {
			TypedQuery<SmartDevice> query = manager.createQuery("Select a From SmartDevice a Where a.id = :id", SmartDevice.class);
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
	public SmartDevice update(SmartDevice t) {
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
	public void delete(SmartDevice t) {
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
	public List<SmartDevice> list(){
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		List<SmartDevice> resultList = new ArrayList<SmartDevice>();

		// Debut de la transaction
		tx.begin();
		
		//Instanciation et persistence des objets
		try {
			resultList = manager.createQuery("Select a From SmartDevice a", SmartDevice.class).getResultList();
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
