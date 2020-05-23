<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="icon" href="../../favicon.ico">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <title>Users | Dashboard</title>

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
            <li><a href="Logout">Logout</a></li>
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
    			<li class="active">Users</li>
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
			  <a href="ControlGetPost" class="list-group-item"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Posts <span class="badge">${dashboard.posts}</span></a>
			  <a class="list-group-item  active main-color-bg"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Users <span class="badge">${dashboard.users}</span></a>
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
			          <h3 class="panel-title">Users</h3>
			       </div>
			       <div class="panel-body">
			           <div class="row">
			  	          <div class="col-md-12">
			  		         <input type="text" class="form-control" placeholder="Filter Pages">
			  	          </div>
			           </div>
			           <br>
			           <table class="table table-striped table-hover">
				    	  <tr>
				    	     <th>Name</th>
				    	     <th>Email</th>
				    	     <th></th>
				    	     <th></th>
				    	  </tr>
				    	 <c:forEach items="${users}" var="users">
                         <tr>
                         <td>${users.username}</td>
						 <td>${users.email}</td>
						 <td></td>
						 <td></td>
                          </tr>
                          </c:forEach>
				       </table>
			       </div>
			   </div>
			<!-- Latest Users -->
           </div>
        </div>
    </section>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  </body>
</html>
