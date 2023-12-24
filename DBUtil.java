package com.proj.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public enum DBUtil {
	db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		String dbName = "projectalloc";
		String url = "jdbc:mysql://localhost:3306/" + dbName + "?autoReconnect=true&useSSL=false";
		String userName = "root";
		String password = "Babalankesh09#";
		try {
			con = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}

	public void closeResources() {
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}

		if (con != null)
			try {
				con.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}
	}
}
