<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formateo fechas (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Formulario form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- para errores de renderizado en rutas PUT -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
<div class="p-3 mb-2 bg-light text-black">
		<h1 class="container mx-auto m-3 p-3 text-center">TODAS LA LENGUAS</h1>
		<table class="table table-striped table-primary">
			<thead>
				<tr>
					<th scope="col">NOMBRE</th>
					<th scope="col">CREADOR</th>
					<th scope="col">VERSION</th>
					<th scope="col">-------</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${languages}" var="language">
					<tr>
						<td><a href="/languages/${language.id}">${language.name}</a></td>
						<td><c:out value="${language.creator}" /></td>
						<td><c:out value="${language.version}" /></td>
						<td class="align-middle">
							<a href="/languages/${language.id}/edit" class="d-inline">Editar</a>
							<form action="/languages/${language.id}" method="post" class="d-inline">
								<input type="hidden" name="_method" value="delete"/>
								<input type="submit" class="btn btn-link mb-1" value="Borrar libro"/>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container p-3 mb-2 bg-light text-center">
	<h1 class="m-3 p-3">NUEVA LENGUA</h1>
	<form:form action="/languages" method="post" modelAttribute="language" class="mx-auto">
		<div class="form-group">
			<label for="name">NOMBRE</label>
            <input type="text" class="form-control" id="name" name="name" />
            <form:errors class="text-danger" path="name" />
		</div>
		<div class="form-group">
			<label for="creator">CREADOR</label>
            <textarea class="form-control" id="creator" name="creator"></textarea>
            <form:errors class="text-danger" path="creator" />
		</div>
		<div class="form-group">
			 <label for="version">VERSION</label>
             <input type="text" class="form-control" id="version" name="version" />
             <form:errors class="text-danger" path="version" />
		</div>
		<input type="submit" value="Submit" class="btn btn-primary m-3"/>
	</form:form>
</div>
</body>
</html>