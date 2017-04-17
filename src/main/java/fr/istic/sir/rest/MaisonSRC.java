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

import domain.Maison;
import jpa.MaisonDAO;

@Path("/maison")
public class MaisonSRC {
	
	MaisonDAO dao = new MaisonDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Maison> getList() {
		return dao.list();
	}
	
	@POST
	@Path("/{id}")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Maison getOne(@PathParam("id") String id) {
		Long _id = Long.parseLong(id);
		return dao.read(_id);
	}
	
	@POST
	@Path("/save")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(@QueryParam("nbrePiece") String nbrePiece, @QueryParam("taille") String taille) {
		Maison maison = new Maison();
		
		maison.setNbrePiece(Integer.parseInt(nbrePiece));
		maison.setTaille(Long.parseLong(taille));
		
		dao.create(maison);
		
		return Response.status(200).entity(maison.toString()).build();
	}	
}