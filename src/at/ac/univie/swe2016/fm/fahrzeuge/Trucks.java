package at.ac.univie.swe2016.fm.fahrzeuge;

import java.util.Calendar;

@SuppressWarnings("serial")
public class Trucks extends Vehicle {

	public Trucks(String brand, String model, int constructionyear, double basicprice, int id) {
		super(brand, model, constructionyear, basicprice, id);
	}

	public double getRabatt() {
		Calendar now  = Calendar.getInstance();
        double rabatt = 5 * (now.get(Calendar.YEAR) - this.getConstructionyear());
        return rabatt > 0 ? (rabatt > 20 ? 20 : rabatt) : 0;		
	}

	public String toString() {
		return "Trucks [getAge()=" + getAge() + ", getBrand()=" + getBrand() + ", getModel()=" + getModel()
				+ ", getConstructionyear()=" + getConstructionyear() + ", getBasicprice()=" + getBasicprice()
				+ ", getId()=" + getId() + "]";
	}

}