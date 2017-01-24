package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Person {
	@Id
	@GeneratedValue
	long id;
	
	String nom;
	String prenom;
	String email;
	
	@ManyToMany
	List<Person> persons;
	
	@ManyToMany(mappedBy="persons", cascade={CascadeType.REFRESH})
	List<Person> amis;

	@ManyToMany
	@JoinTable(
			name="PERS_MAISON"
	)
	List<Maison> residences;

	public Person() {
		
	}

	public Person(String nom, String prenom, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.amis = new ArrayList<Person>();
		this.residences = new ArrayList<Maison>();
	}
	
	public Person(String nom, String prenom, String email, Maison maison) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.amis = new ArrayList<Person>();
		this.residences = new ArrayList<Maison>();
		residences.add(maison);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Person> getAmis() {
		return amis;
	}

	public void setAmis(List<Person> amis) {
		this.amis = amis;
	}

	public List<Maison> getResidences() {
		return residences;
	}

	public void setResidences(List<Maison> residences) {
		this.residences = residences;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Person> getPerson() {
		return persons;
	}

	public void setPerson(List<Person> person) {
		this.persons = person;
	}

	@Override
	public String toString() {
		return "Person [nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}
	
}
