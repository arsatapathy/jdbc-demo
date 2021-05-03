package com.arsatapathy.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class StoredProcedureTest {

	public static void main(String[] args) throws SQLException {
		try(
				Connection con = DBUtil.getConnection(DBType.ORADB);
				CallableStatement cStmt = con.prepareCall("{call emp_insert(?,?)}");
				){
			Scanner sc = new Scanner(System.in);
			System.out.print("Emp Id :");
			String empId = sc.nextLine();
			System.out.print("Emp Name :");
			String empName = sc.nextLine();
			
			cStmt.setString(1,empId);
			cStmt.setString(2,empName);
			
			cStmt.execute();
			
			System.out.println("Employee record added successfully");
			
		}catch(SQLException e) {
			DBUtil.showErrorMessage(e);
		}

	}

}
