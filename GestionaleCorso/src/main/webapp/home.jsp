<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Benvenuto Utente</h1>

<div>
<a href="list">Lista Utenti</a>
<a href="newInsertGet">Inserisci Utente</a>
</div>

<div>
<h2>Ultimo utente inserito-----></h2>
<h2>${lastUser}</h2>
</div>
</body>
</html>