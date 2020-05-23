package com.demo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.model.ConnectDB;
/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		if(session==null || session.getAttribute("user")==null) {
			response.sendRedirect("login.jsp");
		}else {
			ConnectDB conn=new ConnectDB();
			int users=conn.getAllUser().size();
			int posts=conn.getAllPost().size();
			com.demo.model.Dashboard dashboard=new com.demo.model.Dashboard();
			dashboard.setUsers(users);
			dashboard.setPosts(posts);
			request.setAttribute("dashboard", dashboard);
			RequestDispatcher rDispatcher=request.getRequestDispatcher("dashboard.jsp");
			rDispatcher.forward(request, response);
		}
			
	}

}
