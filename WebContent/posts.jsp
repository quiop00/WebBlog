<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="icon" href="../../favicon.ico">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <title>Posts | Dashboard</title>
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap3.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
  </head>
  <body>
  	 <nav class="navbar navbar-default">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="Home">HOME</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a>Welcome</a></li>
            <li><a href="login.jsp">Logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <header id="header">
    <div class="container">
    	<div class="row">
    		<div class="col-md-10">
    			<h1><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Dashboard <small>Manage your site</small></h1>

    		</div>
    	</div>
    </div>
    </header>
    <section id="breadcrumb">
    	<div class="container">
    		<ol class="breadcrumb">
    			<li class="active">Post</li>
    		</ol>
    	</div>
    </section>
    <section id="main">

    	<div class="container">
    	<div class="row">
    		<div class="col-md-3">
			  <div class="list-group">
			  <a href="Dashboard" class="list-group-item ">
			    <span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Dashboard
			  </a>
			  <a class="list-group-item active main-color-bg"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Posts <span class="badge">${dashboard.posts}</span></a>
			  <a href="ControlGetUser" class="list-group-item"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Users <span class="badge">${dashboard.users}</span></a>
			</div>
			<div class="well ">
			<h4>Disk Space Used</h4>
							<div class="progress">
			  <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
			    60%
			  </div>
			</div>
			<h4>Band Width Used</h4>
							<div class="progress">
			  <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
			    60%
			  </div>
			</div>
    		</div>
    		</div>
    		<div class="col-md-9">
    					<!-- Website Overview -->
			  <div class="panel panel-default">
			  <div class="panel-heading main-color-bg">
			    <h3 class="panel-title">Posts</h3>
			  </div>
			  <div class="panel-body">
			  <div class="row" id="panel">
			  	<div class="col-md-9">
			  		<input type="text" class="form-control" placeholder="Filter Pages">
			  	</div>
			  	<div class="col-md-3">
			  		<input onclick="addPost()" class="btn btn-success" type="button" value="Add new post">
			  	</div>
			  </div>
			  <br>
			  <div id="add" style="display:none">
			     <form action="AddPost" method="post" enctype="multipart/form-data">
			     
			     	<div class="form-group">
			           <label>Image Post</label>
			           <input type="file" name="file" id="img-post" onchange="return fileValidation()">
			           <div id="error-file-validation" style="display:none;color:red;">File must be an image</div>	
			           <div id="img-preview" width="100px" height="100px"></div>		     
			        </div>
			  	    <div class="form-group">
			           <label>Page Title</label>
			           <input type="text" class="form-control" name="title" placeholder="Page Title" required>  
			        <div class="form-group">
			           <label>Page Content</label>
			           <textarea name="content" id="content" class="form-control" placeholder="Page Content"></textarea>
			        </div>
      	            </div>
      	            <div style="float:right">
      	            <button onclick="showPost()" type="button" class="btn btn-default">Close</button>
                    <button type="submit" class="btn btn-primary">Save</button>
            		</div>
            	</form>
			  </div>
			  <div id="show" style="display:block">
			  <table class="table table-striped table-hover">
			  	<col width="60">
                <col width="200">
				    	<tr>
				    	<th>ID</th>
				    	<th>Title</th>
					    <th>Image Post</th>
				    	<th>Created</th>
				    	<th></th>
				    	</tr>
				    	<c:forEach items="${posts}" var="posts">
				    	  <tr>
				    	    <td>${posts.id}</td>
				    	    <td><a href="Edit?id=${posts.id}">${posts.title}</a></td>
				    	    <td><img src='<c:url value="${posts.imgPost }"/>' width="80px" height="80px"></td>
				    	    <td>${posts.createTime}</td>
				    	    <td><a href="DeletePost?id=${posts.id}" class="btn btn-danger">Delete</a></td>
				    	  </tr>
				    	</c:forEach>
				    </table>
				    </div>
			  </div>
			</div>
			<!-- Latest Users -->
			</div>
			</div>
			</div>
    </section>
    <script src="libraries/ckeditor/ckeditor.js"></script>
    <script src="libraries/ckfinder/ckfinder.js"></script>
    <script>
    CKEDITOR.replace('content',{
    	filebrowserBrowseUrl : 'http://localhost:8080/WebBlog/libraries/ckfinder/ckfinder.html',
    	filebrowserImageBrowseUrl : 'http://localhost:8080/WebBlog/libraries/ckfinder/ckfinder.html?type=Images',
    	filebrowserFlashBrowseUrl :'http://localhost:8080/WebBlog/libraries/ckfinder/ckfinder.html?type=Flash',
    	filebrowserUploadUrl : 'http://localhost:8080/WebBlog/libraries/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Files',
    	filebrowserImageUploadUrl : 'http://localhost:8080/WebBlog/libraries/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Images',
    	entities: false,
        basicEntities: false,
        entities_greek: false,
        entities_latin: true,
    });
    </script>
    <script type="text/javascript">
        //show the dialog to add a new post
    	function addPost(){
    		document.getElementById("add").style.display="block";
    		document.getElementById("show").style.display="none";
    		document.getElementById("panel").style.display="none";
    	}
        //close the dialog 
    	function showPost(){
    		//document.getElementById("add").style.display="none";
    		//document.getElementById("show").style.display="block";
    		//document.getElementById("panel").style.display="block";
    		location.reload(true);
    	}
    </script>
    <!-- Image validation -->
    
    <script type="text/javascript">
    	function fileValidation(){
    		var fileInput=document.getElementById("img-post");
    		var filePath=fileInput.value;
    		var allowExtensions=/(\.jpg|\.jpeg|\.png|\.gif)$/i;
    		if(!allowExtensions.exec(filePath)){
    			document.getElementById("error-file-validation").style.display="block";
    			fileInput.value="";
    			return false;
    		}else{
    			if(fileInput.files&&fileInput.files[0]){
    				document.getElementById("error-file-validation").style.display="none";
    				var reader=new FileReader();
    				reader.onload=function(e){
    					document.getElementById("img-preview").innerHTML='<img width="200px" height="200px" src="'+e.target.result+'"/>'; 					
    				};
    				reader.readAsDataURL(fileInput.files[0]);
    			}
    		}
    	}
    </script>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  </body>
</html>
