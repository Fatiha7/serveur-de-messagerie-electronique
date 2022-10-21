<%@page import="com.fabMail.entities.Email"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
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
<!--===============================================================================================-->
</head>
<body>
<%@ page import="java.util.List" %>
<%
    List<Email> emails = (List<Email>) request.getAttribute("emails");
%>

<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				
				<nav>
				  
					<ul>
					  
					  <li>
						<svg>
						</svg>
						<a href="EmailSendingForm" class="p" ><br>New Mail</a>
					  </li>
					  <li>
						<svg>
						</svg>        
						<a href="HomeServlet" class="p" ><br>Inbox</a>
					  </li>
					  <li>
						<svg>
						</svg>
						<a href="Sent" class="p" ><br>Sent Mail</a>
					  </li>
					  <li>
						<svg>
						</svg>
						<a href="UpdateForm" class="p" ><br>Update</a>
					  </li>
					  <li>
						<svg>
						</svg>
						<a href="logout" class="p" ><br>Log Out</a>
					  </li>
					</ul>
				  </nav>
				  
				 
				
					<table class="table ">
						<tr style="background-color: black; color:palevioletred">
						<th>Mail From</th>
						<th>Subject</th>
						<th>Date</th>
						<th></th>
						</tr>
						 <%
                         for (Email e:emails){ %>
                         <tr>
                         <td class="name"><%=e.getFrom()%></td>
                         <td class="subject"><%=e.getSubject() %></td>
                         <td class="time"><%=e.getCreatedAt() %></td>
                         <td><a href="supprimermessageForm?id=<%=e.getUuid() %>" class="btn btn-dark">delete</a> <a href="ShowmessageForm?id=<%=e.getUuid() %>" class="btn btn-dark">Show</a></td>
                         </tr>
                         <%} %>
					</table>	
				  
			</div>
		</div>
	</div>
	
	


</body>
</html>