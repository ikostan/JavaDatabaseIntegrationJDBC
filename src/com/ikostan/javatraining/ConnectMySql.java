package com.ikostan.javatraining;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMySql {

	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpassword";
	private static final String CONN_STRING = "jdbc:mysql://localhost/explorecalifornia";
	
	public static void main(String[] args) throws SQLException {
		
		//Class.forName("com.mysql.jdbc.Driver"); //There is no need for that since we work with Java 6 or 7
		
		Connection connection = null;
		
		try {
			
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			System.out.println("DB connection established");
		} 
		catch (SQLException e) {
			
			System.err.println(e);
		}
		finally
		{			
			if (connection != null) {
				
				connection.close();
			}
		}		
	}
}
