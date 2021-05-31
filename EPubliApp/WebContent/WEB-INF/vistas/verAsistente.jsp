<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main class="container mt-6">
	<div class="columns is-centered">
		<div class="column is-8">
			<label class="label" for="estado-select">Estado actual</label>
			<div class="control">
				<div class="select">
					<select name="estado-select" id="estado-select">
						<option>Pagada</option>
						<option>Con deuda</option>
					</select>
				</div>
			</div>
			<button type="submit" class="button is-primary">Filtrar</button>
			<table class="table is-hovered is-bordered is-fullwidth" id="tabla">
				<thead class="has-background-link">
					<tr>
						<th>Nombre Completo</th>
						<th>Empresa</th>
						<th>Región</th>
						<th>Estado</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="asistente" items="${asistentes}">
						<tr>
							<td>${asistente.nombre} ${asistente.apellido}</td>
							<td>${asistente.empresa}</td>
							<td>${asistente.region}</td>
							<td>${asistente.estado}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</main>
<body>

</body>
</html>