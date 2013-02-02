package es.fraggel.exception;

public class HCException extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Exception e;
	String mensaje;
	
	public HCException(String men,Exception exp){
		this.e=exp;
		this.mensaje=men;
	}

	public Exception getE() {
		return e;
	}

	public void setE(Exception e) {
		this.e = e;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
