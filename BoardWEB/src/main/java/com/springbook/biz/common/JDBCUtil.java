package com.springbook.biz.common;

import java.sql.*;

public class JDBCUtil {

	public static Connection getConnection(){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void close(PreparedStatement stmt,Connection conn){
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				stmt = null;
			}
		}
		
		
		if(conn != null){
			try {
				 conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn = null;
			}
		}
	}
	
	
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn){
		if(rs != null){
			try {
				 rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs = null;
			}
		}
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				stmt = null;
			}
		}
		
		
		if(conn != null){
			try {
				if(!conn.isClosed()) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn = null;
			}
		}
	}
}
