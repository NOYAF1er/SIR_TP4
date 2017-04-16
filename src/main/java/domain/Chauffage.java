package domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("C")
public class Chauffage extends SmartDevice {
//	long id;
	double puissance;
	
	public Chauffage() {
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
	
	public double getPuissance() {
		return puissance;
	}

	public void setPuissance(double puissance) {
		this.puissance = puissance;
	}

	@Override
	public String toString() {
		return "Chauffage [puissance=" + puissance + "]";
	}
	
}
