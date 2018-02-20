import at.ac.univie.swe2016.fm.VehicleManagement;
import at.ac.univie.swe2016.fm.fahrzeuge.Cars;
import at.ac.univie.swe2016.fm.fahrzeuge.Trucks;

public class VehicleClient {

	public static void main(String[] args) {
		
		// System.out.println("Broj argumenata: " + args.length);
		System.out.println("");
		
		if (args.length == 0){
			return;
		}
		
		VehicleManagement vm = new VehicleManagement(args[0]);
		
		if (args[1].equals("show")){
			
			if (args.length == 2){				
				vm.cmdShow();
			} else if (args.length == 3){
				vm.cmdShow(Integer.parseInt(args[2]));
			}
			
		} else if (args[1].equals("add")){
			
			if (args[2].equals("lkw")){
				
				Trucks truck = new Trucks(args[4], args[5], Integer.parseInt(args[6]), Double.parseDouble(args[7]), Integer.parseInt(args[3]));
		        vm.addVehicle(truck);
				
			} else if (args[2].equals("pkw")){
				
				Cars car = new Cars(args[4], args[5], Integer.parseInt(args[6]), Double.parseDouble(args[7]), Integer.parseInt(args[3]));
		        car.setLastCheck();
		        vm.addVehicle(car);
		        
			}

		} else if (args[1].equals("del")){
			
			if (args.length == 3){
				vm.removeVehicle(vm.getVehicleById(Integer.parseInt(args[2])));
			}
			
		} else if (args[1].equals("count")){
			
			if (args.length == 2){				
				System.out.println("Broj vozila: " + vm.countVehicles());
			} else if (args.length == 3 && args[2] == "lkw" ) {
				System.out.println("Broj teretnih vozila: " + vm.countTrucks());
			} else if (args.length == 3 && args[2].equals("pkw") ) {
				System.out.println("Broj putnickih vozila: " + vm.countCars());
			}

		} else if (args[1].equals("meanage")){
			
			System.out.println("Prosjecna starost vozila: " + vm.averageVehicleAlter());

		} else if (args[1].equals("meanprice")){

			if (args.length == 2){				
				System.out.println("Prosjecna cijena vozila: " + vm.averageVehiclePreis());
			} else if (args.length == 3 && args[2].equals("lkw") ) {
				System.out.println("Prosjecna cijena teretnih vozila: " + vm.averageTruckPreis());
			} else if (args.length == 3 && args[2].equals("pkw") ) {
				System.out.println("Prosjecna cijena putnickih vozila: " + vm.averageCarPreis());
			}

		} else if (args[1].equals("oldest")){
			
			System.out.println("Najstarije vozilo je vozilo: ID=" + vm.oldestVehicle().getId() + ", " + vm.oldestVehicle().getBrand() + " " + vm.oldestVehicle().getModel());

		}
		
	}

}