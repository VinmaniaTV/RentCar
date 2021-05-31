package model;

public class Employee extends Person {
	private String job;
	
	public Employee(int id, String lastname, String firstname, String email, int phone, Address address, String job) {
		super(id, lastname, firstname, email, phone, address);
		this.job = job;
	}
	
	public void moveVehicle(Vehicle vehicle, Agency agency) {
		if (agency.getListVehicles().contains(vehicle)) {
			System.out.println("Véhicule déjà dans cette agence.");
		}
		else {
			// REQUETE BDD
			agency.getListVehicles().add(vehicle);
		}
	}

	@Override
	public String toString() {
		return "Employee [job=" + job + "]";
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
}
