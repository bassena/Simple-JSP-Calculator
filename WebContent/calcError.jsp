<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculation Error</title>
<link rel="stylesheet" type="text/css" href="calculator.css"/>
</head>
<body>
	<h1>Oops! A calculation error occurred. Here's what happened.</h1>
	<div id="errBox">
		<p><%=request.getParameter("error")%> <a href="calculator.jsp">Return to the calculator</a></p>
	</div>
</body>
</html>