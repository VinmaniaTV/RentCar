package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAccess {
	
	private Connection conn;

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
}
