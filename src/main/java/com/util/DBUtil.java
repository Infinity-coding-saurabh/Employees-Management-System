package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil 
{
	 private static final String URL="jdbc:mysql://localhost:3306/saurabhdb";
	 private static final String USERNAME = "root";
	 private static final String PASSWORD = "root";
	 static {
	        try 
	        {
	            
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) 
	        {
	            e.printStackTrace();
	        }
	    }

	    public static Connection getConnection() throws SQLException 
	    {
	    	System.out.println("Connection complet!!");
	        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	    }
}
