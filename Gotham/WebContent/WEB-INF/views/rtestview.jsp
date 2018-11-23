<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
</head>
<body>
<input type="button" value="테이블 생성" class="btn btn-warning "id="createbtn" />
<input type="button" value="테이블 삭제" class="btn btn-success "id="dropbtn" />
</body>
<script>
var frm = document.getElementById("frm");
	document.getElementById("createbtn").onclick = function() {
		location.href = "rcreate";
	}	
	document.getElementById("dropbtn").onclick = function() {
		location.href = "rdrop";
	}
</script>
</html>