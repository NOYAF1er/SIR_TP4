package domain;

import java.util.ArrayList;
import java.util.List;

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
	List<SmartDevice> chauffages;
	List<SmartDevice> EquipementElectroniques;	
	List<Person> habitants;
	
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
	public List<Person> getHabitants() {
		return habitants;
	}

	public void setHabitants(List<Person> habitants) {
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
	public List<SmartDevice> getChauffages() {
		return chauffages;
	}

	public void setChauffages(ArrayList<SmartDevice> chauffages) {
		this.chauffages = chauffages;
	}

	@OneToMany(mappedBy="maison", cascade={CascadeType.REMOVE, CascadeType.REFRESH})
	public List<SmartDevice> getEquipementElectroniques() {
		return EquipementElectroniques;
	}

	public void setEquipementElectroniques(ArrayList<SmartDevice> equipementElectroniques) {
		EquipementElectroniques = equipementElectroniques;
	}

	
	
}
