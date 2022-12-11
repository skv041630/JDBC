package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) {
		//Delete Query
		try {
			Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/skvdb?autoReconnect=true&useSSL=false","root","root");
		Statement stmt=con.createStatement();
		stmt.execute("delete from employee where EMP_ID=1010");
		PreparedStatement stmt2= con.prepareStatement("delete from employee where EMP_ID=?");
		System.out.println("Enter employee ID that you want to delete record :");
		int delid=sc.nextInt();
		stmt2.setInt(1, delid);
		stmt2.execute();
		stmt.close();
		stmt2.close();
		con.close();
		sc.close();
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}

}
