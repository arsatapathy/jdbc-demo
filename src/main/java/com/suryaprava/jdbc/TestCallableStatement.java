package com.suryaprava.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class TestCallableStatement {
	public static void main(String args[]) {
		try(
				Connection con = DBUtil.getConnection(DBType.ORADB);
				CallableStatement cStmt = con.prepareCall("{call GetEmpByDeptId(?,?)}");
				Scanner sc = new Scanner(System.in);
				){
			
			System.out.print("Department Id");
			String dept = sc.nextLine();
			
			cStmt.setString(1, dept);
			cStmt.registerOutParameter(2, OracleTypes.CURSOR);
			
			cStmt.execute();
			
			ResultSet rs = ((oracle.jdbc.internal.OracleCallableStatement)cStmt).getCursor(2);
			
			String format = "%-6s%-20s%-10s";
			System.out.format(format, "EmpId","EmpName","DeptId");
			while(rs.next()) {
				System.out.println();
				System.out.format(format,rs.getString("emp_id"),rs.getString("emp_name"),rs.getString("emp_dept"));
			}
			
		}catch(SQLException e) {
			DBUtil.showErrorMessage(e);
		}
	}

}
