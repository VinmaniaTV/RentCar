package model;

public class Vehicle {
	private String registrationNumber;
	private String brand;
	private String model;
	private int kilometers;
	private boolean airConditioned;
	private String gearbox;
	private String fuel;
	protected int capacityfuel;
	protected int fuelincar;
	private Category category;
	private boolean isFree;
	
	public Vehicle(String r, String b, String m, int k, boolean a, String g, String f, Category c, boolean i, int fuelincar, int capacityfuel) {
		this.registrationNumber = r;
		this.brand = b;
		this.model = m;
		this.kilometers = k;
		this.airConditioned = a;
		this.gearbox = g;
		this.fuel = f;
		this.category = c;
		this.isFree = i;
		this.fuelincar = fuelincar;
		this.capacityfuel = capacityfuel;
	}
	
	public int getFuelincar() {
		return fuelincar;
	}

	public void setFuelincar(int fuelincar) {
		this.fuelincar = fuelincar;
	}

	public Client isReserved() {
		// REQUETE BDD
		return null;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

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

	public int getKilometers() {
		return kilometers;
	}

	public void setKilometers(int kilometers) {
		this.kilometers = kilometers;
	}

	public boolean isAirConditioned() {
		return airConditioned;
	}

	public void setAirConditioned(boolean airConditioned) {
		this.airConditioned = airConditioned;
	}

	public String getGearbox() {
		return gearbox;
	}

	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public int getCapacityfuel() {
		return capacityfuel;
	}

	public void setCapacityfuel(int capacityfuel) {
		this.capacityfuel = capacityfuel;
	}
}
