package com.suryaprava.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class TestCallableOut {

	public static void main(String[] args) {
		try(
				Connection con = DBUtil.getConnection(DBType.ORADB);
				CallableStatement cStmt = con.prepareCall("{call GetTotEmpByDept(?,?)}");
				Scanner sc = new Scanner(System.in);
				){
			
			System.out.print("Department Id: ");
			String dept = sc.nextLine();
			
			cStmt.setString(1, dept);
			
			cStmt.registerOutParameter(2, Types.INTEGER);
			
			cStmt.execute();
			
			int totEmp = cStmt.getInt(2);
			
			System.out.println("Total Emp " + totEmp);
			
		}catch(SQLException e) {
			DBUtil.showErrorMessage(e);
		}

	}

}
