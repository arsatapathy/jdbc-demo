package com.suryaprava.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TryWithResultSet {
	public static void main(String args[]) {
			
		try(Connection con = DBUtil.getConnection(DBType.ORADB); 
				Statement stm = con.createStatement(); 
				ResultSet rs = stm.executeQuery("select * from employees");
				
			){
				String format = "%-6s%-20s";
				System.out.format(format,"EmpId", "EmpName");System.out.println();
				while(rs.next()) {
					System.out.println();System.out.format(format,rs.getString("employee_id"),rs.getString("first_name"));
				}
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
