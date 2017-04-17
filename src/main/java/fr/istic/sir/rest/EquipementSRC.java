package fr.istic.sir.rest;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.EquipementElectronique;
import domain.SmartDevice;
import jpa.SmartDeviceDAO;

@Path("/equipement")
public class EquipementSRC {
	
	SmartDeviceDAO dao = new SmartDeviceDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<SmartDevice> getList() {
		return dao.list();
	}

	@POST
	@Path("/{id}")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SmartDevice getOne(@PathParam("id") String id) {
		Long _id = Long.parseLong(id);
		return dao.read(_id);
	}
	
	@POST
	@Path("/save")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(@QueryParam("conso") String conso) {
		EquipementElectronique equipement = new EquipementElectronique();
		
		equipement.setConsoMoyenne(Long.parseLong(conso));
		
		dao.create(equipement);
		
		return Response.status(200).entity(equipement.toString()).build();
	}	
	
}