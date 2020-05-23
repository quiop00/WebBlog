package com.demo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.mysql.cj.api.Session;

public class Auth {
	private ConnectDB connectDB;
	private PreparedStatement stmt;
	private ResultSet rs=null;
	private Connection conn;
	public Auth() {
		
	}
	public boolean checkUser(String username) {
		connectDB=new ConnectDB();
		String sql="SELECT username FROM admin WHERE username=?";
		try {
			conn=connectDB.getConnectDB();
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, username);
			rs=stmt.executeQuery();
			int count=0;
			while(rs.next()) {
				count++;
			}
			stmt.close();
			conn.close();
			if(count==1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean authUser(String username,String password) {
		connectDB=new ConnectDB();
		String sql="SELECT * FROM admin WHERE username=? AND password=?";
		try {
			conn=connectDB.getConnectDB();
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,username);
			stmt.setString(2,password);
			rs=stmt.executeQuery();
			int count=0;
			while(rs.next()) {
				count++;
			}
			stmt.close();
			conn.close();
			if(count==1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean addUser(String username,String password) {
		connectDB=new ConnectDB();
		int result=0;
		String sql="INSERT INTO admin (username,password) VALUES(?,?);";
		try {
			conn=connectDB.getConnectDB();
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			result=stmt.executeUpdate();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result>0;
	}
	
}
