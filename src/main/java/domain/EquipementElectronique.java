package domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("EE")
public class EquipementElectronique extends SmartDevice {
//	long id;
	
	double consoMoyenne;
	
	public EquipementElectronique() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	@Id
//	@GeneratedValue
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}

	public double getConsoMoyenne() {
		return consoMoyenne;
	}

	public void setConsoMoyenne(double consoMoyenne) {
		this.consoMoyenne = consoMoyenne;
	}
	
}
