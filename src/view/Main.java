package view;

import java.util.List;
import java.util.Scanner;

import controller.DataAccess;
import model.Agency;
import model.Client;
import model.Vehicle;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataAccess datacc = new DataAccess(args[0], args[1], args[2]);
		List<Client> lst = datacc.getClientsPS();

		for (Client client : lst) {
			System.out.println(client);
		}
		
		List<Vehicle> lstv = datacc.getVehiclesPS();

		for (Vehicle vehicle : lstv) {
			System.out.println(vehicle);
		}
		
		List<Agency> lsta = datacc.getAgenciesPS();

		for (Agency agency : lsta) {
			System.out.println(agency);
		}
		
		try {
    		
    		while(true) {
    			
	    		@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
	    		StringBuilder s = new StringBuilder();
	    		s.append("Bienvenue sur RentCar\n"
	    				+ "Que voulez-vous faire ?");
	            System.out.print(s.toString());
	            String file = scanner.nextLine();
	            
	            /*
				Controler data = new Controler(file);
				
				data.print();
				
				if (data.isNotAnAbsorberCircuit()) {
					System.out.println("--Algorithme de FloydWarshall--");
					data.FloydAlgoritm();
				} else {
					System.out.println("Ce graph possède un circuit...");
				}
				*/
    		}
		
    	} catch(Exception e) {
    		System.out.println("");
    	}
	}

}
