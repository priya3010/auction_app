package com.auction.auction_app.utils;

import java.sql.*;

public class DBConnection {
	public Connection getDBConnection(){
		String url="jdbc:postgresql://localhost:5432/postgres";
		String name="postgres";
		String pass="0000";
		Connection conn=null;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//String query="select uname from public.\"User\"";
		try {
			conn=DriverManager.getConnection(url,name,pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/* Statement st=conn.createStatement();
		ResultSet rs= st.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		conn.close();
		System.out.println("Connection established");
		*/
		return conn;
		
	}
}
