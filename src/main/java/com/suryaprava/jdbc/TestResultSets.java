package com.suryaprava.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestResultSets {

	public static void main(String[] args) throws SQLException {
		Connection connection = null; 
		Statement statement = null; 
		ResultSet resultSet = null; 
		
		try {
			connection = DBUtil.getConnection(DBType.ORADB);
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from Employees");
			
			String format ="%-6s%-20s";
			System.out.format(format,"EmpId","EmpName");
			while(resultSet.next()) {
				System.out.println();
				System.out.format(format,resultSet.getString("EMPLOYEE_ID"),resultSet.getString("First_Name"));
				
			}
			
			
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally {

			if (resultSet != null) 
				resultSet.close();
			if (statement != null) 
				statement.close(); 
			if (connection != null)
				connection.close();
		}

	}
	
}

