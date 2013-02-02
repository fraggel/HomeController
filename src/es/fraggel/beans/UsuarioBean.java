package es.fraggel.beans;

import java.io.Serializable;

public class UsuarioBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombre;
	String apellidos;
	String perfil;
	
	public UsuarioBean() {
	}

	public UsuarioBean(String nombre, String apellidos,
			String perfil) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.perfil = perfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
}
