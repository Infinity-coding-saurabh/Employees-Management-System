package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBUtil;



public class UserDaoImpl implements UserDao
{
	 @Override
	 public boolean isValidUser(String username, String password) 
	 {
	        String query = "select * from emp where  username = ? and password = ?";
	    	 try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) 
	    	{

	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);

	            ResultSet resultSet = preparedStatement.executeQuery();
	            System.out.println("Query run");
	            return resultSet.next();     
	        } 
	    	 catch (SQLException e) 
	    	 {
	            e.printStackTrace();
	            return false;
		     }
	}
	 @Override
	public boolean addUser(User1 user) 
	{
		  String query = "insert into emp values(?,?,?)";

	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) 
	        {
	            preparedStatement.setString(1, user.getUsername());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.setString(3, user.getPassword());

	            int rowsAffected = preparedStatement.executeUpdate();
	            System.out.println("User added");
	            return rowsAffected>0;
	            
	        } 
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	            return false;
	        }
		
	}

}
