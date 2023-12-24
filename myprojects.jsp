<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DocTYPE html>
<html>

<head>
<title>ShowProjects</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="table.css">
<script type="text/javascript" src="table-color.js"></script>

</head>

<body>
	<form action="login.html">

		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#section-a">Project Management
						System</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="dashboard.jsp">Home</a></li>

				</ul>

			</div>
		</nav>
	</form>

	<style>
body {
	background-image: url('blurimg7.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</style>

	<h2 align="center">Your Projects</h2>
	<br>

	<table id="sports" align="center">
		<tr>
		<tr>
			<th>Project ID</th>
			<th>Project Title</th>
			<th>Type</th>
			<th>Team Members</th>
			<th>Project Abstract</th>
			<th>Status</th>
			<th>Feedback From Admin</th>
			<th>Report</th>
			<th>View Report</th>
		</tr>
		<c:forEach items="${myprojects}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.ptitle}</td>
				<td>${p.type}</td>
				<td>${p.team}</td>
				<td>${p.pabstract}</td>
				<td class="status">${p.status}</td>
				<td>${p.feedback}</td>
				<td><a href="reportreview?title=${p.ptitle}"><button>Add
							Report</button></a></td>
				<td><a href="getreport?title=${p.ptitle}"><button>View
							Report</button></a></td>

			</tr>
		</c:forEach>
	</table>



</body>

</html>