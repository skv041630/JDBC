package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Demo3 {

	public static void main(String[] args) {
		//Update Query
		try {
			Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/skvdb?autoReconnect=true&useSSL=false","root","root");
		Statement stmt=con.createStatement();
		stmt.execute("update employee set EMP_Name='Badal' where EMP_ID=1009");
		PreparedStatement stmt2= con.prepareStatement("update employee set EMP_SALARY=? where EMP_ID=?");
		System.out.println("Enter employee salary :");
		int sal=sc.nextInt();
		System.out.println("Enter employee id for whom you want to update");
		int upid=sc.nextInt();
		stmt2.setInt(1, sal);
		stmt2.setInt(2, upid);
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
