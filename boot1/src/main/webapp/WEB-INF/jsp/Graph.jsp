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
					<li><a href="new-graph">New Graph Path</a></li>
					<li><a href="all-graphs">All Graphs</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<!-- cuerpo de la pagina  -->
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Graph Path Manager</h1>
				</div>
			</div>
		</c:when>
	</c:choose>
	
	<!-------------------------- codigo para el graph  ---------------------------->

	<c:choose>
		<c:when test="${mode=='MODE_GRAPHS'}">
			<!-- contiene la tabla de todos los registros -->
			<div class="container text-center" id="graphDiv">
				<h3>My Graphs</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>ID</th>
								<th>TERM 1 ID</th>
								<th>TERM 2 ID</th>
								<th>RELATIONSHIP TYPE ID</th>
								<th>DISTANCE</th>
								<th>RELATION DISTANCE</th>
							</tr>
						</thead>
						<tbody>
							<!-- crea el foreach para traer la lista de reistros -->
							<c:forEach var="graph" items="${graph_path}">
								<tr>
									<td>${graph.id}</td>
									<td>${graph.term1Id}</td>
									<td>${graph.term2Id}</td>
									<td>${graph.relationshipTypeId}</td>
									<td>${graph.distance}</td>
									<td>${graph.relationDistance}</td>
									<td><a href="update-graph?id=${graph.id}"> <span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="delete-graph?id=${graph.id}"> <span
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
				<h3>Manage Graph</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-graph">
					<input type="hidden" name="id" value="${graph.id}" />
					
					<div class="form-group">
						<label class="control-label col-md-3">Term 1 ID:</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="term1Id"
								value="${graph.term1Id}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">Term 2 ID:</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="term2Id"
								value="${graph.term2Id}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Relationship Type ID:</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="relationshipTypeId"
								value="${graph.relationshipTypeId}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Distance:</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="distance"
								value="${graph.distance}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Relation Distance:</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="relationDistance"
								value="${graph.relationDistance}" />
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
