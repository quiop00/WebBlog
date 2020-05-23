package com.demo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.model.ConnectDB;
import com.demo.model.Post;

/**
 * Servlet implementation class GetPostInfor
 */
@WebServlet("/Post")
public class GetPostInfor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPostInfor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idPost=request.getParameter("id");
		ConnectDB conn=new ConnectDB();
		Post post=new Post();
		post=conn.getPost(idPost);
		if(post!=null) {
			request.setAttribute("post", post);
			System.out.println(post.getTitle());
		}
		else {
			System.out.println("Error");
		}
		RequestDispatcher rDispatcher=request.getRequestDispatcher("post.jsp");
		rDispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
