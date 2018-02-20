package at.ac.univie.swe2016.fm.fahrzeuge;

import java.util.Calendar;

@SuppressWarnings("serial")
public class Cars extends Vehicle {

	private Calendar lastCheck;
	
	public Calendar getLastCheck() {
		return lastCheck;
	}

	public void setLastCheck(Calendar lastCheck) {
		this.lastCheck = lastCheck;
	}

	public void setLastCheck() {
        Calendar now = Calendar.getInstance();
        this.lastCheck = now;
	}

	public Cars(String brand, String model, int constructionyear, double basicprice, int id) {
		super(brand, model, constructionyear, basicprice, id);
	}
	
	public Cars(String brand, String model, int constructionyear, double basicprice, int id, Calendar lastcheck) {
		super(brand, model, constructionyear, basicprice, id);
		this.lastCheck = lastcheck;
	}
	
	public double getRabatt() {
		Calendar now  = Calendar.getInstance();
        double rabatt = 5 * (now.get(Calendar.YEAR) - this.getConstructionyear()) + 2 * (now.get(Calendar.YEAR) - this.getLastCheck().get(Calendar.YEAR));
        
        /*
        if (rabatt > 0){
	        if (rabatt > 15){
	        	return 15;
	        } else {
	        	return rabatt;
	        }
        } else {
        	return 0;
        }
        */
        
        return rabatt > 0 ? (rabatt > 15 ? 15 : rabatt) : 0;
	}

	@Override
	public String toString() {
		return "Cars [lastCheck=" + lastCheck + ", getAge()=" + getAge() + ", getBrand()=" + getBrand()
				+ ", getModel()=" + getModel() + ", getConstructionyear()=" + getConstructionyear()
				+ ", getBasicprice()=" + getBasicprice() + ", getId()=" + getId() + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((lastCheck == null) ? 0 : lastCheck.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Cars)) {
			return false;
		}
		Cars other = (Cars) obj;
		if (lastCheck == null) {
			if (other.lastCheck != null) {
				return false;
			}
		} else if (!lastCheck.equals(other.lastCheck)) {
			return false;
		}
		return true;
	}
	
}