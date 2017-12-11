package com.ikostan.javatraining;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSetImpl;

public class ConnectHsqlDb {

	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpassword";
	private static final String CONN_STRING = "jdbc:hsqldb:data/explorecalifornia";
	
	public static void main(String[] args) throws SQLException 
	{
		//Class.forName("com.mysql.jdbc.Driver"); //There is no need for that since we work with Java 6 or 7
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try 
		{
			//Connection object
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			System.out.println("DB (Hsql) connection established");
			
			//Read only result set
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
			
			//SQL query
			resultSet = statement.executeQuery("SELECT * FROM states");
			
			//Get last row index
			resultSet.last();
			
			//Print total number of rows
			System.out.println("Number of rows: " + resultSet.getRow());
		} 
		catch (SQLException e) 
		{			
			System.err.println(e); //Print error message
		}
		finally
		{			
			if (resultSet != null)
			{				
				resultSet.close(); //Close resultSet
			}
			
			if (statement != null)
			{				
				statement.close(); //Close statement
			}
			
			if (connection != null)
			{				
				connection.close(); //Close connection
			}
		}		
	}
}
