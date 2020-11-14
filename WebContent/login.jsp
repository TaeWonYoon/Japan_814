<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login App</title>
</head>
<body>
<%@ include file="common/header.jsp" %>

<h2> Login form </h2>
<form action="Login.do" method="post">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="id" required="required" /></td>
		</tr>
		<tr>
			<td>password</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인" >
				<input type="reset" value="취소" >
			</td>
		</tr>
	</table>
</form>
	
<%@ include file="common/footer.jsp" %>
</body>
</html>