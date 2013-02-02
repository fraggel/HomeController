package es.fraggel.bo;

/*import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortException;*/

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;


import es.fraggel.beans.NavegacionBean;
import es.fraggel.exception.HCException;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class ControlesBo {
	private static final String PORT_NAMES[] = { 
		"/dev/ttyACM0", // Linux
		"COM36", // Windows
	};
	public void comprobarStatusTodo(NavegacionBean navegacion) throws HCException{
		SerialPort serialPort=null;
		CommPortIdentifier portIdentifier =null;
		String status="";
		/*SerialPort serialPort=null;
		*/
		try {
			/*serialPort=new SerialPort("COM35");
			if(serialPort!=null && !serialPort.isOpened()){
				serialPort.openPort();
				serialPort.setParams(9600, 8, 1, 0);
			}*/
			
			Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
			while (portEnum.hasMoreElements()) {
				CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
				for (String portName : PORT_NAMES) {
					if (currPortId.getName().equals(portName)) {
						portIdentifier = currPortId;
						break;
					}
				}
			}
			serialPort = (SerialPort) portIdentifier.open("HomeController",
					1000);

			serialPort.setSerialPortParams(9600,
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);
	        InputStream in = serialPort.getInputStream();
	        OutputStream out = serialPort.getOutputStream();
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
			/*serialPort.writeString("2\r\n");
			int inputBufferBytesCount = serialPort.getInputBufferBytesCount();
			while(inputBufferBytesCount<=0){
				inputBufferBytesCount=serialPort.getInputBufferBytesCount();
		    }
			status=serialPort.readString(); */
	        status=status.replaceAll("\r\n", "");
	        if("0".equals(status)){
	        	navegacion.setCalefaccionStatus("OFF");
	        }else if("1".equals(status)){
	        	navegacion.setCalefaccionStatus("ON");
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			/*if (serialPort!=null && serialPort.isOpened()){
				serialPort.closePort();
			}*/
			if (serialPort!=null){
				serialPort.close();
			}
		}
	}

	public void cambiaStatusCalefaccion(NavegacionBean navegacion) throws  HCException {
		SerialPort serialPort=null;
		CommPortIdentifier portIdentifier =null;
		try {
			OutputStream out=null;
			Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
			while (portEnum.hasMoreElements()) {
				CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
				for (String portName : PORT_NAMES) {
					if (currPortId.getName().equals(portName)) {
						portIdentifier = currPortId;
						break;
					}
				}
			}
			serialPort = (SerialPort) portIdentifier.open("HomeController",
					1000);
			serialPort.setSerialPortParams(9600,
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);
	        out = serialPort.getOutputStream();
			/*serialPort=new SerialPort("COM35");
			if(serialPort!=null && !serialPort.isOpened()){
				serialPort.openPort();
				serialPort.setParams(9600, 8, 1, 0);
			}*/
			if(navegacion.getCalefaccion()){
				
				if("OFF".equals(navegacion.getCalefaccionStatus())){
					    
	                    /*SerialReader serialReader = new SerialReader(in);
	                    Thread thread = new Thread(serialReader);*/
	                    /*SerialWriter serialWriter = new SerialWriter(out,1);
	                    
	                    Thread thread2 = new Thread(serialWriter);
	                    thread2.start();
	                    serialWriter.setI(49);*/
	                    if(out!=null){
	                    	out.write("1\r\n".getBytes());
	                    	out.flush();
	                    	out.close();
	                    	navegacion.setCalefaccionStatus("ON");
	                    }
	                    serialPort.close();
						/*serialPort.writeString("1\r\n");
						if (serialPort!=null && serialPort.isOpened()){
							serialPort.closePort();
						}*/
						comprobarStatusTodo(navegacion);
					
				}else{
				        /*SerialReader serialReader = new SerialReader(in);
	                    Thread thread = new Thread(serialReader);*/
	                    /*SerialWriter serialWriter = new SerialWriter(out,1);
	                    Thread thread2 = new Thread(serialWriter);
	                    thread2.sleep(2000);
	                    thread2.start();
	                    serialWriter.setI(48);
	                    */
						if(out!=null){
							out.write("0\r\n".getBytes());
							out.flush();
	                    	out.close();
							navegacion.setCalefaccionStatus("OFF");
						}
						serialPort.close();
						/*serialPort.writeString("2\r\n");
						if (serialPort!=null && serialPort.isOpened()){
							serialPort.closePort();
						}*/
						comprobarStatusTodo(navegacion);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			/*if (serialPort!=null && serialPort.isOpened()){
				serialPort.closePort();
			}*/
			if (serialPort!=null){
				serialPort.close();
			}
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

	/*public void ConsultaPeticiones(NavegacionBean navegacion) throws HCException{
		try {
			Parametros parametros=new Parametros();
			TarjetasDao tarjetasDao=new TarjetasDao();
			
			int subAccion=navegacion.getSubAccion();
			UtilidadesT util=new UtilidadesT();
			tarjetasDao.obtenerListaClientes(navegacion,parametros);
			if((navegacion.isClienteCambiado() && (navegacion.getTarjetasConsultaPeticionesCliente()!=null && !"".equals(navegacion.getTarjetasConsultaPeticionesCliente()))) || navegacion.getBusquedaSucursal()!=-1 && (navegacion.getTarjetasConsultaPeticionesCliente()!=null && !"".equals(navegacion.getTarjetasConsultaPeticionesCliente()))){
				tarjetasDao.obtenerListaSucursales(navegacion,parametros,navegacion.getTarjetasConsultaPeticionesCliente());
			}else if(navegacion.isClienteCambiado() || ("".equals(navegacion.getTarjetasConsultaPeticionesCliente()) && (navegacion.getTarjetasConsultaPeticionesSucursal()!=null || !"".equals(navegacion.getTarjetasConsultaPeticionesSucursal())))){
				navegacion.setListaSucursales(null);
				navegacion.setTotalListaSucursales(0);
			}
			switch(subAccion){
				case 1:
					if(navegacion.getBusquedaSucursal()==-1){
						util.calculaPaginacion(navegacion,navegacion.getTotalConsultaPeticiones()); 
						tarjetasDao.obtenerListaConsultaPeticionesPeticiones(navegacion, parametros);
						util.recualculaPaginacion(navegacion,navegacion.getTotalConsultaPeticiones());
					}
					navegacion.setJsp("/tarjetas/consultaPeticiones.jsp");
					break;
				case 2:
					//Bot�n nuevo
					break;
				default:
					navegacion.setListaConsultaPeticiones(null);
					navegacion.setTotalConsultaPeticiones(0);
					break;
			}
		}catch(HCException e){
			throw e;
		} catch (Exception e) {
			throw new HCException("Error en TarjetasBo.ConsultaPeticiones",e);
		}
		
		
	}*/

}
