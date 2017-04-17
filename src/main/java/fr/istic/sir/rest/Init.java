package fr.istic.sir.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Chauffage;
import domain.EquipementElectronique;
import domain.Maison;
import domain.Person;
import domain.SmartDevice;
import jpa.ChauffageDAO;
import jpa.EquipementElectroniqueDAO;
import jpa.MaisonDAO;
import jpa.PersonDAO;

@Path("/init")
public class Init {
	
	MaisonDAO maisonDAO = new MaisonDAO();
	EquipementElectroniqueDAO equipementDAO = new EquipementElectroniqueDAO();
	ChauffageDAO chauffageDAO = new ChauffageDAO();
	PersonDAO personDAO = new PersonDAO();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String init() {
		Maison residences = new Maison();
		residences.setNbrePiece(5);
		residences.setTaille(1000);
		
		EquipementElectronique equipement = new EquipementElectronique();
		equipement.setConsoMoyenne(500);
		//equipement.setMaison(residences);
		
		Chauffage chauffage = new Chauffage();
		chauffage.setPuissance(200);
		//chauffage.setMaison(residences);
		
		ArrayList<SmartDevice> equipements = new ArrayList<SmartDevice>();
		equipements.add(chauffage);
		equipements.add(equipement);
		
		residences.setEquipements(equipements);
		
		Person jhon = new Person("Jhon", "Doe", "jhon@doe.com", residences);
		Person louis = new Person("Louis", "1er", "louis@mail.com", residences);
		Person jane = new Person("Jane", "Doe", "jane@doe.com", residences);

		equipementDAO.create(equipement);
		maisonDAO.create(residences);
		personDAO.create(jane);
		personDAO.create(louis);
		personDAO.create(jhon);	

		return "done";
	}
	
}