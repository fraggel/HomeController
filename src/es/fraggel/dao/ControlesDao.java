package es.fraggel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import es.fraggel.beans.NavegacionBean;
import es.fraggel.exception.HCException;
import es.fraggel.properties.Parametros;
import es.fraggel.properties.SQLConsultas;
import es.fraggel.utils.UtilidadesC;

public class ControlesDao {
	public ControlesDao(){
		
	}
	/*public void obtenerListaSucursales(NavegacionTarjetasBean navegacion,Parametros parametros,String cliente) throws HCException{
		Connection connection =null;
		ArrayList listaSucursales=new ArrayList();
		try {
			ConexionBBDD conexion=new ConexionBBDD();
			connection = conexion.obtenerConexion(parametros);
			StringBuffer sql=new StringBuffer(SQLConsultas.tarjetasListadoSucursales);
			if(!"".equals(cliente)){
				sql=sql.append(" AND cliente = '"+cliente+"'");
			}
			sql=sql.append(" ORDER BY sucursal))");
			PreparedStatement prepareStatement = connection.prepareStatement(sql.toString());
			ResultSet executeQuery = prepareStatement.executeQuery();
			while(executeQuery.next()){
				ArrayList elementoSucursales=new ArrayList();
				elementoSucursales.add(executeQuery.getString(1));
				elementoSucursales.add(executeQuery.getString(2));
				elementoSucursales.add(executeQuery.getString(3));
				listaSucursales.add(elementoSucursales);
			}
			navegacion.setListaSucursales(listaSucursales);
			navegacion.setTotalListaSucursales(listaSucursales.size()-1);
		} catch (Exception e) {
			throw new HCException("Error en consulta",e);
		}finally{
			
			try {
				connection.close();
			} catch (Exception e) {
				throw new HCException("Error al cerrar Base de datos",e);
			}
		}
	}*/
}
