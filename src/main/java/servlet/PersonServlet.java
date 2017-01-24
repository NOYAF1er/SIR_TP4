package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Maison;
import domain.Person;

@WebServlet(name = "person", urlPatterns = { "/personInfo" })
public class PersonServlet extends HttpServlet {
	
	private EntityManager manager;
	
	public PersonServlet() {
		super();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
		this.manager = factory.createEntityManager();	
	}
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
		PrintWriter out = resp.getWriter();
		List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();
		out.println("<h1>Liste des personnes</h1>");
		out.println("<h3>Nombre de personnes:</h3>" + resultList.size());
		out.println("<ul>");
		for (Person next : resultList) {
			out.println("<ul>");
				out.println("<li>Nom: " + next.getNom());
				out.println("<li>Prenom: " + next.getPrenom());
				out.println("<li>Email: " + next.getEmail());
			out.println("</ul>");
		}
		out.println("</ul>");
    }
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		
		String ami = request.getParameter("ami");
		String residence = request.getParameter("residence");
		
		manager.persist(new Person(nom, prenom, email));
		
	}

}
