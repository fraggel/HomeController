package es.fraggel.properties;

import java.io.IOException;
import java.util.Properties;

import es.fraggel.exception.HCException;

public class Parametros {

	public String obtenerParametros(String paramRecibido) throws HCException {
		String paramEnviado = "";
        try
        {
            Properties fichParametros = new Properties();
            fichParametros.load(getClass().getResourceAsStream("Parametros.properties"));
            paramEnviado = fichParametros.getProperty(paramRecibido);
        }
        catch(IOException e)
        {
         throw new HCException("No se ha podido cargar el fichero de parametros",e);  
        }
        return paramEnviado;
	}

	
}
