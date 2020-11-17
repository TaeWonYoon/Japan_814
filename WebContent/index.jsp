<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book App</title>
<link rel="stylesheet" href="./css/my.css" >
<link rel="stylesheet" href="./css/main.css" >

</head>

<body>
<%@ include file="common/header.jsp" %>

<section>
<h3> link list </h3>
<ul>
	<c:if test="${empty login}">
			   <li> <a href="${pageContext.request.contextPath}/login.jsp"> LogIn </a></li><br>
   	</c:if>
	<c:if test="${!empty login }">
	    <li> <a href="${pageContext.request.contextPath}/login.do"> LogOut </a></li>
	    <li><a href="${pageContext.request.contextPath}/bookList.do"> Book List </a></li>
		<li><a href="${pageContext.request.contextPath}/book.jsp"> Book 등록 </a></li>
		<li><a href="${pageContext.request.contextPath}/upload1.jsp"> upload1 </a></li>
		<li><a href="${pageContext.request.contextPath}/upload2.jsp"> upload2 </a></li>
	</c:if>
	
</ul>
</section>


<%@ include file="common/footer.jsp" %>

<script type="text/javascript">

</script>
</body>
</html>