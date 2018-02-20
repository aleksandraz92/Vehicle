package at.ac.univie.swe2016.fm.fahrzeuge.dao;

import java.util.ArrayList;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import at.ac.univie.swe2016.fm.fahrzeuge.Vehicle;

public class SerializedVehicleDAO implements VehicleDAO {

	private final String filename;

	public SerializedVehicleDAO(String filename) {
		this.filename = filename;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Vehicle> getVehicleList() {
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

		try {
			FileInputStream file = new FileInputStream(this.filename);
			ObjectInputStream ois = new ObjectInputStream(file);
			vehicles = (ArrayList<Vehicle>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return vehicles;
	}
	
	public void storeVehicleList(ArrayList<Vehicle> vehicles) {
        try {
            FileOutputStream file = new FileOutputStream(this.filename);
            ObjectOutputStream oos = new ObjectOutputStream(file);
            oos.writeObject(vehicles);
            oos.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
	}
	
	public Vehicle getVehicleById(int id) {
		ArrayList<Vehicle> vehicles = this.getVehicleList();
		
        for(Vehicle x: vehicles) {
            if( x.getId() == id ) {
            	System.out.println("Vehicle found: " + x.toString());
                return x;
            }
        }
        System.out.println("VEHICLE NOT FOUND !!!");
        return null;
	}

    public void addVehicle(Vehicle x) {
        ArrayList<Vehicle> vehicles = this.getVehicleList();
        
        vehicles.add(x);
        
        this.storeVehicleList(vehicles);
    }

	public void removeVehicle(Vehicle x) {
        ArrayList<Vehicle> vehicles = this.getVehicleList();
        
        int indexOfVehicle = vehicles.indexOf(x);
        
        System.out.println("");
        if( indexOfVehicle != -1 ) { // if object is found in ArrayList
        	System.out.println("Vehicle found (indexOfVehicle=" + indexOfVehicle + ") " + x.toString());
        	vehicles.remove(x);
        }
        else { // if object is NOT FOUND in ArrayList
        	System.out.println("VEHICLE NOT FOUND !!! (indexOfVehicle=" + indexOfVehicle + ")");
        }
        System.out.println("");
        
        this.storeVehicleList(vehicles);		
	}

}