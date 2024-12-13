<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome </title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%
	HttpSession session1 = request.getSession(false);
	
if (session1 != null&& session1.getAttribute("username") != null) 
{
    // Get the username from the session
    String username = (String) session1.getAttribute("username");

%>
<div class="container">
<h1>Welcome,<%= username %>! !</h1>
<h3></h3>
<p></p>
<a href="LogoutServlet">Logout</a>
</div>

<%
}
else 
{
            // Redirect to the login page if the session is not valid
            response.sendRedirect("login.jsp");
       }
        %>
</body>
</html>