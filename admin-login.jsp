<!DOCTYPE html>
<html lang="en">
<head>
<title>Project Management System</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="index.html">Project Management
					System</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="index.html">Home</a></li>
				<li><a href="Signup.html">Sign Up</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		
		<div class="panel-group col-sm-offset-7">
		<h2>Admin Login</h2>
			<div class="panel panel-info">
				<div class="panel-heading">Admin Login</div>
				<div class="panel-body">
					<form action="admin-login-process.jsp" method="post">
						<div class="form-group">
							<label for="email">Email address:</label> <input type="email" name="email"
								class="form-control" id="email" placeholder="Admin Email Id">
						</div>
						<div class="form-group">
							<label for="pwd">Password:</label> <input type="password" name="password"
								class="form-control" id="pwd" placeholder="Password">
						</div>
						<button type="submit" class="btn btn-info">Login</button>
						<button type="reset" class="btn btn-danger">Cancel</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
