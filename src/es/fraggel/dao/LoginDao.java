package es.fraggel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.fraggel.beans.UsuarioBean;
import es.fraggel.exception.HCException;
import es.fraggel.properties.Parametros;
import es.fraggel.properties.SQLConsultas;

public class LoginDao {
	
	public LoginDao(){
		
	}
	public UsuarioBean login(String usuario,Parametros parametros) throws HCException{
		Connection connection =null;
		try {
			ConexionBBDD conexion=new ConexionBBDD();
			connection = conexion.obtenerConexion(parametros);
			PreparedStatement prepareStatement = connection.prepareStatement(SQLConsultas.loginSelectOperador);
			prepareStatement.setString(1, usuario);
			ResultSet executeQuery = prepareStatement.executeQuery();
			executeQuery.next();
			UsuarioBean usuarioBean=new UsuarioBean(executeQuery.getString(1),executeQuery.getString(2),executeQuery.getString(3));
			return usuarioBean;
		} catch (SQLException e) {
			throw new HCException("Error de inicio de sesión",e);
		}finally{
			try {
				connection.close();
			} catch (Exception e) {
				throw new HCException("Error al cerrar Base de datos",e);
			}
		}
	}
}
