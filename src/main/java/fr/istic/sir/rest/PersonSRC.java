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

import domain.Person;
import jpa.PersonDAO;

@Path("/personne")
public class PersonSRC {
	
	PersonDAO dao = new PersonDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Person> getList() {
		return dao.list();		
	}

	@POST
	@Path("/{id}")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Person getOne(@PathParam("id") String id) {
		Long _id = Long.parseLong(id);
		return dao.read(_id);
	}
	
	@POST
	@Path("/save")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(@QueryParam("nom") String nom, @QueryParam("prenom") String prenom, @QueryParam("email") String email) {
		Person person = new Person();
		
		person.setNom(nom);
		person.setPrenom(prenom);
		person.setEmail(email);
		
		dao.create(person);
		
		return Response.status(200).entity(person.toString()).build();
	}	
	
}