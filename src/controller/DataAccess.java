package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Category;
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
	
	public void modifyPerson(int id_person, String firstname, String lastname, String mail, int phone, String url, String usr, String pass, String address) throws SQLException {
		deletePerson(id_person);
		addPerson(firstname,  lastname,  mail,  phone,  url,  usr,  pass, address);
		
	}
	
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