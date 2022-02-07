package de.telekom.sea7;

import java.sql.*;

import java.util.Properties;

public class DBVerbindung {

	public static void main(String[] args) {
		// System.out.println(DBVerbindung.class.getCanonicalName());

//		// Laden des Treibers
//		final String DRIVER = "org.mariadb.jdbc.Driver";
//
//		try {
//			Class.forName(DRIVER);
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		// Connection
		final String URL = "jdbc:mariadb://localhost:3306/myfirstdb";
		String user = "admin";
		String password = "start123";
		try (Connection con = DriverManager.getConnection(URL, user, password)) {
			System.out.println("Verbindung erfolgreich hergestellt!");
			try (Statement stm = con.createStatement()) {
				try (ResultSet rs = stm.executeQuery("select count(*) from personen")) {
				//try (ResultSet rs = stm.executeQuery("update personen set Vorname = 'Adelheit' where id = 5")) {
				//try (ResultSet rs = stm.executeQuery("delete from personen where id = 5")) {	
				//try (ResultSet rs = stm.executeQuery("insert into personen (Vorname, Nachname) values ('Harald','Juncke')")){ 
				try (ResultSet za = stm.executeQuery("select * from zahlungen")) {
						while (rs.next()) {
							// System.out.println(rs.getString(1) + " " + rs.getString(2) + " " +
							// rs.getString(3));
							System.out.println(rs.getString(1));
						}
						while (za.next()) {
							System.out.println(za.getString(1) + " " + za.getString(2) + " " + za.getString(3) + " "
									+ za.getString(4) + " " + za.getString(5));
						}

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
	}
}
