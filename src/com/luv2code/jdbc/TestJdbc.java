package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSl=false";
		String user="hbstudent";
		String pass="hbstudent";
		
		
	
		 try {
			 System.out.println("connecting to database "+jdbcUrl);
			 Connection myConn=DriverManager.getConnection(jdbcUrl, user, pass);
			 System.out.println("connection successfull");
		 
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}