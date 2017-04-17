package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import domain.EquipementElectronique;

public class EquipementElectroniqueDAO implements GenericDAO<EquipementElectronique, Long> {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");

	/**
	 * 
	 */
	public EquipementElectronique create(EquipementElectronique t) {
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
	public EquipementElectronique read(Long id) {
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		List<EquipementElectronique> resultList = new ArrayList<EquipementElectronique>();

		// Debut de la transaction
		tx.begin();
		
		//Instanciation et persistence des objets
		try {
			TypedQuery<EquipementElectronique> query = manager.createQuery("Select a From EquipementElectronique a Where a.id = :id", EquipementElectronique.class);
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
	public EquipementElectronique update(EquipementElectronique t) {
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
	public void delete(EquipementElectronique t) {
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
	public List<EquipementElectronique> list(){
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		List<EquipementElectronique> resultList = new ArrayList<EquipementElectronique>();

		// Debut de la transaction
		tx.begin();
		
		//Instanciation et persistence des objets
		try {
			resultList = manager.createQuery("Select a From EquipementElectronique a", EquipementElectronique.class).getResultList();
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
