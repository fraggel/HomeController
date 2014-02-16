package es.fraggel.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.fraggel.beans.UsuarioBean;
import es.fraggel.bo.LoginBo;
import es.fraggel.exception.HCException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String jsp="error.jsp";
		HttpSession session=request.getSession();
		try {
			LoginBo lBo=new LoginBo();
			UsuarioBean usuarioBean = lBo.login(request.getParameter("usuario"),request.getParameter("contrasenya"));
			session.setAttribute("usuario", usuarioBean);
			jsp="inicio.jsp";
		} catch (Exception e) {
			request.setAttribute("error","");
			jsp="error.jsp";
		} catch (HCException e) {
			request.setAttribute("error", e.getMensaje());
			jsp="error.jsp";
		}finally{
			
			request.getRequestDispatcher(jsp).forward(request, response);
		}
	}

	
}
