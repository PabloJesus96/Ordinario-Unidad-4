<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<title>Boot sample | Home</title>

<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/style.css">
</head>
<body>
	<div role="naviation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">HOME</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-teacher">New Teacher</a></li>
					<li><a href="all-teachers">All teachers</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<!-- cuerpo de la pagina  -->
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Teacher Manager</h1>
				</div>
			</div>
		</c:when>
			</c:choose>

	<!-------------------------- codigo para Teachers  ---------------------------->

	<c:choose>
		<c:when test="${mode=='MODE_TEACHERS'}">
			<!-- contiene la tabla de todos los registros -->
			<div class="container text-center" id="teacherDiv">
				<h3>My Teachers</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>ID</th>
								<th>NAME</th>
								<th>FIRST LASTNAME</th>
								<th>SECOND LASTNAME</th>
								<th>DNI</th>
								<th>ADDRESS</th>
								<th>TELEPHONE</th>
								<th>EMAIL</th>
							</tr>
						</thead>
						<tbody>
							<!-- crea el foreach para traer la lista de reistros -->
							<c:forEach var="teacher" items="${teachers}">
								<tr>
									<td>${teacher.id}</td>
									<td>${teacher.name}</td>
									<td>${teacher.lastNamePat}</td>
									<td>${teacher.lastNameMat}</td>
									<td>${teacher.dni}</td>
									<td>${teacher.address}</td>
									<td>${teacher.telephone}</td>
									<td>${teacher.email}</td>
									<td><a href="update-teacher?id=${teacher.id}"> <span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="delete-teacher?id=${teacher.id}"> <span
											class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW' || mode=='MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage Teacher</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-teacher">
					<input type="hidden" name="id" value="${teacher.id}" />
					
					<div class="form-group">
						<label class="control-label col-md-3">Name:</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="name"
								value="${teacher.name}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">First Lastname:</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="lastNamePat"
								value="${teacher.lastNamePat}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Second Lastname:</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="lastNameMat"
								value="${teacher.lastNameMat}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">DNI:</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="dni"
								value="${teacher.dni}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Address:</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="address"
								value="${teacher.address}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Telephone:</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="telephone"
								value="${teacher.telephone}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Email:</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="email"
								value="${teacher.email}" />
						</div>
					</div>

					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="save" />
					</div>

				</form>
			</div>
		</c:when>
	</c:choose>

	<!--------------------------  -------------------------->
	

	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
</body>
</html>
