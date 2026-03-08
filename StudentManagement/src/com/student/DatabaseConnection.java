package com.student;
import java.sql.*;
public class DatabaseConnection {

	public static Connection getConnection() throws Exception{
		String url="jdbc:mysql://localhost:3306/studentdb";
		String username="root";
		String password="root";
		
		return DriverManager.getConnection(url,username,password);
	}

}
