package at.ac.univie.swe2016.fm.fahrzeuge;

import java.util.Calendar;
import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Vehicle implements Serializable{

	private String brand;
	private String model;
	private int constructionyear;
	private double basicprice;
	private int id;
	
	public Vehicle(String brand, String model, int constructionyear, double basicprice, int id) {
		this.brand = brand;
		this.model = model;
		this.constructionyear = constructionyear;
		this.basicprice = basicprice;
		this.id = id;
	}
	
	public int getAge(){
		Calendar now = Calendar.getInstance();
        return now.get(Calendar.YEAR) - this.getConstructionyear();		
	}
	
	public double getPreis(float discount) {
		return this.getBasicprice() * (( 100-this.getRabatt() ) / 100);
	}
	
	public abstract double getRabatt();

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}	

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getConstructionyear() {
		return constructionyear;
	}

	public void setConstructionyear(int constructionyear) {
        Calendar now = Calendar.getInstance();
        if( constructionyear >  now.get(Calendar.YEAR) ) {
            throw new IllegalArgumentException("Production year can't be greater than current year !!!");
        }
        this.constructionyear = constructionyear;		
	}
	
	public double getBasicprice() {
		return basicprice;
	}

	public void setBasicprice(double basicprice) {
		this.basicprice = basicprice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(basicprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + constructionyear;
		result = prime * result + id;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
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
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Vehicle)) {
			return false;
		}
		Vehicle other = (Vehicle) obj;
		if (Double.doubleToLongBits(basicprice) != Double.doubleToLongBits(other.basicprice)) {
			return false;
		}
		if (brand == null) {
			if (other.brand != null) {
				return false;
			}
		} else if (!brand.equals(other.brand)) {
			return false;
		}
		if (constructionyear != other.constructionyear) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (model == null) {
			if (other.model != null) {
				return false;
			}
		} else if (!model.equals(other.model)) {
			return false;
		}
		return true;
	}

}