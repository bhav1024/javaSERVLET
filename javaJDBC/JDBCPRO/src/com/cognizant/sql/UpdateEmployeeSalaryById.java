package com.cognizant.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEmployeeSalaryById {
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
			
			System.out.println("New Employee salary:");
			double empSalary=sc.nextDouble();
			
			
			PreparedStatement statement=connection.prepareStatement("update EMPLOYEESCOGNIZANT set EMP_SALARY=? where EMP_ID=?");
			
			statement.setDouble(1, empSalary);
			statement.setInt(2, empId);

			
			int rows=statement.executeUpdate();
			if(rows>0){
				System.out.println("row UPDATED");
				
			}
			else{
				System.out.println("UPDATE failed");
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		

	}

}
