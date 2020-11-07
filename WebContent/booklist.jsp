<%@page import="vo.BookVO"%>
<%@page import="java.util.List"%>
<%@page import="dao.BookDAO_Mariadb"%>
<%@page import="service.BookServiceImpl"%>
<%@page import="service.BookService"%>
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

<table class="tableb">
	<tr>
	<th>BookNo</th> <th>Title</th> <th>Publicher</th><th>Price</th>
	</tr>
<%
	BookDAO_Mariadb dao = new BookDAO_Mariadb();
	BookService service = new BookServiceImpl(dao);
	List<BookVO> list = service.bookList();
	for(BookVO data : list) {
%>
	<tr>
		<td><%=data.getBookno() %></td>
		<td><%=data.getTitle() %></td>
		<td><%=data.getPublisher() %></td>
		<td><%=data.getPrice() %></td>
	</tr>
<% } %>
</table>
</body>
</html>