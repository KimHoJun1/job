<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.weather-panel{
	width: 300px;
	height: 300px;
	color: white;
    text-align: center;
    background-color: #159957;
    background-image: linear-gradient(120deg, #155799, #159957);
}
</style>
</head>
<body>
<br>
<div class="weather-panel">
	<p class="weather-panel-title">현재 위치 날씨</p>
    <hr>
    <div>상태 이미지 들어갈 자리</div>
    <div>현재 상태 : ${ comm }</div>
    <div>현재 온도 : ${ temp }°C</div>
</div>

</body>
</html>