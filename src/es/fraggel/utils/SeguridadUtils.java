package es.fraggel.utils;

public class SeguridadUtils {

	public SeguridadUtils(){
		
	}
	public boolean comprobarString(String campo){
		boolean valido=false;
		valido=true;
		return valido;
	}
	public boolean comprobarUsuario(String usuario, String contrasenya){
		boolean valido=false;
		if ("fraggel".equals(usuario) && "ak47cold".equals(contrasenya)){
			valido=true;
		}else{
			valido=false;
		}
		return valido;
	}
}
