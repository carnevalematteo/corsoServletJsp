package com.corso.config;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionDb {

	 	private String jdbcURL = "jdbc:mysql://localhost:3306/corso?useSSL=false&serverTimezone=UTC";
	    private String jdbcUsername = "root";
	    private String jdbcPassword = "admin";


	  public Connection getConnection() {
	        Connection connection = null;
	        try {
	        	Class.forName("com.mysql.jdbc.Driver");
	            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	        } catch (SQLException | ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return connection;
	    }
	  
	  
	 

}

