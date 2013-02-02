function doMenuShow(item) {
	ocultaMenu();
	obj = document.getElementById(item);
	obj.style.display = "block";
}

function ocultaMenu(){
	try {
		document.getElementById("controlesH").style.display= "none";
	} catch (e) {
	}	
}