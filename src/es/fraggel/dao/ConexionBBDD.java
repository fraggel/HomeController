package es.fraggel.dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import es.fraggel.exception.HCException;
import es.fraggel.properties.Parametros;

public class ConexionBBDD {

	public ConexionBBDD() {
	}

	public Connection obtenerConexion(Parametros parametros) throws HCException{
    	try{
    		Context contextoInicial = new InitialContext(); // Equivalente: new InitialContext(null).
       	 	Context contexto = (Context) contextoInicial.lookup("java:");
       	 	DataSource fuenteDatos = (DataSource) contexto.lookup(parametros.obtenerParametros("jndi"));
       	 	return fuenteDatos.getConnection();
    	}catch(Exception e){
    		throw new HCException("No se ha podido conectar a BBDD",e);
    	}
	}
}
