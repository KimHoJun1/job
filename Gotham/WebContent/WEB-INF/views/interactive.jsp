<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="rtest.RChart"%>
<html>
<head>
   	<title>Rserve</title>
   	<link rel='stylesheet' href='/Gotham/resources/css/nv.d3.css'>
   	<link rel='stylesheet' href='/Gotham/resources/css/rNVD3.css'>
    
	<script src='/Gotham/resources/js/jquery-1.8.2.min.js' type='text/javascript'></script>
	<script src='/Gotham/resources/js/d3.v3.min.js' type='text/javascript'></script>
    <script src='/Gotham/resources/js/nv.d3.min-new.js' type='text/javascript'></script>
    <script src='/Gotham/resources/js/fisheye.js' type='text/javascript'></script>    
    <style>
    .rChart {
      display: block;
      margin-left: auto; 
      margin-right: auto; 
      width: 800px;
      height: 400px;
    }  
    </style>
    <script src="/Gotham/resources/wordcloud2/htmlwidgets-0.8/htmlwidgets.js?ver=2"></script>
	<link href="/Gotham/resources/wordcloud2/wordcloud2-0.0.1/wordcloud.css" rel="stylesheet" />
	<script src="/Gotham/resources/wordcloud2/wordcloud2-0.0.1/wordcloud2-all.js"></script>
	<script src="/Gotham/resources/wordcloud2/wordcloud2-0.0.1/hover.js"></script>
	<script src="/Gotham/resources/wordcloud2/wordcloud2-binding-0.2.0/wordcloud2.js?ver=2"></script>
	
	<link rel='stylesheet' href='/Gotham/resources/leaflet/external/leaflet.css'>
    <link rel='stylesheet' href='/Gotham/resources/leaflet/external/leaflet-rCharts.css'>
    <link rel='stylesheet' href='/Gotham/resources/leaflet/external/legend.css'>
    
    <script src='/Gotham/resources/leaflet/external/leaflet.js' type='text/javascript'></script>
    <script src='/Gotham/resources/leaflet/external/leaflet-providers.js' type='text/javascript'></script>
    <script src='/Gotham/resources/leaflet/external/Control.FullScreen.js' type='text/javascript'></script>    
    
</head>
<body>
<h1>rChart 시각화 결과 표현하기</h1> 
<hr>
${ rchart_content }		
</body>
</html> 
