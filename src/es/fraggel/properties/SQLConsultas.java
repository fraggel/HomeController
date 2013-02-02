package es.fraggel.properties;

public class SQLConsultas {
	//Login
	public static String loginDecrypt="SELECT pk_mod_seguridad.ft_desencriptar(?) as usuario FROM dual";
	
	public static String loginSelectOperador="SELECT * FROM hc.tb_usuarios WHERE usuario=?";
	
}
