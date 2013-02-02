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
				<input type="hidden" name="accion" value="3"/>
				El aire del salón está <%if(navegacion.getAireSalonStatus()!=null && !"".equals(navegacion.getAireSalonStatus()) && "ON".equals(navegacion.getAireSalonStatus())){ %><div id="on">Encendido</div><%}else{%><div id="off">Apagado</div><%}%>
				<input type="submit" name="aireSalon" value="" id="<%if(navegacion.getAireSalonStatus()!=null && !"".equals(navegacion.getAireSalonStatus()) && "ON".equals(navegacion.getAireSalonStatus())){ %>btnApagar<%}else{%>btnEncender<%}%>"><br/>
				El aire de la habitación está <%if(navegacion.getAireHabitacionStatus()!=null && !"".equals(navegacion.getAireHabitacionStatus()) && "ON".equals(navegacion.getAireHabitacionStatus())){ %><div id="on">Encendido</div><%}else{%><div id="off">Apagado</div><%}%>
				<input type="submit" name="aireHabitacion" value="" id="<%if(navegacion.getAireHabitacionStatus()!=null && !"".equals(navegacion.getAireHabitacionStatus()) && "ON".equals(navegacion.getAireHabitacionStatus())){ %>btnApagar<%}else{%>btnEncender<%}%>">
			</form>
		</div>
	</div>
</div>
<jsp:include page="pie.jsp" />