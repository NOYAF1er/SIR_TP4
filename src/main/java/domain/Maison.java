package domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Maison {
	long id;
	long taille;
	int nbrePiece;
	Collection<SmartDevice> equipements;
	Collection<Person> habitants;
	
	public long getTaille() {
		return taille;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToMany(mappedBy="residences")
	public Collection<Person> getHabitants() {
		return habitants;
	}

	public void setHabitants(Collection<Person> habitants) {
		this.habitants = habitants;
	}

	public void setTaille(long taille) {
		this.taille = taille;
	}

	public int getNbrePiece() {
		return nbrePiece;
	}

	public void setNbrePiece(int nbrePiece) {
		this.nbrePiece = nbrePiece;
	}

	@OneToMany(mappedBy="maison", cascade={CascadeType.REMOVE, CascadeType.REFRESH})
	public Collection<SmartDevice> getEquipements() {
		return equipements;
	}

	public void setEquipements(Collection<SmartDevice> chauffages) {
		this.equipements = chauffages;
	}
	
	@Override
	public String toString() {
		return "Maison [id=" + id + ", taille=" + taille + ", nbrePiece=" + nbrePiece + ", equipements=" + equipements
				+ ", habitants=" + habitants + "]";
	}
	
}
