package com.demo.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import com.demo.model.ConnectDB;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
/**
 * Servlet implementation class AddNewPost
 */
@WebServlet("/AddPost")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 50, // 50MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AddNewPost extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	private static final String SAVE_DIR = "uploadFiles";
	private static final String  UPLOAD_DIR = "images";
    public AddNewPost() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String title="";
		String content="";
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
					if (inputName.equalsIgnoreCase("title")) {
						title = new String (((String)item.getString()).getBytes (StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
					} else if (inputName.equalsIgnoreCase("content")) {
						content =  new String (((String)item.getString()).getBytes (StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

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
		System.out.println(title);
		System.out.println(postImagePath);
		if(postImagePath.equals(""))
			postImagePath="/images/default.png";
		ConnectDB conn=new ConnectDB();
		if(!conn.addNewPost(title, content,postImagePath, createdTime)) {
			System.out.println("Error");
		}
		response.sendRedirect("ControlGetPost");
	}
	
}
