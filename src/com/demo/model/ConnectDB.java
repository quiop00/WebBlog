package com.demo.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectDB {
	private Connection conn;
	private PreparedStatement stmt;
	public static Connection getConnectDB() {
		String databaseUrl="jdbc:mysql://localhost:3306/blog?useLegacyDatetimeCode=false&serverTimezone=UTC";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(databaseUrl,"root","");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//select data fromDB
	public ArrayList<User> getAllUser() {
		String sql="SELECT username,email FROM admin";
		ArrayList<User> listUser=new ArrayList<User>();
		int count=0;
		try {
			conn=getConnectDB();
			ResultSet rs=conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				User user=new User();
				user.setUsername(rs.getString(1));
				user.setEmail(rs.getString(2));
				listUser.add(user);
				count++;
			}
			conn.close();
			if(count>0) return listUser;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Post> getAllPost(){
		String sql="SELECT * FROM post";
		ArrayList<Post> listPost=new ArrayList<Post>();
		try {
			conn=getConnectDB();
			ResultSet rs=conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				Post post=new Post();
				post.setId(rs.getInt("idpost"));
				if(rs.getString("title").length()>20)
					post.setTitle(rs.getString("title").substring(0, 100));
				else
				    post.setTitle(rs.getString("title"));
				if(rs.getString("content").length()>200)
					post.setContent(rs.getString("content").substring(0, 200));
				else
				    post.setContent(rs.getString("content"));
				post.setImgPost(rs.getString("img_post"));
				post.setCreateTime(rs.getDate("create_time"));
				post.setAuthor(rs.getString("author"));
				listPost.add(post);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return listPost;
	}
	public ArrayList<Post> getLimitPost(int start,int limit){
		String sql="SELECT * FROM post limit "+limit+" offset "+start; //sql injection 
		                                                       //bug from connector jdbc: limit ? offset ? not work for this connector 
		ArrayList<Post> listPost=new ArrayList<Post>();
		try {
			conn=getConnectDB();
			stmt=conn.prepareStatement(sql);
			//stmt.setInt(1, start);
			//stmt.setInt(1, limit);
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Post post=new Post();
				post.setId(rs.getInt("idpost"));
				if(rs.getString("title").length()>20)
					post.setTitle(rs.getString("title").substring(0, 100));
				else
				    post.setTitle(rs.getString("title"));
				if(rs.getString("content").length()>200)
					post.setContent(rs.getString("content").substring(0, 200));
				else
				    post.setContent(rs.getString("content"));
				post.setImgPost(rs.getString("img_post"));
				post.setCreateTime(rs.getDate("create_time"));
				post.setAuthor(rs.getString("author"));
				listPost.add(post);
			}
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return listPost;
	}
	public Post getPost(String id) {
		String sql="SELECT * FROM post WHERE idpost=?";
		Post post=new Post();
		try {
			stmt=getConnectDB().prepareStatement(sql);
			stmt.setString(1, id);
		 	ResultSet rs=stmt.executeQuery();
		 	while(rs.next()) {
		 		post.setId(rs.getInt("idpost"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setImgPost(rs.getString("img_post"));
				post.setCreateTime(rs.getDate("create_time"));
				post.setAuthor(rs.getString("author"));
		 	}
		 	conn.close();
		}catch(Exception e) {}
		return post;
	}
	public boolean addNewPost(String title,String content,String imagePost,Date date) {	
		int result=0;
		String sql="INSERT INTO post (title,content,img_post,create_time) VALUES(?,?,?,?);";
		try {
			conn=getConnectDB();
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setString(3, imagePost);
			stmt.setDate(4, date);
			result=stmt.executeUpdate();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result>0;
	}
	public boolean editPost(int id,String title,String content,String imagePost,Date date) {
		int result=0;
		String sql="UPDATE post SET title=?,content=?,img_post=?,create_time=?  WHERE idpost=?;";
		try {
			conn=getConnectDB();
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setString(3, imagePost);
			stmt.setDate(4, date);
			stmt.setInt(5, id);
			result=stmt.executeUpdate();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result>0;
	}
	public boolean deletePost(int id) {
		int result=0;
		String sql="DELETE from post WHERE idpost=?;";
		try {
			conn=getConnectDB();
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, id);
			result=stmt.executeUpdate();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result>0;
	}
//	public int updateDatbase(String sqlQuery) {
//		try {
//			Statement statement=getConnectDB().createStatement();
//			int rs= statement.executeUpdate(sqlQuery);
//			getConnectDB().close();
//			return rs;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return 0;
//	}
}
