package fr.istic.sir.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Chauffage;
import domain.EquipementElectronique;
import domain.SmartDevice;

@Path("/equipement")
public class EquipementSRC {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SmartDevice getPerson() {
		EquipementElectronique equipement1 = new EquipementElectronique();
		equipement1.setConsoMoyenne(500);
		
		return equipement1;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		Chauffage equipement2 = new Chauffage();
		equipement2.setPuissance(120);
		
		return equipement2.toString();
	}	
	
}