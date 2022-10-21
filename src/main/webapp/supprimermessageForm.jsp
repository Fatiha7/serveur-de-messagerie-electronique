<%@page import="com.fabMail.entities.Email"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="static/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="static/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="static/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="static/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="static/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="static/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="static/css/util.css">
	<link rel="stylesheet" type="text/css" href="static/css/main.css">
	<link rel="stylesheet" type="text/css" href="static/css/style.css">
	<style type="text/css">
	.g{
	margin-top:-100px;
	margin-left:200PX;
	}
	.t{
	margin-left:-100PX;
	}
	p{
	color:black;
	font-size:18px;
	}
	.p{
	
	font-size:15px;
	}
	em{
	color:#D75281;
	font-size:17px;
	}</style>
</head>
<body>
<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
			<div class="col g">
<h1 class=" ">delete mail</h1></div>
<p class=" t"> are you sure... ? 
<form action="supprimermessageExec" method="get">
<br><br>
<div class="container-login100-form-btn">

						<button type="submit" class="login100-form-btn">
							Delete
						</button>
					</div> 
</form>
<% HttpSession Session = request.getSession(); 
 Session.setAttribute( "uid", request.getParameter("id"));
 %>
 </div></div></div>
</body>
</html>