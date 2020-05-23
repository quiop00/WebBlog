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
import com.demo.model.Page;
import com.demo.model.Post;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
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
		int numPage=1;
		if(request.getParameter("page")!=null) {
			numPage=Integer.valueOf(request.getParameter("page"));
		}
		
		ArrayList<Post> listPost=(new ConnectDB()).getLimitPost((numPage-1)*5,5);
		if(listPost!=null) {
			request.setAttribute("posts", listPost);
		}
		Page page=new Page();
		page.setIndex(numPage);
		page.setHasNext(numPage*5<(new ConnectDB()).getAllPost().size());
		page.setHasPrev(numPage>1);
		request.setAttribute("page", page);
		//response.sendRedirect("posts.jsp");
		RequestDispatcher rDispatcher=request.getRequestDispatcher("home.jsp");
		rDispatcher.forward(request, response);
	}

}
