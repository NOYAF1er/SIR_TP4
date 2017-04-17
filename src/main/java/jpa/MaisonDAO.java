package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Maison;

public class MaisonDAO implements GenericDAO<Maison, Long> {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");

	/**
	 * 
	 */
	public Maison create(Maison t) {
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
	public Maison read(Long id) {
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		//List<Maison> resultList = new ArrayList<Maison>();
		Maison result = new Maison();

		// Debut de la transaction
		tx.begin();
		
		//Instanciation et persistence des objets
		try {
			result = manager.find(Maison.class, id);
			/*TypedQuery<Maison> query = manager.createQuery("Select a From Maison a Where a.id = :id", Maison.class);
			query.setParameter("id", id);
			resultList = query.getResultList();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Fermeture de la transaction
		tx.commit();
		
		//Fermeture de l'unité de travail JPA
		manager.close();
		
		//return resultList.get(0);
		return result;
	}

	/**
	 * 
	 */
	public Maison update(Maison t) {
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
	public void delete(Maison t) {
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
	public List<Maison> list(){
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		List<Maison> resultList = new ArrayList<Maison>();

		// Debut de la transaction
		tx.begin();
		
		//Instanciation et persistence des objets
		try {
			resultList = manager.createQuery("Select a From Maison a", Maison.class).getResultList();
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
