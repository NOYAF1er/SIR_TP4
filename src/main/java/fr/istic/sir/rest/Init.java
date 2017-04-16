package fr.istic.sir.rest;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Chauffage;
import domain.EquipementElectronique;
import domain.Maison;
import domain.Person;
import domain.SmartDevice;

@Path("/init")
public class Init {
	
	@GET
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
				residences.setNbrePiece(5);
				residences.setTaille(1000);
				
				EquipementElectronique equipement = new EquipementElectronique();
				equipement.setConsoMoyenne(500);
				equipement.setMaison(residences);
				
				Chauffage chauffage = new Chauffage();
				chauffage.setPuissance(200);
				chauffage.setMaison(residences);
				
				ArrayList<SmartDevice> equipements = new ArrayList<SmartDevice>();
				equipements.add(chauffage);
				equipements.add(equipement);
				
				residences.setEquipements(equipements);
				
				manager.persist(chauffage);
				manager.persist(equipement);
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