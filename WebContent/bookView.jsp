<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h2> Book 상세보기</h2>
<form action="" name="f" method="post">
<input type="hidden" name="bookno" value="${book.bookno}" /> 
	<table>
		<tr>
			 <td>도서제목</td>
			 <td>${book.title}</td>
		</tr> 
		<tr>
			 <td>출판사</td>
			 <td> ${book.publisher}</td>
		</tr> 
		<tr>
			 <td>도서가격</td>
			 <td> ${book.price}</td>
		</tr>
		<tr>
		<td colspan="2"><img id="img" alt="...." src="./upload/love.png"> </td>
		</tr>
	</table>
</form>

	<table>
		<tr>
			<td>
				<input type="button" value="수정" onclick="modify()">
				<input type="button" value="삭제" onclick="bookDelete()">
				<input type="button" value="목록" onclick="list()">
			</td>
		</tr>
	</table>	
</section>

<%@ include file="common/footer.jsp" %>

<script>
	var img = document.getElementById('img');
	console.log(img);

	function modify(){
		if(confirm("수정하시겠습니까?")) {
			//f.action="";
			//f.submit();
		}
	}
	function bookDelete(){
		if(confirm("삭제하시겠습니까?")) {
			f.action="delete.do";
			f.submit();
		}
	}
	function list(){
		if(confirm("리스트로가시겠습니까?")) {
			f.action="bookList.do";
			f.submit();
		}
	}
</script>
</body>
</html>