<%@page import="com.fabMail.entities.Mailbox"%>
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
    List< Mailbox> mailbox = (List<Mailbox>) request.getAttribute(" mailbox");
%>

<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
	
				 <nav>
				  
					<ul>
					  <li>
						<svg>
						</svg>
						<a href="logout" class="p" ><br>Log Out</a>
					  </li>
					</ul>
				  </nav>
				
					<table class="table ">
						<tr style="background-color: black; color:palevioletred">
						<th>id</th>
						<th>Username</th>
						<th>Name</th>
						<th>password</th>
						<th>domain</th>
						<th>created date</th>
						<th>update date</th>
						<th>active</th>
						<th></th>
						</tr>
						 <%
                         for (Mailbox e: mailbox){ %>
                         <tr>
                         <td class="name"><%=e.getId() %></td>
                         <td class="subject"><%=e.getUsername() %></td>
                         <td class="time"><%=e.getName() %></td>
                         <td class="name"><%=e.getPassword()  %></td>
                         <td class="subject"><%=e.getDomain() %></td>
                         <td class="time"><%=e.getCreated() %></td>
                         <td class="time"><%=e.getModified() %></td>
                         <td class="time"><%=e.getActive() %></td>
                         <%String off ="Off";
                    	 String on = "On";
                    	 String Statue;
                         if(e.getActive()==1){
                        	 Statue=off;
                         }else{
                        	 Statue=on;
                         }
                        %>
                         <td><a href="BlockedAcount?username=<%=e.getUsername() %>" class="btn btn-dark"></a><%=Statue %> </td>
                         </tr>
                         <% 
                         HttpSession Session = request.getSession(); 
                         Session.setAttribute( "usernam", e.getUsername());
                        
                         } %>
					</table>	
				  
			</div>
		</div>
	</div>
	
	


</body>
</html>