package model;

public class Vehicle {
	private int id;
	private String registrationNumber;
	private String brand;
	private String model;
	private int kilometers;
	private boolean airConditioned;
	private String gearbox;
	private String fuel;
	private Category category;
	private boolean isFree;
	private double fuelQuantity;
	private int capacityFuel;
	
	public Vehicle(int id, String r, String b, String m, int k, boolean a, String g, String f, Category c, boolean i, double fuelQuantity, int capacityFuel) {
		this.id = id;
		this.registrationNumber = r;
		this.brand = b;
		this.model = m;
		this.kilometers = k;
		this.airConditioned = a;
		this.gearbox = g;
		this.fuel = f;
		this.category = c;
		this.isFree = i;
		this.fuelQuantity = fuelQuantity;
		this.capacityFuel = capacityFuel;
	}

	public Client isReserved() {
		// REQUETE BDD
		return null;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", registrationNumber=" + registrationNumber + ", brand=" + brand + ", model="
				+ model + ", kilometers=" + kilometers + ", airConditioned=" + airConditioned + ", gearbox=" + gearbox
				+ ", fuel=" + fuel + ", category=" + category + ", isFree=" + isFree + ", fuelQuantity=" + fuelQuantity
				+ ", capacityFuel=" + capacityFuel + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


	public double getFuelQuantity() {
		return fuelQuantity;
	}

	public void setFuelQuantity(double fuelQuantity) {
		this.fuelQuantity = fuelQuantity;
	}

	public int getCapacityFuel() {
		return capacityFuel;
	}

	public void setCapacityFuel(int capacityFuel) {
		this.capacityFuel = capacityFuel;
	}
}
