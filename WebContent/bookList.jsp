<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<h1>Book List</h1>
<hr>
<form action="${pageContext.request.contextPath}/bookSearch.do" method="post">

<table>
	<tr>
		<td>
			<select name="condition">
				<option value="title">도서제목</option>
				<option value="publisher">출판사명</option>
			</select>
			<input type="text" name="keyword">
			<input type="submit" value="검색">
		</td>
	</tr>	
</table>
</form>
<form action="delete.do" method="get" id="fm">
	<table class="tableb">
		<tr>
		<th>BookNo</th>
		<th>Title</th>
		<th>Publisher</th>
		<th>Price</th>
		<th>date</th>
		<th><input type="button" id="delete" value="삭제" onclick="delt()"/></th>
		</tr>
	<c:forEach var="data" items="${bookList}">
		<tr>
			<td>${ data.bookno }</td>
			<td><a href="viewBook.do?bookno=${ data.bookno }">${ data.title }</a></td>
			<td>${ data.publisher }</td>
			<td>${ data.price }</td>
			<td>${ data.day }</td>
			<td><input type="checkbox" id="ck" name="bookno" value="${data.bookno}"></td>
		</tr> 
	</c:forEach>
	</table>
	
</form>

<%@ include file="common/footer.jsp" %>

<script>
	var ck = document.getElementById('ck');
	console.log(ck.value);
	
	function delt() {
		
		var fm = document.getElementById('fm');
		
		if(confirm('삭제하시겠습니까?')) {
			alert('삭제했습니다');
			fm.submit();
		} else {
			alert('삭제를 취소했습니다.')
		}
	}
	
</script>
</body>
</html>