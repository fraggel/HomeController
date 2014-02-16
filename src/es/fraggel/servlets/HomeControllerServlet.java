package es.fraggel.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.fraggel.beans.NavegacionBean;
import es.fraggel.bo.ControlesBo;
import es.fraggel.exception.HCException;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

/**
 * Servlet implementation class HomeControllerServlet
 */

public class HomeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SerialPort serial=null;
	OutputStream out=null;
	InputStream in=null;
	private static final String PORT_NAMES[] = { 
		"COM3", // Windows
	};
  @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	CommPortIdentifier portIdentifier =null;
		try {
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
				serial = (SerialPort) portIdentifier.open("HomeController",
						1000);
				serial.setSerialPortParams(9600,
						SerialPort.DATABITS_8,
						SerialPort.STOPBITS_1,
						SerialPort.PARITY_NONE);
		        out = serial.getOutputStream();
		        in=serial.getInputStream();
	        }catch(Exception e){
	        	
	        }
    }   
  @Override
public void destroy() {
	// TODO Auto-generated method stub
	super.destroy();
	if (serial!=null){
		serial.close();
	}
}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		NavegacionBean navegacion=null;
		try {
			//if(session.getAttribute("usuario")!=null){

				/*request.setAttribute("calefaccion",calefaccion);
				
				request.setAttribute("aireSalon",aireSalon);
				
				request.setAttribute("aireHabitacion",aireHabitacion);*/
				if(session.getAttribute("navegacion")==null){
					navegacion=new NavegacionBean();
				}else{
					navegacion=(NavegacionBean)session.getAttribute("navegacion");
				}
				navegacion.setSerialPort(serial);
				navegacion.setSerialInputStream(in);
				navegacion.setSerialOutputStream(out);
				navegacion.asignaNavegacion(request,response);
				int accion=navegacion.getAccion();
				ControlesBo cBo=new ControlesBo();
				cBo.comprobarStatusTodo(navegacion);
				switch(accion){
					case 1:
						navegacion.setJsp("/inicio.jsp");
						break;
					case 2:
						cBo.cambiaStatusCalefaccion(navegacion);
						navegacion.setJsp("/calefaccion.jsp");
						break;
					case 3:
						cBo.cambiaStatusAire(navegacion);
						navegacion.setJsp("/aire.jsp");
						break;
				}
			/*}else{
				navegacion.setJsp("/errorSession.jsp");
			}*/
			
		} catch (Exception e) {
			request.setAttribute("error","");
			navegacion.setJsp("/error.jsp");
		} catch (HCException e) {
			request.setAttribute("error", e.getMensaje());
			navegacion.setJsp("/error.jsp");
		}finally{
			try {
				session.setAttribute("navegacion", navegacion);
				request.getRequestDispatcher(navegacion.getJsp()).forward(request, response);
			}catch(Exception e){
				request.setAttribute("error","");
				request.getRequestDispatcher("/errorSession.jsp").forward(request, response);
			}
		}
	}
}
