package fr.istic.sir.rest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Maison;
import domain.Person;

@Path("/personne")
public class PersonSRC {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getList() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");
		EntityManager manager = factory.createEntityManager();
		List<Person> resultList = new ArrayList<Person>();
		
		// Ouverture de la transaction
		EntityTransaction tx = manager.getTransaction();
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
		
		/*Person jhon = new Person("Jhon", "Doe", "jhon.doe@ema.il");
		Person jane = new Person("Jane", "Doe", "jane.doe@ema.il");
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(jane);
		persons.add(jhon);*/

		return resultList;
	}

	@POST
	@Path("/{id}")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> get(@PathParam("id") String id) {
		Person jhon = new Person("Jhon", "Doe", "jhon.doe@ema.il");
		Person jane = new Person("Jane", "Doe", "jane.doe@ema.il");
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(jane);
		persons.add(jhon);


		return persons;
	}
	
	
	@GET
	@Path("/init")	
	@Produces(MediaType.TEXT_PLAIN)
	public String init() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqlbd");
		EntityManager manager = factory.createEntityManager();
		
		// Ouverture de la transaction
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		//Instanciation et persistence des objets
		try {
			int numOfPersons = manager.createQuery("Select a From Person a", Person.class).getResultList().size();
			if (numOfPersons == 0) {
				Maison residences = new Maison();
				manager.persist(residences);

				manager.persist(new Person("Jhon", "Doe", "jhon@doe.com", residences));
				manager.persist(new Person("Louis", "1er", "louis@mail.com", residences));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Fermeture de la transaction
		tx.commit();
				
		//Fermeture de l'unité de travail JPA
		manager.close();

		return "done";
	}
	
	
	
}