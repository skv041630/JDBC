package com;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo4 {

	public static void main(String[] args) {
		// Select Query
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/skvdb?autoReconnect=true&useSSL=false","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from employee");
			System.out.println("EMP_ID EMP_NAME SALRY DESIGNATION");
			while (rs.next()) {
				System.out.println(rs.getInt(1)+ " 	"+rs.getString(2)+"	"+rs.getInt(3)+" "+rs.getString(4));
			}
			Scanner sc=new Scanner(System.in);
			sc.close();
			
			stmt.close();
			con.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}

}
