package com.cognizant.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(
				Scanner sc=new Scanner(System.in);
				Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","System","root");
		){
			System.out.println("Employee Id:");
			int empId=sc.nextInt();
			System.out.println("Employee Name:");
			String empName=sc.next();
			System.out.println("Employee salary:");
			double empSalary=sc.nextDouble();
			System.out.println("Employee Designation:");
			String empDesignation=sc.next();
			
			PreparedStatement statement=connection.prepareStatement("Insert into EMPLOYEESCOGNIZANT values(?,?,?,?)");
			statement.setInt(1, empId);
			statement.setString(2, empName);
			statement.setDouble(3, empSalary);
			statement.setString(4, empDesignation);
			
			
			int rows=statement.executeUpdate();
			if(rows>0){
				System.out.println("rows are inserted");
				
			}
			else{
				System.out.println("Insertion failed");
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		

	}

}
