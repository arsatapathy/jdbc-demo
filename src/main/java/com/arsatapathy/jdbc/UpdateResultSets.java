package com.arsatapathy.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateResultSets {
	public static void main(String args[]) throws SQLException {
		try(
				Connection con = DBUtil.getConnection(DBType.ORADB);
				Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stm.executeQuery("select * from employees where employee_id = '101'");
		   ){
			rs.updateString("first_name", "ashish satapathy");
			rs.updateRow();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
