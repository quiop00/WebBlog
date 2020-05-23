<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <meta charset="utf-8">
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <title>Blog Home</title>
  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="css/blog-home.css" rel="stylesheet">
</head>
<body onload="checkUser()">
  <!-- Navigation -->
  <% String user="";
     if(session.getAttribute("user")!=null){
    	 user=session.getAttribute("user").toString();
     }
  %>
  <input type="hidden" id="user" value=<%=user %>>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
     <!-- <a class="navbar-brand" href="#">Start Bootstrap</a>  --> 
      
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav">
          <li class="nav-item active">
            <a class="nav-link" href="Home">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Contact</a>
          </li>
        </ul>
        <ul class="navbar-nav ml-auto">
          <li class="nav-item" id="after-login1">
            <a class="nav-link btn " href="./login.jsp">Login</a>
          </li>
          <li class="nav-item" id="after-login2">
            <a class="nav-link btn " href="./register.jsp">Register</a>
          </li>
          <li class="nav-item" id="after-login" style="display:none;"> 
          	 <div class="dropdown">
   				 <button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown"><%=user %></button>
    			 <div class="dropdown-menu" role="menu">
                    <a class="dropdown-item" href="dashboard.jsp" target="_parent">Post</a>
                    <a class="dropdown-item" href="#">Logout</a>
                 </div>
            </div>  
          </li>
          
        </ul>
      </div>
    </div>
  </nav>
  <!-- Page Content -->
  <div class="container">
    <div class="row">
      <!-- Blog Entries Column -->
      <div class="col-md-8">
        <h1 class="my-4">
        Post
        </h1>
        <!-- Blog Post -->
  
        <div class="card mb-4">
          <img class="card-img-top" src="<c:url value="${post.imgPost }"/>" alt="Card image cap">
          <div class="card-body">
            <h2 class="card-title">${post.title}</h2>
            <p class="card-text">${post.content}</p>
          </div>
          <div class="card-footer text-muted">
            Posted on ${post.createTime} by
            ${post.author}
          </div>
        </div>
        <!-- Pagination -->
        <ul class="pagination justify-content-center mb-4">
          <li class="page-item">
            <a class="page-link" href="#">&larr; Older</a>
          </li>
          <li class="page-item disabled">
            <a class="page-link" href="#">Newer &rarr;</a>
          </li>
        </ul>
      </div>
      <!-- Sidebar Widgets Column -->
      <div class="col-md-4">
        <!-- Search Widget -->
        <div class="card my-4">
          <h5 class="card-header">Search</h5>
          <div class="card-body">
            <div class="input-group">
              <input type="text" class="form-control" placeholder="Search for...">
              <span class="input-group-btn">
                <button class="btn btn-secondary" type="button">Go!</button>
              </span>
            </div>
          </div>
        </div>
        <!-- Categories Widget -->
        <div class="card my-4">
          <h5 class="card-header">Categories</h5>
          <div class="card-body">
            <div class="row">
              <div class="col-lg-6">
                <ul class="list-unstyled mb-0">
                  <li>
                    <a href="#">Web Design</a>
                  </li>
                  <li>
                    <a href="#">HTML</a>
                  </li>
                  <li>
                    <a href="#">Freebies</a>
                  </li>
                </ul>
              </div>
              <div class="col-lg-6">
                <ul class="list-unstyled mb-0">
                  <li>
                    <a href="#">JavaScript</a>
                  </li>
                  <li>
                    <a href="#">CSS</a>
                  </li>
                  <li>
                    <a href="#">Tutorials</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <!-- Side Widget -->
        <div class="card my-4">
          <h5 class="card-header">Side Widget</h5>
          <div class="card-body">
            You can put anything you want inside of these side widgets. They are easy to use, and feature the new Bootstrap 4 card containers!
          </div>
        </div>
      </div>
    </div>
    <!-- /.row -->
  </div>
  <!-- /.container -->
  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
    </div>
    <!-- /.container -->
  </footer>
  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script type="text/javascript">
  	  function checkUser() {
		var user=document.getElementById("user").value;
		if(user.length>0){
			document.getElementById("after-login1").style.display="none";
			document.getElementById("after-login2").style.display="none";
			document.getElementById("after-login").style.display="block";
		}
	}
  </script>
</body>
</html>