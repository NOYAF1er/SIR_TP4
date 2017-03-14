package fr.istic.sir.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Chauffage;
import domain.EquipementElectronique;
import domain.Maison;
import domain.SmartDevice;

@Path("/hello")
public class SampleWebService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello, how are you?";
	}
	
	@GET
	@Path("/home")
	@Produces(MediaType.APPLICATION_JSON)
	public Maison getMaison() {
		Maison maison = new Maison();
		maison.setTaille(200);
		maison.setNbrePiece(5);
		
		Chauffage chauffage = new Chauffage();
		chauffage.setPuissance(500);
		//chauffage.setMaison(maison);
		
		EquipementElectronique electro = new EquipementElectronique();
		electro.setConsoMoyenne(200);
		//electro.setMaison(maison);
		
		ArrayList<SmartDevice> equipements = new ArrayList<SmartDevice>();
		equipements.add(chauffage);
		equipements.add(electro);
		
		maison.setEquipements(equipements);
		
		return maison;
	}
	
}