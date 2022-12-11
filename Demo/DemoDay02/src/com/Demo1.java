package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
public class Demo1 {

	public static void main(String[] args) {
		//Insert Query
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/skvdb?autoReconnect=true&useSSL=false","root","root");
		Statement stmt=con.createStatement();
		stmt.execute("insert into employee values (1010, 'Sam', 39700, 'Analyst')");
		PreparedStatement stmt2= con.prepareStatement("insert into employee values(?,?,?,?)");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee ID		   : ");
		int id=sc.nextInt();
		System.out.println("Enter Employee name        : ");
		String name=sc.next();
		System.out.println("Enter Employee Salary      : ");
		int sal=sc.nextInt();
		System.out.println("Enter Employee designation : ");
		String des=sc.next();
		System.out.println("Data inserted successfully...!!");
		stmt2.setInt(1, id);
		stmt2.setString(2, name);
		stmt2.setInt(3, sal);
		stmt2.setString(4, des);
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
