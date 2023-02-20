package com.sahib.learnJdbcConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcConnectivity {

	public static void main(String[] args) throws SQLException {
		Connection connection;
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/girrafe", "root", "root");
		ResultSet resultSet;
		System.out.println("Connection Established");

		Statement statement = connection.createStatement();
		String data = "Select * from employee";
		resultSet = statement.executeQuery(data);
		System.out.println(resultSet);

//		while (resultSet.next()) {
//			String firstName = resultSet.getString("first_name");
//			System.out.println(firstName);
//		}
		
		ArrayList<EmployeeData> employeeList = new ArrayList<EmployeeData>();
		while (resultSet.next()) {
			EmployeeData employeeData = new EmployeeData();
			employeeData.setFirstName(resultSet.getString("first_name"));
			employeeList.add(employeeData);
		}
		System.out.println(employeeList.get(0).getFirstName());
		connection.close();
	}

}
