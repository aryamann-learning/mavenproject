package com.jdbc.statements;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import com.mysql.jdbc.Connection;

public class CallingFunction {
	public static void main(String args[]) throws SQLException, ClassNotFoundException {
	      //Registering the Driver
		Class.forName("com.mysql.jdbc.Driver");
		// Getting the connection
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false","root", "root");
	      System.out.println("Connection established......");
	      //Preparing a CallableStatement to call a function
	      java.sql.CallableStatement cstmt = con.prepareCall("{? = call student_level(?)}");
	      //Registering the out parameter of the function (return type)
	      cstmt.registerOutParameter(1, Types.VARCHAR);
	      //Setting the input parameters of the function
	      cstmt.setInt(2, 90);
	      //Executing the statement
	      cstmt.execute();
	      System.out.print("Student Grade "+cstmt.getString(1));
	      
	   }
}
