<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<div id="a">

</div>
<script type="text/javascript">
	var a = document.getElementById('a');
	var b = "asd";
	a.innerHTML = `b의 값은 ${b}`;
</script>
</body>
</html>