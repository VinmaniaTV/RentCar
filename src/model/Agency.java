package model;

import java.util.ArrayList;

public class Agency {
	private String name;
	private int phone;
	private String gpsCoords;
	private Address address;
	private ArrayList<Vehicle> listVehicles;
	
	public Agency(String name, int phone, String gpsCoords, Address address) {
		this.name = name;
		this.phone = phone;
		this.gpsCoords = gpsCoords;
		this.address = address;
		this.listVehicles = new ArrayList<Vehicle>();
	}
	
	public Agency(String name, int phone, String gpsCoords, Address address, ArrayList<Vehicle> listVehicles) {
		this.name = name;
		this.phone = phone;
		this.gpsCoords = gpsCoords;
		this.address = address;
		this.listVehicles = listVehicles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getGpsCoords() {
		return gpsCoords;
	}

	public void setGpsCoords(String gpsCoords) {
		this.gpsCoords = gpsCoords;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ArrayList<Vehicle> getListVehicles() {
		return listVehicles;
	}

	public void setListVehicles(ArrayList<Vehicle> listVehicles) {
		this.listVehicles = listVehicles;
	}
}
