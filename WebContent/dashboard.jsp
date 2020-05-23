<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="icon" href="../../favicon.ico">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <title>Admin Home | Dashboard</title>

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
            <li><a>Welcome ${session.getAtribute("user").toString()}</a></li>
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
    			<li class="active">Dashboard</li>
    		</ol>
    	</div>
    </section>
    <section id="main">
    <div class="container">
    	<div class="row">
    		<div class="col-md-3">
			  <div class="list-group">
			  <a href="dashboard.jsp" class="list-group-item active main-color-bg">
			    <span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Dashboard
			  </a>
			  <a href="ControlGetPost" class="list-group-item"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Posts <span class="badge">${dashboard.posts}</span></a>
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
			    			<div class="panel panel-default" id="loadPage">
			  <div class="panel-heading main-color-bg">
			    <h3 class="panel-title">Website Overview</h3>
			  </div>
			  <div class="panel-body">
			    <div class="col-md-4">
			    	<div class="well dash-box">
			    		<h2><span class="glyphicon glyphicon-user" aria-hidden="true"></span>${dashboard.users}</h2>
			    		<h4>Users</h4>
			    	</div>
			    </div>
			    <div class="col-md-4">
			    	<div class="well dash-box">
			    		<h2><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>${dashboard.posts}</h2>
			    		<h4>Posts</h4>
			    	</div>
			    </div>
			    <div class="col-md-4">
			    	<div class="well dash-box">
			    		<h2><span class="fa fa-user-o" aria-hidden="true"></span> 100k</h2>
			    		<h4>Visitors</h4>
			    	</div>
			    </div>
			  </div>
			</div>

			<!-- Latest Users -->

			<div class="panel panel-default" id="last-user">
				  <div class="panel-heading">
				    <h3 class="panel-title">Latest Users</h3>
				  </div>
				  <div class="panel-body">
				    <table class="table table-striped table-hover">
				    	<tr>
				    	<th>Name</th>
				    	<th>Email</th>
				    	<th>Joined</th>
				    	</tr>
				    </table>
				  </div>
				</div>
    		</div>
    	</div>
    </div>
    </section>

    <footer id="footer"><p>Copyright DN, &copy; 2017</p></footer>

     <!-- Modals -->

     <!-- Add Page -->
     <div class="modal fade" id="addPage" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    <form>
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Add Page</h4>
      </div>
      <div class="modal-body">
      	<div class="form-group">
			<label>Page Title</label>
			<input type="text" class="form-control" placeholder="Page Title">
			<div class="form-group">
			<label>Page Body</label>
			<textarea name="editor1" class="form-control" placeholder="Page Body"></textarea>
			</div>
			<div class="checkbox">
				<label><input type="checkbox">Published</label>
			</div>
			<div class="form-group">
			<label>Meta Tags</label>
			<input type="text" class="form-control" placeholder="Add some tags">
			</div>
			<div class="form-group">
			<label>Meta Description</label>
			<input type="text" class="form-control" placeholder="Add Meta description">
			</div>
      	</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Save changes</button>
      </div>
      </form>
    </div>
  </div>
</div>




    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->

    <script type="text/javascript">
    	function getPostPage(){
    		document.getElementById("last-user").style.display="none";
    		$("#loadPage").load("ControlGetPost");
    	}
    	function getUserPage(){
    		document.getElementById("last-user").style.display="none";
    		$("#loadPage").load("ControlGetUser");
    	}
    </script>
   
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  </body>
</html>
