package com.read.read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import com.mysql.jdbc.PreparedStatement;

public class PreparedStatementInsertManyRecords {
	public static void main(String args[]) throws Exception {

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter no of members");
			int n = sc.nextInt();

			Class.forName("com.mysql.jdbc.Driver");

			// create jdbc connection object
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root",
					"root");

			String query = " insert into advancedjavamembers (Name, Age)" + " values (?,?)";

			// create prepapred statement obj
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);

			// read each member details from keyboard, set them to query
			// and execute the query
			if (ps != null && sc != null) {
				for (int i = 1; i <= n; i++) {
					System.out.println("Enter" + i + "members details");
					System.out.println("enter member name");
					String Name = sc.next();
					System.out.println("enter age");
					int Age = sc.nextInt();
					ps.setString(1, Name);
					ps.setInt(2, Age);

					// execute the query
					int res = ps.executeUpdate();
					if (res == 0)
						System.out.println(i + "details are not inserted");
					else
						System.out.println(i + "details are inserted");

				}
			}
			sc.close();
			con.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
