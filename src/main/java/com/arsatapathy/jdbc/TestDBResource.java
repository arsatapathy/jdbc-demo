package com.arsatapathy.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDBResource {

	public static void main(String[] args) {
		try(Connection con = DBUtil.getConnection(DBType.ORADB)){
			System.out.println("Connection Establish Successfully");
		}catch(SQLException e) {
			DBUtil.showErrorMessage(e);
		}
	}

}
