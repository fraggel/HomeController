package es.fraggel.beans;

import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.fraggel.exception.HCException;
import gnu.io.SerialPort;

public class NavegacionBean {
	SerialPort serialPort=null;
	InputStream serialInputStream=null;
	OutputStream serialOutputStream=null;
	
	int accion=-1;
	int subAccion=-1;
	int paginacionInicio=0;
	int paginacionFin=0;
	int pagSiguiente=-1;
	int pagAnterior=-1;
	int pagIr=0;
	int pagInicio=-1;
	int pagFin=-1;
	int busqueda=-1;
	
	String jsp="/error.jsp";
	boolean calefaccion=false;
	boolean aireSalon=false;
	boolean aireHabitacion=false;
	
	String calefaccionStatus=null;
	String aireSalonStatus=null;
	String aireHabitacionStatus=null;
	/*String tarjetasConsultaPeticionesCliente=null;
	int totalConsultaPeticiones=0;
	ArrayList listaConsultaPeticiones=null;
	
	*/
	public NavegacionBean(){
	}

	public void asignaNavegacion(HttpServletRequest request,HttpServletResponse response) throws HCException{
		try {
			accion=Integer.parseInt(request.getParameter("accion"));
			if(request.getParameter("subAccion")!=null){
				subAccion=Integer.parseInt(request.getParameter("subAccion"));
			}else{
				subAccion=-1;
			}
			
			if(request.getParameter("pagAnterior")!=null){
				pagAnterior=1;
			}else if(request.getParameter("pagSiguiente")!=null ){
				pagAnterior=-1;
			}else if(request.getParameter("pagIr")!=null && !"".equals(request.getParameter("pagIr"))){
				pagAnterior=-1;
			}else if(request.getParameter("pagInicio")!=null){
				pagAnterior=-1;
			}else if(request.getParameter("pagFin")!=null){
				pagAnterior=-1;
			}else{
				pagAnterior=-1;
				paginacionInicio=0;
				paginacionFin=0;
				pagIr=0;
				pagInicio=-1;
				pagFin=-1;
			}
			if(request.getParameter("pagSiguiente")!=null){
				pagSiguiente=1;
			}else if(request.getParameter("pagAnterior")!=null){
				pagSiguiente=-1;
			}else if(request.getParameter("pagIr")!=null && !"".equals(request.getParameter("pagIr"))){
				pagSiguiente=-1;
			}else if(request.getParameter("pagInicio")!=null){
				pagSiguiente=-1;
			}else if(request.getParameter("pagFin")!=null){
				pagSiguiente=-1;
			}else{
				pagSiguiente=-1;
				paginacionInicio=0;
				paginacionFin=0;
				pagIr=0;
				pagInicio=-1;
				pagFin=-1;
			}
			if(request.getParameter("pagIr")!=null && !"".equals(request.getParameter("pagIr"))){
				try {
					pagIr=Integer.parseInt(request.getParameter("pagIr"));
				} catch (Exception e) {
					pagIr=0;
				}
			}
			
			if(request.getParameter("pagInicio")!=null){
				pagInicio=1;
				pagFin=-1;
				pagIr=0;
			}
			if(request.getParameter("pagFin")!=null){
				pagFin=1;
				pagInicio=-1;
				pagIr=0;
			}
			if(request.getParameter("calefaccion")!=null){
				calefaccion=true;
			}else{
				calefaccion=false;
			}
			if(request.getParameter("aireSalon")!=null){
				aireSalon=true;
			}else{
				aireSalon=false;
			}
			if(request.getParameter("aireHabitacion")!=null){
				aireHabitacion=true;
			}else{
				aireHabitacion=false;
			}
		}catch(Exception e){
			throw new HCException("Error al tratar parámetros",e);
		}
	}

	public String getCalefaccionStatus() {
		return calefaccionStatus;
	}

	public void setCalefaccionStatus(String calefaccionStatus) {
		this.calefaccionStatus = calefaccionStatus;
	}

	public String getAireSalonStatus() {
		return aireSalonStatus;
	}

	public void setAireSalonStatus(String aireSalonStatus) {
		this.aireSalonStatus = aireSalonStatus;
	}

	public String getAireHabitacionStatus() {
		return aireHabitacionStatus;
	}

	public void setAireHabitacionStatus(String aireHabitacionStatus) {
		this.aireHabitacionStatus = aireHabitacionStatus;
	}


	public boolean getCalefaccion() {
		return calefaccion;
	}

	public void setCalefaccion(boolean calefaccion) {
		this.calefaccion = calefaccion;
	}

	public boolean getAireSalon() {
		return aireSalon;
	}

	public void setAireSalon(boolean aireSalon) {
		this.aireSalon = aireSalon;
	}

	public boolean getAireHabitacion() {
		return aireHabitacion;
	}

	public void setAireHabitacion(boolean aireHabitacion) {
		this.aireHabitacion = aireHabitacion;
	}

	public int getAccion() {
		return accion;
	}

	public void setAccion(int accion) {
		this.accion = accion;
	}

	public int getSubAccion() {
		return subAccion;
	}

	public void setSubAccion(int subAccion) {
		this.subAccion = subAccion;
	}

	public int getPaginacionInicio() {
		return paginacionInicio;
	}

	public void setPaginacionInicio(int paginacionInicio) {
		this.paginacionInicio = paginacionInicio;
	}

	public int getPaginacionFin() {
		return paginacionFin;
	}

	public void setPaginacionFin(int paginacionFin) {
		this.paginacionFin = paginacionFin;
	}

	public int getPagSiguiente() {
		return pagSiguiente;
	}

	public void setPagSiguiente(int pagSiguiente) {
		this.pagSiguiente = pagSiguiente;
	}

	public int getPagAnterior() {
		return pagAnterior;
	}

	public void setPagAnterior(int pagAnterior) {
		this.pagAnterior = pagAnterior;
	}

	public int getPagIr() {
		return pagIr;
	}

	public void setPagIr(int pagIr) {
		this.pagIr = pagIr;
	}

	public int getPagInicio() {
		return pagInicio;
	}

	public void setPagInicio(int pagInicio) {
		this.pagInicio = pagInicio;
	}

	public int getPagFin() {
		return pagFin;
	}

	public void setPagFin(int pagFin) {
		this.pagFin = pagFin;
	}

	public int getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(int busqueda) {
		this.busqueda = busqueda;
	}

	public String getJsp() {
		return jsp;
	}

	public void setJsp(String jsp) {
		this.jsp = jsp;
	}

	public void setSerialPort(SerialPort serial) {
		this.serialPort=serial;
		
	}
	public SerialPort getSerialPort() {
		return this.serialPort;
		
	}

	public void setSerialInputStream(InputStream in) {
		this.serialInputStream=in;
	}
	public InputStream getSerialInputStream() {
		return this.serialInputStream;
	}

	public void setSerialOutputStream(OutputStream out) {
		this.serialOutputStream=out;
		
	}
	public OutputStream getSerialOutputStream() {
		return this.serialOutputStream;
		
	}
	
}
