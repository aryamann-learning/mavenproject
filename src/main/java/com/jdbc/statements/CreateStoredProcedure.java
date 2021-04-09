package com.jdbc.statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStoredProcedure {
	public static void main(String[] args) {

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root",
				"root");

				Statement statement = conn.createStatement();) {

			/* String queryDrop = "DROP PROCEDURE IF EXISTS delete_book"; */

			String queryCreate = "CREATE PROCEDURE food_order (IN m_id INT,OUT m_Name varchar(20),OUT m_Dish VARCHAR(20),OUT m_Cost INT) ";
			queryCreate += "BEGIN ";
			queryCreate += "SELECT NAME, DISH, COST INTO m_Name, m_Dish, m_Cost FROM foodorder where ID = M_id; ";
			queryCreate += "END";

			// then creates a new stored procedure
			statement.execute(queryCreate);

			statement.close();

			System.out.println("Stored procedure created successfully!");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}




