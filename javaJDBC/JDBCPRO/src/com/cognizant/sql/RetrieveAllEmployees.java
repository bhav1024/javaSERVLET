package com.cognizant.sql;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveAllEmployees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection=null;
		try {
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","System","root");
			
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from EMPLOYEESCOGNIZANT");
			System.out.println("EMP ID\t"+"EMP Name\t"+"EMP salary\t"+"EMP designation\n");
			
			while(resultSet.next()){
				System.out.println(resultSet.getInt("EMP_ID")+"\t"+resultSet.getString("EMP_NAME")+"\t\t"+resultSet.getDouble("EMP_SALARY")+"\t\t"+resultSet.getString("EMP_DESIGNATION"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try{
				connection.close();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
