package com.arsatapathy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String oraUsr = "hr";
	private static final String oraPwd = "hr1";
	private static final String oraUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public static Connection getConnection(DBType dbType) throws SQLException{
		Connection con = null; 
		
		switch (dbType){
			case ORADB: 
				con = DriverManager.getConnection(oraUrl, oraUsr, oraPwd);
				break;
			default: 
				break; 
		}
		return con; 
	}
	
	public static void showErrorMessage(SQLException e) {
		System.err.println("Error message " + e.getMessage());
		System.err.println("Error code " + e.getErrorCode()); 
	}

}
