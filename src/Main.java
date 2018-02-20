import at.ac.univie.swe2016.fm.VehicleManagement;
import at.ac.univie.swe2016.fm.fahrzeuge.Cars;
import at.ac.univie.swe2016.fm.fahrzeuge.Trucks;

public class Main {

	public static void main(String[] args) {
		VehicleManagement vm = new VehicleManagement("bin/vehicles.txt");

		/*
		// dodavanje novog objekta car u listu objekata tj. u fajl bin/vehicles.txt 
        Cars car = new Cars("VW", "Golf", 2016, 25000.0, 3);
        car.setLastCheck();
        vm.addVehicle(car);
        System.out.println(car.toString());

		// dodavanje novog objekta truck=car u listu objekata tj. u fajl bin/vehicles.txt
        Trucks truck = new Trucks("Mercedes", "SEC", 2016, 32000.0, 4);
        vm.addVehicle(truck);
        System.out.println(truck.toString());
        System.out.println("");

        System.out.println("Trucks:" + vm.countTrucks());
        System.out.println("Cars:" + vm.countCars());
        System.out.println("All vehicles:" + vm.countVehicles());
        */

		/*
		// primjer ukljanjanja objekta truck i ispisa stanja poslije uklanjanja
        vm.removeVehicle(truck);

        System.out.println("Trucks:" + vm.countTrucks());
        System.out.println("Cars:" + vm.countCars());
        System.out.println("All vehicles:" + vm.countVehicles());

        /*
		// primjer ukljanjanja objekta car i ispisa stanja poslije uklanjanja
        vm.removeVehicle(car);

        System.out.println("Trucks:" + vm.countTrucks());
        System.out.println("Cars:" + vm.countCars());
        System.out.println("All vehicles:" + vm.countVehicles());
        */
		
		vm.cmdShow();
        
	}

}
