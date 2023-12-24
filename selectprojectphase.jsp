<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Select Project Phase</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/boot.css">
<link rel="stylesheet" type="text/css" href="css/studentdashboard.css">
<style type="text/css">
body {
	background-color: #CAD4D3;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#section-a">Project Management
					System</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="dashboard.jsp">Home</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="index.html">Logout &nbsp;<span
						class="glyphicon glyphicon-off"></span></a></li>
			</ul>

		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">


				<form class="form-inline" action="viewreport">
					<div class="form-group mx-sm-3 mb-2 mr-2">
						<select class="custom-select" name="phase">
							<option selected value="1">Phase One</option>
							<option value="2">Phase Two</option>
							<option value="3">Phase Three</option>
						</select>
					</div>
					<button type="submit" class="btn btn-primary mb-2 ml-2">View
						Report</button>
				</form>

			</div>
			<div class="col-md-4"></div>
		</div>

	</div>
</body>
</html>