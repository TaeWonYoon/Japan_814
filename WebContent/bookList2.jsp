<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/my.css">
</head>
<body>
<h1> My WebApplication</h1>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="delete.do" method="get" id="fm">
	<table class="tableb">
		<tr>
		<th>BookNo</th>
		<th>Title</th>
		<th>Publicher</th>
		<th>Price</th>
		<th><input type="button" id="delete" value="삭제" onclick="delt()"/></th>
		</tr>
	<c:forEach var="data" items="${bookList}">
		<tr>
			<td>${ data.bookno }</td>
			<td>${ data.title }</td>
			<td>${ data.publisher }</td>
			<td>${ data.price }</td>
			<td><input type="checkbox" id="ck" name="bookno" value="${data.bookno}"></td>
		</tr> 
	</c:forEach>
	</table>
	
</form>
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