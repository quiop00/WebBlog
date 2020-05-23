package com.demo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.model.Auth;
import com.demo.model.User;

/**
 * Servlet implementation class ControlRegister
 */
@WebServlet("/ControlRegister")
public class ControlRegister extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlRegister() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username+" "+password);
		Auth authUser=new Auth();
		if(!authUser.checkUser(username)) {
			if(authUser.addUser(username,password)) {
				User user=new User(username,password);
				request.setAttribute("user", user);
				RequestDispatcher rDispatcher=request.getRequestDispatcher("/success.jsp");
				rDispatcher.forward(request, response);
			}
			else {
				System.out.println("Loi");
			}
		}else {
			RequestDispatcher rDispatcher=request.getRequestDispatcher("/register.jsp");
			rDispatcher.forward(request, response);
		}
		
	}

}
