<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Book Club</title>
</head>
<body>
<div class="container">
<h1>Welcome <c:out value="${user.userName}"></c:out></h1>
<h3>All books from users</h3>
<div class="d-flex flex-column">
<a href="/add/book">Add Book</a>
<a href="logout">Logout</a>
</div>
<table class="table table-bordered">
	<tr>
	<th>ID</th>
	<th>Title</th>
	<th>Author Name</th>
	<th>Posted By</th>
	</tr>
		<c:forEach var="book" items="${books}">
			<tr>
				<td><c:out value="${book.id}"></c:out></td>
				<td><a href="view/book/${book.id}"><c:out value="${book.title}"></c:out></a></td>
				<td><c:out value="${book.authorName}"></c:out></td>
				<td><c:out value="${book.user.userName}"></c:out></td>

			</tr>
		</c:forEach>
</table>
</div>
    
</body>
</html>
