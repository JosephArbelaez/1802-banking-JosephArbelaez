package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class ConnectionUtil {

	private static Logger logger = Logger.getLogger(ConnectionUtil.class);
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:oracle:thin:@josepharbelaezrevature.c5dmvhjfs1dd.us-east-1.rds.amazonaws.com:1521:ORCL";
		String username = "JosephArbelaez";
		String password = "Miroku031890!";

		return DriverManager.getConnection(url, username, password);
	}

	public static void main(String[] args){
		// Try with resources automatic

		// Classes in this kind of try need to implement AutoCloseable
		try(Connection connection = ConnectionUtil.getConnection()){
			logger.info("Connection Successful!");
		} catch (SQLException e){
			logger.error("Couldn't connect to the database.", e);
		}
	}
}
