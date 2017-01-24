package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Maison;
import domain.Person;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		// Ouverture de la transaction
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		//Instanciation et persistence des objets
		try {
			test.createPerson();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Fermeture de la transaction
		tx.commit();
		
		//Affichage des personnes présentent en base
		test.listPersons();
		
		//Fermeture de l'unité de travail JPA
		manager.close();
		System.out.println("done");
	}

	private void createPerson() {
		int numOfPersons = manager.createQuery("Select a From Person a", Person.class).getResultList().size();
		if (numOfPersons == 0) {
			Maison residences = new Maison();
			manager.persist(residences);

			manager.persist(new Person("Jhon", "Doe", "jhon@doe.com", residences));
			manager.persist(new Person("Louis", "1er", "louis@mail.com", residences));
		}
	}

	private void listPersons() {
		List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (Person next : resultList) {
			System.out.println("next employee: " + next);
		}
	}

}
