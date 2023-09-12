<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Confirmation</title>
</head>
<body>
    <h2>Registration Confirmation</h2>
    <p>Thank you for registering!</p>
    <p>Your registration details:</p>
    <ul>
        <li><strong>Name:</strong> <%= request.getParameter("name") %></li>
        <li><strong>Email:</strong> <%= request.getParameter("email") %></li>
    </ul>
    <p>You can now <a href="login.jsp">log in</a> to your account.</p>
</body>
</html>
