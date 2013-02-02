<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<%
	if (request.getSession().getAttribute("usuario") == null) {
		response.sendRedirect("errorSession.jsp");
	}
%>
<head>
<link rel="STYLESHEET" type="text/css" href="/HomeController/css/estilos.css"/>
<script type="text/JavaScript" src="/HomeController/js/script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="expires" content="0">
<title>Fraggel Home Controller</title>
</head>
<body bgcolor="#0c548b" onload="ocultaMenu();">
	<div id="contenedor">
		<div id="cabecera">
			<div id="cabeceraBotones">
				<a href="/HomeController/HomeControllerServlet?accion=2"><img border="0" name="controles" src="/HomeController/images/controles_b.gif"/></a>
				<a href="/HomeController/HomeControllerServlet?accion=3" ><img border="0" name="vacio" src="/HomeController/images/vacio_a.gif"/></a>
			</div>
		</div>