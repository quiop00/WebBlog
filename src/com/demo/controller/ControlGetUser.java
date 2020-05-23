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
import com.demo.model.User;

/**
 * Servlet implementation class ControlGetUser
 */
@WebServlet("/ControlGetUser")
public class ControlGetUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlGetUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnectDB conn=new ConnectDB();
		ArrayList<User> listUsers=new ArrayList<User>();
		if(conn.getAllUser()!=null) {
			listUsers=conn.getAllUser();
			request.setAttribute("users", listUsers);
		}
		int users=listUsers.size();
		int posts=conn.getAllPost().size();
		com.demo.model.Dashboard dashboard=new com.demo.model.Dashboard();
		dashboard.setUsers(users);
		dashboard.setPosts(posts);
		request.setAttribute("dashboard", dashboard);
		RequestDispatcher rd=null;
		rd=request.getRequestDispatcher("/users.jsp");
		rd.forward(request, response);
	}

}
