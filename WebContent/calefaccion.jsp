<%@ page import="es.fraggel.beans.NavegacionBean" %>
<%@ page import="es.fraggel.properties.Constantes" %>
<%
	NavegacionBean navegacion=(NavegacionBean)session.getAttribute("navegacion");
%>
<jsp:include page="cabecera.jsp" />
<jsp:include page="menu.jsp" />
<div id="principal">
	<div id="contenidoPrincipal">
		<div id="pantalla">
			<form action="HomeControllerServlet">
				<input type="hidden" name="accion" value="2"/>
				La calefaccion está <%if(navegacion.getCalefaccionStatus()!=null && !"".equals(navegacion.getCalefaccionStatus()) && "ON".equals(navegacion.getCalefaccionStatus())){ %><div id="on">Encendida</div><%}else{%><div id="off">Apagada</div><%}%>
				<input type="submit" name="calefaccion" value="" id="<%if(navegacion.getCalefaccionStatus()!=null && !"".equals(navegacion.getCalefaccionStatus()) && "ON".equals(navegacion.getCalefaccionStatus())){ %>btnEncender<%}else{%>btnApagar<%}%>"><br/>
			</form>
		</div>
	</div>
</div>
<jsp:include page="pie.jsp" />