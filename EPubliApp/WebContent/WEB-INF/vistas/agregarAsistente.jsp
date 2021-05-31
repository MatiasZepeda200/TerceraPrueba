<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main class="container mt-6">
	<c:if test="${mensaje != null}">
		<div class="columns is-centered mb-6">
			<div class="column is-6">
				<div class="notification is-info">
					<p>${mensaje}</p>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${errores !=null}">
		<div class="columns is-centered mb-6">
			<div class="column is-6">
				<div class="notification is-warning">
					<h6>Existen errores en el formulario</h6>
					<ul>
						<c:forEach var="error" items="${errores}">
							<li>${error}</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</c:if>
	<div class="columns is-centered">
		<div class="column is-6">
			<form method="POST" action="AgregarAsistenteController.do">
				<div class="card">
					<div class="card-header has-background-link">
						<span class="card-header-title">Ingresar Asistente</span>
					</div>
					<div class="card-content">
					  <label>Rut</label>
						<div class="field has-addons">
							<label class="label" for="rut-txt"></label>
							<p class="control">
								<input type="text" class="input" size="10" id="rut-txt" name="rut-txt" />
							</p>
							<p class="control">
								<a class="button is-static">-</a>
							</p>
							<label class="label" for="verificador-txt"></label>
							<p class="control">
								<input type="text" class="input" size="1" id="verificador-txt"
									name="verificador-txt" />
							</p>
						</div>
						<div class="field">
							<label class="label" for="nombre-txt">Nombre</label>
							<div class="control">
								<input type="text" class="input" id="nombre-txt"
									name="nombre-txt" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="apellido-txt">Apellido</label>
							<div class="control">
								<input type="text" class="input" id="apellido-txt"
									name="apellido-txt" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="edad-txt">Ingrese su edad</label>
							<div class="control">
								<input type="number" class="input" id="edad-txt" name="edad-txt" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="empresa-txt">Ingrese la empresa</label>
							<div class="control">
								<input type="text" class="input" id="empresa-txt"
									name="empresa-txt" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="estado-select">Estado actual</label>
							<div class="control">
								<div class="select">
									<select name="estado-select" id="estado-select">
										<option>Pagada</option>
										<option>Con deuda</option>
									</select>
								</div>
							</div>
						</div>
						<div class="field">
							<label class="label" for="region-select">Escoga la region actual</label>
							<div class="control">
								<div class="select">
									<select name="region-select" id="region-select">
										<option>Valparaiso</option>
										<option>Santiago</option>
										<option>Norte de Chile</option>
										<option>Sur de Chile</option>
										<option>Internacional</option>
									</select>
								</div>
							</div>
						</div>
					</div>
					<div class="card-footer has-text-centered">
						<div class="card-footer-item">
							<button type="submit" class="button is-primary">Registrar</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</main>

</body>
</html>