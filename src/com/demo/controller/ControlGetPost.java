package com.demo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.model.ConnectDB;
import com.demo.model.Post;

/**
 * Servlet implementation class ControlGetPost
 */
@WebServlet("/ControlGetPost")
public class ControlGetPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlGetPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Post> listPost=(new ConnectDB()).getAllPost();
		if(listPost!=null) {
			request.setAttribute("posts", listPost);
		}
		ConnectDB conn=new ConnectDB();
		int users=conn.getAllUser().size();
		int posts=listPost.size();
		com.demo.model.Dashboard dashboard=new com.demo.model.Dashboard();
		dashboard.setUsers(users);
		dashboard.setPosts(posts);
		request.setAttribute("dashboard", dashboard);
		//response.sendRedirect("posts.jsp");
		RequestDispatcher rDispatcher=request.getRequestDispatcher("posts.jsp");
		rDispatcher.forward(request, response);
	}

}
