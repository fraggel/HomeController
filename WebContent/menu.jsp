<div id="menu">
	<div id="menuPrincipal" onmouseover="doMenuShow('controlesH');">
		<a>Controles</a>
		<div id="controlesH" onmouseover="doMenuShow('controlesH');" onmouseout="ocultaMenu();"> 
			<div id="menuSubElemento"><a href="/HomeController/HomeControllerServlet?accion=2">Calefacción</a></div>
			<div id="menuSubElemento"><a href="/HomeController/HomeControllerServlet?accion=3">Aire Acondicionado</a></div>
		</div>
	</div>
	<div id="menuPrincipal"><a class="menuNoSubElemento" href="/HomeController/HomeControllerServlet?accion=">Opcion vacía</a></div>
</div>