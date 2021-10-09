<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
		<h1>
			<c:out value="${book.title}"></c:out>
		</h1>
		<a href="/home">Home</a>
		<c:if test="${book.user.id != user.id}">
			<h3>
				<c:out value="${book.user.userName}"></c:out>
				read
				<c:out value="${book.title}"></c:out>
				by
				<c:out value="${book.authorName}"></c:out>
				.
			</h3>
			<h4>
				Here are
				<c:out value="${book.user.userName}" />
				's thoughts:
			</h4>
		</c:if>
		<c:if test="${book.user.id == user.id}">
			<h3>
				You read
				<c:out value="${book.title}"></c:out>
				by
				<c:out value="${book.authorName}"></c:out>
				.
			</h3>
			<h4>Here are your thoughts:</h4>
		</c:if>
		<p class="border-top border-bottom">
			<c:out value="${book.description}"></c:out>
		</p>
		<c:if test="${book.user.id == user.id}">
			<a href="/edit/book/${book.id }">Edit</a>
		</c:if>
	</div>

</body>
</html>
