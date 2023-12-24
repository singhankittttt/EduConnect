<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String emailId=request.getParameter("email");
	String password=request.getParameter("password");
	
	if(emailId.equals("admin@gmail.com") && password.equals("admin")){
		response.sendRedirect("admin-dashboard.html");
	}else{
		response.sendRedirect("admin-login.jsp");
	}
	
%>