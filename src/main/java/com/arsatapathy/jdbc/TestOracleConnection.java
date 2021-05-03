package com.arsatapathy.jdbc;

import java.sql.*;

public class TestOracleConnection {
	public static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static String userName = "system";
	public static String password = "oracle";
	
	public static void main(String args[]) {
		try(Connection con = DriverManager.getConnection(url, userName, password)){
			System.out.println("Connection Establish Successfully");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
