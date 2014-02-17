package es.fraggel.bo;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;


import es.fraggel.beans.NavegacionBean;
import es.fraggel.exception.HCException;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class ControlesBo {
	
	public void comprobarStatusTodo(NavegacionBean navegacion){
		String status="";
		try {
	        InputStream in = navegacion.getSerialInputStream();
	        OutputStream out = navegacion.getSerialOutputStream();
	        if(out!=null){
	        	out.write("2".getBytes());
            	out.flush();
            	out.close();
	        }
	        int available=in.available();
	        while(available<=0){
	        	available=in.available();
	        }
	        
	        int a=in.read();
	        while(a!=-1){
	        	status=status+(char)a;
	        	a=in.read();
	        }
	        in.close();
	        status=status.replaceAll("\r\n", "");
	        if("0".equals(status)){
	        	navegacion.setCalefaccionStatus("OFF");
	        }else if("1".equals(status)){
	        	navegacion.setCalefaccionStatus("ON");
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cambiaStatusCalefaccion(NavegacionBean navegacion){
		try{
			InputStream in = navegacion.getSerialInputStream();
	        OutputStream out = navegacion.getSerialOutputStream();
			if(navegacion.getCalefaccion()){
				
				if("OFF".equals(navegacion.getCalefaccionStatus())){
					    if(out!=null){
	                    	out.write("1\r\n".getBytes());
	                    	out.flush();
	                    	out.close();
	                    	navegacion.setCalefaccionStatus("ON");
	                    }
						comprobarStatusTodo(navegacion);
					
				}else{
				        if(out!=null){
							out.write("0\r\n".getBytes());
							out.flush();
	                    	out.close();
							navegacion.setCalefaccionStatus("OFF");
						}
						comprobarStatusTodo(navegacion);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void cambiaStatusAire(NavegacionBean navegacion) {
		if(navegacion.getAireSalon()){
			if("OFF".equals(navegacion.getAireSalonStatus())){
				navegacion.setAireSalonStatus("ON");
			}else{
				navegacion.setAireSalonStatus("OFF");
			}
		}
		if(navegacion.getAireHabitacion()){
			if("OFF".equals(navegacion.getAireHabitacionStatus())){
				navegacion.setAireHabitacionStatus("ON");
			}else{
				navegacion.setAireHabitacionStatus("OFF");
			}
		}
		
	}


}
