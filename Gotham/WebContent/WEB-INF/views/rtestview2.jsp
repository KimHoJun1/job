<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" value="테이블 삭제" class="btn btn-success "
		id="dropbtn" />
	<input type="button" value="테이블 보기" class="btn btn-success "
		id="viewbtn" /> 
		<br/>
		${result}
</body>
<script>
	var frm = document.getElementById("frm");
	document.getElementById("dropbtn").onclick = function() {
		location.href = "rdrop";
	}
	document.getElementById("viewbtn").onclick = function() {
		location.href = "rlist";
	}
</script>
</html>