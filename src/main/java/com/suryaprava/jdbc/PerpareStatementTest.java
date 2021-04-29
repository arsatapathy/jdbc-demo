package com.suryaprava.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PerpareStatementTest {
	public static void main(String args[]) throws SQLException {
		Connection con = null; 
		PreparedStatement pStmt = null;
		ResultSet rs = null; 
		
		String sql = "select * from employees where rownum = ?";
		try {
						
			con = DBUtil.getConnection(DBType.ORADB);
			pStmt = con.prepareStatement(sql);	
			prepareStatement(pStmt,rs,1);
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			if (rs != null) rs.close(); 
			if (pStmt != null) pStmt.close();
			if (rs != null) rs.close();
		}
	}

	public static void prepareStatement(PreparedStatement pStmt, ResultSet rs, int rowNum) throws SQLException{
		pStmt.setInt(1, rowNum);
		rs = pStmt.executeQuery();
		String format = "%-6s%-20s";
		System.out.format(format,"EmpId", "EmpName");
		while(rs.next()) {
			System.out.println();System.out.format(format,rs.getString("employee_id"), rs.getString("first_name"));
		}
		
	}

}
