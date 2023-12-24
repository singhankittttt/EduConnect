<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="table.css">
<link rel="stylesheet" type="text/css" href="clubtable.css" />

<style>
body {
	background-image: url('blurimg7.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</style>
<title>Update Project</title>
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
					<li class="active"><a href="AdminDashboard.html">Home</a></li>
				</ul>
			</div>
		</nav>
	</form>



	<table id="club" align="center">
		<tr>
			<th>ID</th>
			<td>${p.id}</td>
		</tr>
		<tr>
			<th>Project Title</th>
			<td>${p.ptitle}</td>
		</tr>
		<tr>
			<th>Type</th>
			<td>${p.type}</td>
		</tr>
		<tr>
			<th>Team Members</th>
			<td>${p.team}</td>
		</tr>
		<tr>
			<th>Project Abstract</th>
			<td>${p.pabstract}</td>
		</tr>
		<tr>
			<th>Status</th>
			<td class="status">${p.status}</td>
		</tr>
		<tr>
			<th>Feedback From Admin</th>
			<td>${p.feedback}</td>
		</tr>
	</table>

	<hr>

	<div class="container">
		<div class="row">
			<form action="update" method="post">
				<fieldset class="form-group">
					<div class="row">
						<legend class="col-form-label col-sm-2 pt-0 text">Set
							Project Status</legend>
						<div class="col-sm-10">
						
							<div class="form-check">
								<input class="form-check-input" type="radio" name="status"
									id="pending" required value="Pending"> <label
									class="form-check-label text-primary" for="pending">
									pending </label>
							</div>
							
							<div class="form-check">
								<input class="form-check-input" type="radio" name="status"
									id="gridRadios1" required value="Approved"> <label
									class="form-check-label text-success" for="gridRadios1">
									Approve </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio" name="status"
									id="gridRadios2" required value="Rejected"> <label
									style="color: red" class="form-check-label" for="gridRadios2">
									Reject </label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="exampleFormControlTextarea1" class="text">Feedback to
							Student</label>
						<textarea class="form-control" id="exampleFormControlTextarea1"
							rows="3" name="feedback" required></textarea>
					</div>
				</fieldset>
				<div class="form-group row">
					<div class="col-sm-5">
						<button type="submit" class="btn btn-primary">Update</button>
						&nbsp;&nbsp;
						<button type="reset" class="btn btn-warning">Clear</button>
						&nbsp;&nbsp; <a href="AdminDashboard.html"><button type="button" class="btn btn-danger">Cancel</button></a>
					</div>
				</div>

			</form>
		</div>
	</div>


</body>

<script>

$(document).ready(function () {
    var x = $("td.status")
    for (var i = 0; i < x.length; i++) {
        if ($(x[i]).html() == "PENDING") {
            $(x[i]).html('<h5 class="text-primary">PENDING</h5>')
        } 
        else if ($(x[i]).html() == "REJECTED") {
            $(x[i]).html('<h5 class="text-danger">REJECTED</h5>')
        }
        else {
        	 $(x[i]).html('<h5 class="text-success">APPROVED</h5>')
        }
    }
});

</script>

</html>