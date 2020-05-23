<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<title>Insert title here</title>
</head>
<body>
    Register success!
	Welcome ${requestScope['user'].username}
	<a href="./home.jsp">Go back home page</a>
</body>
</html>