package com.read.read;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class JdbcPreparedStatement {
	public static void main(String[] args) {
		try {
			// create a mysql database connection

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "root");

			// the mysql insert statement
			String query = " insert into advancedjavamembers (Name, Age)" + " values (?,?)";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			preparedStmt.setString(1, "Anji");
			preparedStmt.setString(2, "27");

			// execute the preparedstatement
			preparedStmt.execute();
			System.out.println("execution complete");

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}
}
