
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DocTYPE html>
<html>
<head>
<title>Student Dashboard</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/boot.css">
<link rel="stylesheet" type="text/css" href="css/studentdashboard.css">

<style>
h1 {
	text-align: center;
	color: #130101;
}

h4 {
	text-align: center;
	color: #130101;
}

body {
	background-color: #CAD4D3;
}

.button {
	background-color: #E60808; /* Green */
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 16px;
}

.button2 {
	background-color: #E60808;
	border-radius: 16px;
} /* Blue */
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
				<li class="active"><a href="#">Home</a></li>
				<li class="active"><a href="searchproject.html">Search Projects</a></li>
				<li><a href="dashboard.jsp"> <span
						class="glyphicon glyphicon-refresh"></span>
				</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="index.html">Logout &nbsp;<span
						class="glyphicon glyphicon-off"></span></a></li>
			</ul>
		</div>
	</nav>
	<style>
body {
	background-image: url('blurimg1.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</style>

	<h1 align="center">Welcome Student</h1>
	<br>
	<h2 align="center">
		<%
			out.println("Name : " + session.getAttribute("name").toString().toUpperCase());
		%>
	</h2>
	<h3 align="center">
		<%
			out.println("USN : " + session.getAttribute("usn").toString().toUpperCase());
		%>
	</h3>
	<br>
	<br>
	<br>



	<div class="container">

		<a href="AddNewProjects.html"><button class="btn btn-primary"
				style="margin-left: 250px;">Add New Project</button></a> 
				<a
			href="showmyprojects">
			<button class="btn btn-primary" style="margin-left: 250px;">Show
				My Projects</button>
		</a>

	</div>
</body>

</html>