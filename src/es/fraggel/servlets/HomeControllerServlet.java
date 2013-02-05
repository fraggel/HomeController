package es.fraggel.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.fraggel.beans.NavegacionBean;
import es.fraggel.bo.ControlesBo;
import es.fraggel.exception.HCException;

/**
 * Servlet implementation class HomeControllerServlet
 */
public class HomeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
				navegacion.asignaNavegacion(request,response);
				int accion=navegacion.getAccion();
				ControlesBo cBo=new ControlesBo();
				//cBo.comprobarStatusTodo(navegacion);
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
