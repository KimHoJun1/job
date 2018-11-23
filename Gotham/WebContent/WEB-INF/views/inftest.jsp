<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="rtest.Infection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%-- <%
if(request.getAttribute("infec") != null) {		
	String src = (String)request.getAttribute("infec");
%>
	<img src="
	   data:image/jpg;base64, <%= Base64.getEncoder().encodeToString(src) %>"
	   width="400" height="300">
<%
} 
%> --%>
<h1>나옴</h1>
${ infec }
</body>
</html>