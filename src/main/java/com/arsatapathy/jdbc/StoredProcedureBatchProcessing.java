package com.arsatapathy.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class StoredProcedureBatchProcessing {
	public static void main(String args[]) {
		String yesNo; 
		try(
				Connection con = DBUtil.getConnection(DBType.ORADB);
				CallableStatement cStmt = con.prepareCall("{call emp_insert(?,?)}")
				){
			
			do{
				Scanner sc = new Scanner(System.in);
				System.out.print("Emp Id");
				String empId = sc.nextLine();
				
				System.out.print("Emp Name");
				String empName = sc.nextLine();
				
				System.out.print("Do you want to continue (Y/N)");
				yesNo = sc.nextLine();
				
				cStmt.setString(1, empId);
				cStmt.setString(2, empName);
				cStmt.addBatch();
				
			}while(yesNo.equals("Y") || yesNo.contentEquals("y"));
			
			int count[] = cStmt.executeBatch();
			
			
		}catch(SQLException e) {
			DBUtil.showErrorMessage(e);
		}
	}

}
 