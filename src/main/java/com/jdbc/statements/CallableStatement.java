package com.jdbc.statements;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import com.mysql.jdbc.Connection;

public class CallableStatement {
	public static void main(String args[]) throws SQLException, ClassNotFoundException {
		// Registering the Driver
		/*DriverManager.registerDriver(new com.mysql.jdbc.Driver());*/
		Class.forName("com.mysql.jdbc.Driver");
		// Getting the connection
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false",
				"root", "root");
		System.out.println("Connection established......");
		// Preparing a CallableStatement to call a procedure
		java.sql.CallableStatement cstmt = con.prepareCall("{call food_order(?, ? ,?, ? )}");
		// Setting the value for the IN parameter
		cstmt.setInt(1, 1);
		// Registering the type of the OUT parameters
		cstmt.registerOutParameter(2, Types.VARCHAR);
		cstmt.registerOutParameter(3, Types.VARCHAR);
		cstmt.registerOutParameter(4, Types.INTEGER);
		// Executing the CallableStatement
		cstmt.executeUpdate();
		// Retrieving the values for product name, customer name and, price
		String name = cstmt.getString(2);
		String dish = cstmt.getString(3);
		int cost = cstmt.getInt(4);
		System.out.println("Details of the customer with given id are: ");
		// Displaying the values
		System.out.println("Name: " + name);
		System.out.println("Dish: " + dish);
		System.out.println("Price: " + cost);
	}
}