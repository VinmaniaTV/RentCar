package model;

import java.util.Calendar;
import java.util.Date;

public class Client extends Person {
	private Fidelity fidelity;
	
	public Client(String lastname, String firstname, String email, int phone, Address address, Fidelity fidelity) {
		super(lastname, firstname, email, phone, address);
		this.fidelity = fidelity;
	}
	
	public Client(String lastname, String firstname, String email, int phone, Address address) {
		super(lastname, firstname, email, phone, address);
		this.fidelity = null;
	}
	
	public void subscribeFidelity(Fidelity fidelity) {
		Calendar dateEnd = this.fidelity.getDateStart();
		dateEnd.add(Calendar.YEAR, this.fidelity.getDuration());
		if (this.fidelity != null || dateEnd.after(new Date())) {
			this.fidelity = fidelity;
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
		}
		else {
			System.out.println("Il y a déjà un programme de fidelité en cours");
		}
		return null;
	}
	
	public Vehicle reserveVehicle(Vehicle vehicle) {
		return null;
	}

	public Fidelity getFidelity() {
		return fidelity;
	}

	public void setFidelity(Fidelity fidelity) {
		this.fidelity = fidelity;
	}
}
