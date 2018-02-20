ackage at.ac.univie.swe2016.fm.fahrzeuge.dao;

import java.util.ArrayList;
import at.ac.univie.swe2016.fm.fahrzeuge.Vehicle;

public interface VehicleDAO {

	public ArrayList<Vehicle> getVehicleList();

	public Vehicle getVehicleById(int id);
	
	public void addVehicle(Vehicle vehicle);
	
	public void removeVehicle(Vehicle vehicle);

}