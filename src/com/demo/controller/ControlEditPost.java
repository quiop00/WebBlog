package com.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import com.demo.model.ConnectDB;

/**
 * Servlet implementation class ControlEditPost
 */
@WebServlet(name = "EditPost", urlPatterns = { "/EditPost" })
public class ControlEditPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlEditPost() {
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
		
		String title="";
		String content="";
		int id = 0;
		Calendar calender=Calendar.getInstance();
		Date createdTime=new Date(calender.getTime().getTime());
		String postImagePath="";
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);// see if is a multipart form
		if (isMultipart) {
			java.util.List<FileItem> multiparts = null;
			try {
				multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);//split the multipart form in diferent FIleItems
			} catch (FileUploadException e1) {
				e1.printStackTrace();
			}
			String inputName = null;
			for (FileItem item : multiparts) {
				if (item.isFormField()) { // Check if is a form data (different of file)
					inputName = (String) item.getFieldName();
					if(inputName.equalsIgnoreCase("id")) {
						id=Integer.valueOf(item.getString());
					}
					else
					if (inputName.equalsIgnoreCase("title")) {
						//important to show the utf-8
						title =new String (((String)item.getString()).getBytes (StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
					} else if (inputName.equalsIgnoreCase("content")) {
						content =new String (((String)item.getString()).getBytes (StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
					}
					if(inputName.equalsIgnoreCase("imgPath")) {
						postImagePath=(String) item.getString();
					}
				} else if (!item.isFormField()) { // Check if is a file
                    if(!item.getName().isEmpty()) {
                    	File fileAux = new File(System.getProperty("user.home")+"/eclipse-workspace/WebBlog/WebContent/images/" + item.getName()); // create a new file with the uploaded file
    					FileUtils.copyInputStreamToFile(item.getInputStream(), fileAux);// take the input file and transform
    					postImagePath="images/" + item.getName();
                    }			 															
				}
			}		
		}
		
		if(postImagePath.equals(""))
			postImagePath="/images/default.png";
		ConnectDB conn=new ConnectDB();
		if(!conn.editPost(id,title, content,postImagePath, createdTime)) {
			System.out.println("Error");
		}
		response.sendRedirect("ControlGetPost");
	}

}
