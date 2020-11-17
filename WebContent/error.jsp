<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/my.css">
<link rel="stylesheet"  href="./css/main.css" >
</head>
<body>
<%@ include file="common/header.jsp" %>

<section>
	<h1> Error Page </h1>
	<h2> 서버점검중입니다.... </h2>
	<div style="color:red;">${exception}</div>
</section>

<%@ include file="common/footer.jsp" %>

</body>
</html>