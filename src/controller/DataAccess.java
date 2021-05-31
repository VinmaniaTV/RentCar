package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Address;
import model.Agency;
import model.Category;
import model.Client;
import model.Fidelity;
import model.Person;
import model.Vehicle;

public class DataAccess {
	
	private Connection conn;
	
	PreparedStatement MyStmt = null;
	ResultSet myRs = null;
	Connection connect = null;

	public DataAccess(String url, String usr, String pass) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://" + url, usr, pass);
		}catch(SQLException e) {
            System.out.println("ERREUR : " + e.getMessage()) ;
        }
	}
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Client> getClientsPS() {

		List<Client> listClients = new ArrayList<Client>();
		try {
	        String sql = "SELECT id_client, lastname, firstname, email, phone, street, city, zipCode, _date, duration, description, price, reductionRate FROM client NATURAL JOIN address LEFT NATURAL JOIN fidelity;";
	        PreparedStatement s = conn.prepareStatement(sql);
	        ResultSet rs = s.executeQuery(sql);
	        while (rs.next()) {
	        	Address ad = new Address(rs.getString("street"),rs.getString("city"),rs.getInt("zipCode"));
	        	Client cl;
	        	if (rs.getDate("_date")!=null) {
	        		Fidelity fi = new Fidelity(rs.getDate("_date"),rs.getInt("duration"),rs.getString("description"),rs.getDouble("price"),rs.getInt("reductionRate"));
	        		cl = new Client(rs.getInt("id_client"),rs.getString("lastname"),rs.getString("firstname"),rs.getString("email"),rs.getInt("phone"), ad, fi);
	        	}
	        	else {
	        		cl = new Client(rs.getInt("id_client"),rs.getString("lastname"),rs.getString("firstname"),rs.getString("email"),rs.getInt("phone"), ad);
	        	}
	        	listClients.add(cl);
	        }
	        
		} catch (SQLException e) {
			System.out.println("msg : " + e.getMessage());
			return null;
		}
      
		return listClients;
	}
	
	public List<Vehicle> getVehiclesPS() {
		List<Vehicle> listVehicles = new ArrayList<Vehicle>();
		try {
	        String sql = "SELECT v.registrationNumber, v.brand, v.model, v.kilometers, v.airConditioned, v.fuelQuality, g.name, f.name, c.name, c.price, c.bail, v.isFree, v.fuelInCar, v.capacityFuel FROM "
	        		+ "vehicle v INNER JOIN gearboxes g ON v.id_gearboxes = g.id_gearboxes "
	        		+ "INNER JOIN fuels f ON f.id_fuels = v_id_fuels "
	        		+ "INNER JOIN categories c ON c.id_categories = v.id_categories;";
	        PreparedStatement s = conn.prepareStatement(sql);
	        ResultSet rs = s.executeQuery(sql);
	        while (rs.next()) {
	        	Category cat = new Category(rs.getString("c.name"),rs.getDouble("c.price"),rs.getDouble("c.bail"));
	        	Vehicle vel = new Vehicle(rs.getString("v.registrationNumber"),rs.getString("v.brand"),rs.getString("v.model"),rs.getInt("v.kilometers"),rs.getBoolean("v.airConditioned"),rs.getString("g.name"),rs.getString("f.name"),cat,rs.getBoolean("v.isFree"),rs.getInt("v.fuelInCar"),rs.getInt("v.capacityFuel"));
	        	listVehicles.add(vel);
	        }
	        
		} catch (SQLException e) {
			System.out.println("msg : " + e.getMessage());
			return null;
		}
      
		return listVehicles;
	}
	
	public List<Agency> getAgenciesPS() {
		List<Agency> listAgencies = new ArrayList<Agency>();
		try {
	        String sql = "SELECT id_agency, name, phone, gpscoords, street, city, zipCode FROM "
	        		+ "agency NATURAL JOIN address;";
	        PreparedStatement s = conn.prepareStatement(sql);
	        ResultSet rs = s.executeQuery(sql);
	        while (rs.next()) {
	        	Address ad = new Address(rs.getString("street"),rs.getString("city"),rs.getInt("zipCode"));
	        	String sqlParked = "SELECT v.registrationNumber, v.brand, v.model, v.kilometers, v.airConditioned, v.fuelQuality, g.name, f.name, c.name, c.price, c.bail, v.isFree, v.fuelInCar, v.capacityFuel FROM "
		        		+ "vehicle v INNER JOIN parked p ON v.id_vehicle = p.id_vehicle "
		        		+ "INNER JOIN agency a ON a.id_agency = p.id_agency "
		        		+ "INNER JOIN gearboxes g ON v.id_gearboxes = g.id_gearboxes "
		        		+ "INNER JOIN fuels f ON f.id_fuels = v_id_fuels "
		        		+ "INNER JOIN categories c ON c.id_categories = v.id_categories WHERE a.agency_id = ?;";
		        PreparedStatement sParked = conn.prepareStatement(sqlParked);
		        sParked.setInt(1,rs.getInt("id_agency"));
		        ResultSet rsParked = sParked.executeQuery(sql);
		        ArrayList<Vehicle> listVehicles = new ArrayList<Vehicle>();
		        while (rsParked.next()) {
		        	Category cat = new Category(rsParked.getString("c.name"),rsParked.getDouble("c.price"),rsParked.getDouble("c.bail"));
		        	Vehicle vel = new Vehicle(rsParked.getString("v.registrationNumber"),rsParked.getString("v.brand"),rsParked.getString("v.model"),rsParked.getInt("v.kilometers"),rsParked.getBoolean("v.airConditioned"),rsParked.getString("g.name"),rsParked.getString("f.name"),cat,rsParked.getBoolean("v.isFree"),rsParked.getInt("v.fuelInCar"),rsParked.getInt("v.capacityFuel"));
		        	listVehicles.add(vel);
		        }
		        Agency ag = new Agency(rs.getString("name"),rs.getInt("phone"),rs.getString("gpscoords"),ad, listVehicles);
	        	listAgencies.add(ag);
	        }
	        
		} catch (SQLException e) {
			System.out.println("msg : " + e.getMessage());
			return null;
		}
      
		return listAgencies;
	}
	
	
	//METHODS PERSON
	
	public void addPerson(String firstname, String lastname, String mail, int phone, String url, String usr, String pass, String address)  throws SQLException{
		@SuppressWarnings("unused")
		int n = 0;
			n = MyStmt.executeUpdate("INSERT INTO PERSON (EMAIL, FIRSTNAME, ID_ADDRESS, LASTNAME, PHONE) VALUES ('"+mail+"','"+firstname+"','"+address+"','"+lastname+"','"+phone+"');");
	}
	
	public void deletePerson(int id_person) throws SQLException{
		MyStmt = conn.prepareStatement("delete from Person where ID_Person=?");
		MyStmt.setInt(1, id_person);
		MyStmt.executeUpdate(); 
	      System.out.println("Record deleted successfully");
	}
	
	/*
	public void modifyPerson(int id_person, String firstname, String lastname, String mail, int phone, String url, String usr, String pass, String address) throws SQLException {
		deletePerson(id_person);
		addPerson(firstname,  lastname,  mail,  phone,  url,  usr,  pass, address);
		
	}
	*/
	
	public void updatePerson(Connection con, Person person, String mail, String firstname, String address, String lastname, int phone) throws SQLException{
		Statement MyStmt = con.createStatement();
		MyStmt.executeUpdate("UPDATE INTO PERSON (EMAIL, FIRSTNAME, ID_ADDRESS, LASTNAME, PHONE) VALUES ('"+mail+"','"+firstname+"','"+address+"','"+lastname+"','"+phone+"' Where ID_Person = '"+person.getId()+"');");
	    }
	//METHODS VEHICLE
	
	public void addVehicle(Boolean Airconditioned, String brad, int fuelquantity, boolean isfree, int kilometers, String model, int REGISTRATIONNUMBER, Category categories, String fuels, String gearboxes) throws SQLException {
		@SuppressWarnings("unused")
		int n = 0;
			Statement state = connect.createStatement();
			
			n = state.executeUpdate("INSERT INTO VEHICLE (AIRCONDITIONED, BRAND, FUELQUANTITY, CATEGORIES, FUELS, GEARBOXES, ISFREE, KILOMETERS, MODEL, REGISTRATIONNUMBER) VALUES ('"+Airconditioned+"','"+brad+"','"+fuelquantity+"','"+categories+"','"+fuels+"','"+gearboxes+"','"+isfree+"','"+kilometers+"','"+model+"','"+REGISTRATIONNUMBER+"');");
	}
	
	public void updateVehicle(Connection con, Vehicle vehicle, Boolean Airconditioned, String brad, int fuelquantity, boolean isfree, int kilometers, String model, int REGISTRATIONNUMBER, Category categories, String fuels, String gearboxes) throws SQLException{
		Statement MyStmt = con.createStatement();
		MyStmt.executeUpdate("UPDATE VEHICLE (AIRCONDITIONED, BRAND, FUELQUANTITY, CATEGORIES, FUELS, GEARBOXES, ISFREE, KILOMETERS, MODEL, REGISTRATIONNUMBER) VALUES ('"+Airconditioned+"','"+brad+"','"+fuelquantity+"','"+categories+"','"+fuels+"','"+gearboxes+"','"+isfree+"','"+kilometers+"','"+model+"','"+REGISTRATIONNUMBER+"' Where ID_Vehicle = "+vehicle.getRegistrationNumber()+");");
	    }
	
	public void deleteVehicle(int Vehicle) throws SQLException{
		MyStmt = conn.prepareStatement("delete from Vehicle where ID_VEHICLE=?");
		MyStmt.setInt(1, Vehicle);
		MyStmt.executeUpdate(); 
	      System.out.println("Record deleted successfully");
	}
	
	
	//METHODS ASKED
	
	ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public void VehicleCatDisp(String categorie, boolean isfree) throws SQLException {
		MyStmt = conn.prepareStatement("SELECT * from Vehicle where categories = ? and isfree = ?");
		MyStmt.setString(1,categorie);
		MyStmt.setBoolean(2, isfree);
		myRs = MyStmt.executeQuery();
		System.out.println(myRs);
		while(myRs.next()) {
			vehicles.add(new Vehicle(myRs.getString(1),myRs.getString(2),myRs.getString(3),myRs.getInt(4),myRs.getBoolean(5),myRs.getString(6),myRs.getString(7), myRs.getCategory.getInt(8),myRs.getBoolean(9),myRs.getInt(10), myRs.getInt(11)));
		}
}
	
	public void carResearcher(String car) throws SQLException {
				
			MyStmt = conn.prepareStatement("SELECT * from Vehicle where brand = ?");
			MyStmt.setString(1,car);
			myRs = MyStmt.executeQuery();
			while(myRs.next()) {
				vehicles.add(new Vehicle(myRs.getString(1),myRs.getString(2),myRs.getString(3),myRs.getInt(4),myRs.getBoolean(5),myRs.getString(6),myRs.getString(7), myRs.getString(8),myRs.getBoolean(9),myRs.getInt(10), myRs.getInt(11)));
			}
		}
	
	public void lastnameResearcher(String lastname) throws SQLException {
		
		MyStmt = conn.prepareStatement("SELECT * from Person where lastname = ?");
		MyStmt.setString(1,lastname);
		myRs = MyStmt.executeQuery();
		while (myRs.next()) {
			
		}
	}
	
	public void vehiclecurrentrental(boolean isfree) throws SQLException{
			MyStmt = conn.prepareStatement("SELECT * FROM VEHICLE WHERE ISFREE = ?");
			MyStmt.setBoolean(1,isfree);
			myRs = MyStmt.executeQuery();
			while (myRs.next()) {		
			}
	}
	
	public void clientcurrentrental() throws SQLException{
		MyStmt = conn.prepareStatement("SELECT * FROM CLIENT Inner join Quotation on quotation.ID_CLIENT = CLIENT.ID_CLIENT inner join RENTAL on QUOTATION.id_quotation = rental.ID_QUOTATION ;");
		myRs = MyStmt.executeQuery();
		while (myRs.next()) {		
		}
	}
	
	public void historyVehicleByClient(String vehicle) throws SQLException{
		MyStmt = conn.prepareStatement("SELECT * FROM CLIENT INNER JOIN BILL on BILL.ID_CLIENT = CLIENT.ID_CLIENT where ID_VEHICLE = ?;");
		MyStmt.setString(1,vehicle);
		myRs = MyStmt.executeQuery();
		while (myRs.next()) {		
		}
	}	
}