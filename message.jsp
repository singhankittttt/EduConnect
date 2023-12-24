<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Message</title>
</head>
<body>
<br>
<br>
<br>
<br>

<h1 align="center" class="text-primary">

		<%
			out.println("" + session.getAttribute("msg"));
		%>

	</h1>
</body>
</html>