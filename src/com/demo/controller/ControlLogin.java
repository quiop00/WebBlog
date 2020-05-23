package com.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.model.Auth;
import com.demo.model.User;

/**
 * Servlet implementation class ControlLogin
 */
@WebServlet("/ControlLogin")
public class ControlLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlLogin() {
        super();
        // TODO Auto-generated constructor stub
        
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doPost(req, resp);
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter p=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		RequestDispatcher rd=null;
		Auth auth=new Auth();
		if(auth.authUser(username, password)) {
			HttpSession sessionUser=request.getSession(true);
			User user=new User(username,password);
			sessionUser.setAttribute("user", username);
			//rd=request.getRequestDispatcher("/home.jsp");
			//rd.forward(request, response);
			response.sendRedirect("Home");
		}
		else {
			System.out.println("Password incorrect");
			//p.print("<font color='red'>User or password is incorrect</font>");
			//rd=request.getRequestDispatcher("index.jsp");
			//rd.include(request, response);
		}		
	}

}
