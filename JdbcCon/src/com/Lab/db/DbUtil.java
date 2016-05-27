package com.Lab.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbUtil {	
	
	private static final String URL="jdbc:MySQL://127.0.0.1:33550/kechengbiao?useSSL=true";
	private static final String USER="root";
	private static final String PASSWORD="123456";	
	private static Connection conn=null;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public static Connection  getconConnection(){
		return conn;
	}
}
