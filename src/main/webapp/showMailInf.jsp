<%@page import="com.fabMail.entities.Email"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mail Inf</title>
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
<% Email email= (Email)request.getAttribute("email"); %>
<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
			
			<header class="row">
        <div class="col g">
          <h1 class=" text-center  m-4">FAB<small class="text-muted">Mail</small></h1>
                    <p class=" text-left">me : <em><%=email.getTo() %></em>
          </p>
           <p class=" text-left">to : <em><%=email.getFrom() %></em>
          </p>
           <p class=" text-right"><%=email.getCreatedAt() %></p>
           <p >Subject : <em><%=email.getSubject() %></em>
          </p>
           <blockquote class=" text-center blockquote">
		    <%=email.getMessage() %>
               </blockquote>
               <div ><a class="txt2 p" href="EmailSendingForm" >Reply<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i></a></div><br>
               <div ><a href="##" class="txt2 p" onclick="window.history.go(-1); return false;">back<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i></a></div>
               
             
			</div>
	</header>	</div></div>
</div>
</body>
</html>