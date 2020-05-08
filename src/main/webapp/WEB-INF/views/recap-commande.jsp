<%@page pageEncoding="UTF-8" contentType="text/html"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html id="recap-commande">
<head>
<meta charset="UTF-8">
<title>Pizza Spring</title>
<link rel="stylesheet" href="<c:url value="/style.css"/>">
</head>
<body>
	<nav id="menu">
		<ul>
			<li><a href="<c:url value="/commande"/>">Commander</a></li>
			<li><a href="<c:url value="/preparation"/>">Préparer</a></li>
			<li><a href="<c:url value="/fidelisation"/>">Fidélisation</a></li>
			<li><a href="<c:url value="/rapport"/>">Rapport journalier</a></li>
		</ul>
	</nav>
  
  	<div>
  		Récapitulatif de la commande :
  		
  		<ul>
  			<li>Nom : <span id="userName"><c:out value="${commande.nom}"/></span></li>
  			<li>Téléphone : <span id="phone"><c:out value="${commande.telephone}"/></span></li>
  			<li>Date : <fmt:formatDate type="both" dateStyle="long" value="${commande.dateEmission}"/></li>
  		</ul>

		Pizzas commandées :
		
		<ul>
			<c:forEach items="${commande.details}" var="d">
	  			<li id="${d.pizza.id}"><c:out value="${d.pizza.nom}"/></li>
			</c:forEach>
		</ul>
  	</div>
</body>
</html>