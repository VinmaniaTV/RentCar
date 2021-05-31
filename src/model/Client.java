package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Client extends Person {
	private Fidelity fidelity;
	private ArrayList<Vehicle> listReserved;
	private ArrayList<Vehicle> listRented;
	
	public Client(int id, String lastname, String firstname, String email, int phone, Address address, Fidelity fidelity) {
		super(id, lastname, firstname, email, phone, address);
		this.fidelity = fidelity;
		this.listReserved = new ArrayList<Vehicle>();
		this.listRented = new ArrayList<Vehicle>();
	}
	
	public Client(int id, String lastname, String firstname, String email, int phone, Address address) {
		super(id, lastname, firstname, email, phone, address);
		this.fidelity = null;
		this.listReserved = new ArrayList<Vehicle>();
		this.listRented = new ArrayList<Vehicle>();
	}
	
	public void subscribeFidelity(Fidelity fidelity) {
		Calendar dateEnd = this.fidelity.getDateStart();
		dateEnd.add(Calendar.YEAR, this.fidelity.getDuration());
		if (this.fidelity != null || dateEnd.after(new Date())) {
			this.fidelity = fidelity;
			// REQUETE BDD
			return;
		}
		else {
			System.out.println("Il y a déjà un programme de fidelité en cours");
		}
	}
	
	public Fidelity subscribeFidelity(Calendar dateStart, int duration, String description, float price, int reductionRate) {
		Calendar dateEnd = this.fidelity.getDateStart();
		dateEnd.add(Calendar.YEAR, this.fidelity.getDuration());
		if (this.fidelity != null || dateEnd.after(new Date())) {
			this.fidelity = new Fidelity(dateStart, duration, description, price, reductionRate);
			return this.fidelity;
			// REQUETE BDD
		}
		else {
			System.out.println("Il y a déjà un programme de fidelité en cours");
		}
		return null;
	}
	
	public Vehicle reserveVehicle(Vehicle vehicle) {
		if (!vehicle.isFree()) {
			System.out.println("Véhicule non disponible.");
			return null;
		}
		else {
			// REQUETE BDD - Création de devis (ne pas oublier la fidelité)
			vehicle.setFree(true);
			return vehicle;
		}
	}
	
	public Vehicle rentVehicle(Vehicle vehicle) {
		if (vehicle.isReserved().getId() == this.getId() || vehicle.isFree()) {
			// REQUETE BDD - Transformation devis
			listRented.add(vehicle);
			return vehicle;
		}
		return null;
	}
	
	public ArrayList<Vehicle> getListReserved() {
		return listReserved;
	}

	public void setListReserved(ArrayList<Vehicle> listReserved) {
		this.listReserved = listReserved;
	}

	public ArrayList<Vehicle> getListRented() {
		return listRented;
	}

	public void setListRented(ArrayList<Vehicle> listRented) {
		this.listRented = listRented;
	}

	public void returnVehicle(Vehicle vehicle) {
		// REQUETE BDD - Création facture
		this.listRented.remove(vehicle);
	}

	public Fidelity getFidelity() {
		return fidelity;
	}

	public void setFidelity(Fidelity fidelity) {
		this.fidelity = fidelity;
	}
}
