<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="./css/main.css" >
<link rel="stylesheet"  href="./css/my.css" >
</head>
<body>
<%@ include file="common/header.jsp" %>
<h2>Book 등록</h2>

<form action="./addServlet" method="post">
	제목: <input type="text" id="" name="title"> <br>
	출판사: <input type="text" id="" name="publisher"> <br>
	가격: <input type="number" id="" name="price"> <br>
	<input type="submit" value="전송">
</form>

<%@ include file="common/footer.jsp" %>
</body>
</html>