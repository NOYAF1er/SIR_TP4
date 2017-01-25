<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des personnes</title>
</head>
<body>
	<% 
		int nbPerson = (Integer) request.getAttribute("nbpersons");
	%>

	<h1>Liste des peronnes enregistrées</h1>
	<h3>Nombre de personnes: <% out.println(nbPerson); %></h3>
	
	<ul>
		<%
		%>
	</ul>
	<a href="/persons">Lister les personnes</a>

</body>
</html>