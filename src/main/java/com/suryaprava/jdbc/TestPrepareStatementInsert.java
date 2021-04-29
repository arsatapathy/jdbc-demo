package com.suryaprava.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestPrepareStatementInsert {
	public static void main(String args[]) throws SQLException {
		Connection con = DBUtil.getConnection(DBType.ORADB);
		PreparedStatement pStmt = con.prepareStatement("update emp set emp_name = ?");
		pStmt.setString(1, "xx");
		
		
		int result = pStmt.executeUpdate();
		
		System.out.println("Number of rows updated " + result);
		
	}

}
