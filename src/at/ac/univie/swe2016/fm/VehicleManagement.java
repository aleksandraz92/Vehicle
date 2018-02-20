package at.ac.univie.swe2016.fm;

import java.util.ArrayList;

import at.ac.univie.swe2016.fm.fahrzeuge.Vehicle;
import at.ac.univie.swe2016.fm.fahrzeuge.Cars;
import at.ac.univie.swe2016.fm.fahrzeuge.Trucks;
import at.ac.univie.swe2016.fm.fahrzeuge.dao.SerializedVehicleDAO;

public class VehicleManagement {

	private SerializedVehicleDAO vehiclesList;
	// a moze i private VehicleDAO vehiclesList;

    public VehicleManagement(String filename) {
        this.vehiclesList = new SerializedVehicleDAO(filename);
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehiclesList.addVehicle(vehicle);
    }

    public void removeVehicle(Vehicle x) {
        this.vehiclesList.removeVehicle(x);
    }

    public int countVehicles() {
        ArrayList<Vehicle> vehicles = this.vehiclesList.getVehicleList();
        return vehicles.size();
    }

    public int countTrucks() {
        ArrayList<Vehicle> vehicles = this.vehiclesList.getVehicleList();
        int count = 0;
        for(Vehicle x: vehicles) {
            if( x instanceof Trucks) {
                count++;
            }
        }
        return count;
    }

    public int countCars() {
        ArrayList<Vehicle> vehicles = this.vehiclesList.getVehicleList();
        int count = 0;
        for(Vehicle x: vehicles) {
            if( x instanceof Cars) {
                count++;
            }
        }
        return count;
    }

    public double averageVehiclePreis() {
        ArrayList<Vehicle> vehicles = this.vehiclesList.getVehicleList();
        double sum = 0.0;
        for(Vehicle x: vehicles) {
            sum += x.getBasicprice();
        }
        return sum/vehicles.size();
    }

    public double averageCarPreis() {
        ArrayList<Vehicle> vehicles = this.vehiclesList.getVehicleList();
        double sum = 0.0;
        int total = 0;
        for(Vehicle x: vehicles) {
            if( ! (x instanceof Cars) ) continue;
            sum += x.getBasicprice();
            total += 1;
        }
        return sum/total;
    }

    public double averageTruckPreis() {
        ArrayList<Vehicle> vehicles = this.vehiclesList.getVehicleList();
        double sum = 0.0;
        int count = 0;
        for(Vehicle x: vehicles) {
            if( ! (x instanceof Trucks) ) continue;
            sum += x.getBasicprice();
            count += 1;
        }
        return sum/count;
    }

    public double averageVehicleAlter()
    {
        ArrayList<Vehicle> vehicles = this.vehiclesList.getVehicleList();
        double totalAlter = 0.0;
        for(Vehicle x: vehicles) {
            totalAlter += x.getAge();
        }
        return totalAlter/vehicles.size();
    }

    public Vehicle oldestVehicle()
    {
        ArrayList<Vehicle> vehicles = this.vehiclesList.getVehicleList();
        
        Vehicle oldestVehicle = null;
        int alter = 0;
        
        for(Vehicle x: vehicles) {
            if( alter < x.getAge() ) {
                alter = x.getAge();
                oldestVehicle = x;
            }
        }
        return oldestVehicle;
    }
	
	public Vehicle getVehicleById(int id) {
        return this.vehiclesList.getVehicleById(id);
	}

	
	
	// metode potrebne samo za VehicleClient.java
	
	public void cmdShow() {
		ArrayList<Vehicle> vehicles = this.vehiclesList.getVehicleList();
		
        for(Vehicle x: vehicles) {

        	if( x instanceof Cars ) {
        		Cars y = (Cars) x; // "kastujem" x iz Vechiles u Cars jer klasa Vechiles nema metodu getLastCheck(), a klasa Cars je ima
        		
	        	System.out.println("Typ:               "+"PKW");
	        	System.out.println("ID:                "+x.getId());
	        	System.out.println("Marke:             "+x.getBrand());
	        	System.out.println("Modell:            "+x.getModel());
	        	System.out.println("Baujahr:           "+x.getConstructionyear());
	        	System.out.println("Grundpreis:        "+x.getBasicprice());
	        	System.out.println("Überprüfungsdatum: "+y.getLastCheck().getTime());
	        	System.out.println("Preis:             "+x.getBasicprice()*(100-x.getRabatt())/100);
	        	System.out.println("");
        	} else if( x instanceof Trucks ) {
	        	System.out.println("Typ:               "+"LKW");
	        	System.out.println("ID:                "+x.getId());
	        	System.out.println("Marke:             "+x.getBrand());
	        	System.out.println("Modell:            "+x.getModel());
	        	System.out.println("Baujahr:           "+x.getConstructionyear());
	        	System.out.println("Grundpreis:        "+x.getBasicprice());
	        	System.out.println("Preis:             "+x.getBasicprice()*(100-x.getRabatt())/100);
	        	System.out.println("");
        	}
        	
        }
	}

	public void cmdShow(int id) {
		ArrayList<Vehicle> vehicles = this.vehiclesList.getVehicleList();
		
        for(Vehicle x: vehicles) {
        	if(x.getId()==id){
	        	if( x instanceof Cars ) {
	        		Cars y = (Cars) x; // "kastujem" x iz Vechiles u Cars jer klasa Vechiles nema metodu getLastCheck(), a klasa Cars je ima
	        		
		        	System.out.println("Typ:               "+"PKW");
		        	System.out.println("ID:                "+x.getId());
		        	System.out.println("Marke:             "+x.getBrand());
		        	System.out.println("Modell:            "+x.getModel());
		        	System.out.println("Baujahr:           "+x.getConstructionyear());
		        	System.out.println("Grundpreis:        "+x.getBasicprice());
		        	System.out.println("Überprüfungsdatum: "+y.getLastCheck().getTime());
		        	System.out.println("Preis:             "+x.getBasicprice()*(100-x.getRabatt())/100);
		        	System.out.println("");
	        	} else if( x instanceof Trucks ) {
		        	System.out.println("Typ:               "+"LKW");
		        	System.out.println("ID:                "+x.getId());
		        	System.out.println("Marke:             "+x.getBrand());
		        	System.out.println("Modell:            "+x.getModel());
		        	System.out.println("Baujahr:           "+x.getConstructionyear());
		        	System.out.println("Grundpreis:        "+x.getBasicprice());
		        	System.out.println("Preis:             "+x.getBasicprice()*(100-x.getRabatt())/100);
		        	System.out.println("");
	        	}
        	}
        	
        }
	}
	
}