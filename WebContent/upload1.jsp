<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>File upload</h2>
	
	<form action="./upload1.do" method="post" enctype="multipart/form-data">
		<label>첨부파일: <input type="file" name="img" multiple="multiple"></label>
		<br>
		<input type="submit" value="전송" />
		<input type="reset" value="reset" />
	</form>
	<br><br>
	<form action="./upload2.do" method="post" enctype="multipart/form-data">
		<label>첨부파일: <input type="file" name="img" multiple="multiple"></label>
		<br>
		<input type="submit" value="전송" />
		<input type="reset" value="reset" />
	</form>
</body>
</html>