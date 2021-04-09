package com.jdbc.statements;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class PreparedStatementMultipleInsert {
	public static void main(String args[]) throws Exception {
		try {
			// create a mysql database connection

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "root");

			// the mysql insert statement
			String query = " insert into advancedjavamembers (Name, Age)" + " values (?,?)";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);

			preparedStmt.setString(1, "Anji");
			preparedStmt.setInt(2, 27);
			preparedStmt.addBatch();

			preparedStmt.clearParameters();
			preparedStmt.setString(1, "Arya");
			preparedStmt.setInt(2,24);
			preparedStmt.addBatch();
			
			preparedStmt.clearParameters();
			preparedStmt.setString(1, "Sonu");
			preparedStmt.setInt(2,22);
			preparedStmt.addBatch();
			
			preparedStmt.clearParameters();
			preparedStmt.setString(1, "Aparna");
			preparedStmt.setInt(2,25);
			preparedStmt.addBatch();
			
			preparedStmt.clearParameters();
			preparedStmt.setString(1, "Narayana");
			preparedStmt.setInt(2,24);
			preparedStmt.addBatch();

			preparedStmt.clearParameters();
			  int[] results = preparedStmt.executeBatch();

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