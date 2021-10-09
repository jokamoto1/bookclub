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
		<h1>Edit Book</h1>
		<a href="/home">Home</a>
		<form:form action="/edits/book/${oneBook.id}" method="post" modelAttribute="book">

			<div class="form-group">
				<label>Title:</label>
				<form:input path="title" class="form-control" value="${oneBook.title }" />
				<form:errors path="title" class="text-danger" />
			</div>
			<div class="form-group">
				<label>Author:</label>
				<form:input path="authorName" class="form-control" value="${oneBook.authorName }"/>
				<form:errors path="authorName" class="text-danger" />
			</div>
			<div class="form-group">
				<label>Description:</label>
				<form:input type="textarea" path="description" class="form-control" value="${oneBook.description }" />
				<form:errors path="description" class="text-danger" />
			</div>
			<input type="submit" value="Edit Book" class="btn btn-primary" />
		</form:form>
	</div>

</body>
</html>
