package model;

import java.util.ArrayList;

public class Agency {
	private String name;
	private int phone;
	private String gpsCoords;
	private Address address;
	private ArrayList<Vehicle> listVehicle;
	
	public Agency(String name, int phone, String gpsCoords, Address address) {
		this.name = name;
		this.phone = phone;
		this.gpsCoords = gpsCoords;
		this.address = address;
		this.listVehicle = new ArrayList<Vehicle>();
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

	public ArrayList<Vehicle> getListVehicle() {
		return listVehicle;
	}

	public void setListVehicle(ArrayList<Vehicle> listVehicle) {
		this.listVehicle = listVehicle;
	}
}
