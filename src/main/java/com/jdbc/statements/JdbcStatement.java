package com.read.read;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
		public class JdbcStatement {
		   public static void main(String[] args) {
			  try {
					Class.forName("com.mysql.jdbc.Driver"); // driver
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "root"); // connection
																														// url
																														// username
																														// password
					Statement stmt = (Statement) con.createStatement(); // statement
					ResultSet rs = stmt.executeQuery("select * from foodorder"); //resultset
					ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();
					System.out.println(metaData.getColumnName(1) + " " + metaData.getColumnName(2) + " " + metaData.getColumnName(3));
					while (rs.next())
						System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3)); // print
					con.close(); // close connection
				} catch (Exception e) {
					System.out.println(e);
				}
	}

}
