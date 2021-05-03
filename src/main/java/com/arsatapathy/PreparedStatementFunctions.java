package com.arsatapathy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementFunctions {
	
	public static void main(String args[]) throws SQLException{
		try(
			Connection con = null; 
			PreparedStatement pStmt = null; 
			){
			
			
			String sql = "delete from emp where emp_id = ?";
			String parms[] = {"3"};
			preparedStatmentFunction(con, pStmt, sql, parms);
			
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void preparedStatmentFunction(Connection con, PreparedStatement pStmt,String sql,String parms[]) throws SQLException{
		con = DBUtil.getConnection(DBType.ORADB);
		pStmt = con.prepareStatement(sql);
		int i = 1; 
		int rowCount; 
		
		for (String parm :parms) {
			pStmt.setString(i, parm);
			i++;
		}
		
		rowCount = pStmt.executeUpdate();
		
		System.out.println("Number of rows " + rowCount);
		
		
	}

}
