package es.fraggel.bo;

import es.fraggel.beans.UsuarioBean;
import es.fraggel.dao.LoginDao;
import es.fraggel.exception.HCException;
import es.fraggel.properties.Parametros;
import es.fraggel.utils.SeguridadUtils;

public class LoginBo {

	public LoginBo() {
	}
	
	public UsuarioBean login(String usuario, String contrasenya) throws HCException{
		try {
			Parametros parametros=new Parametros();
			LoginDao loginDao=new LoginDao();
			SeguridadUtils segUtils=new SeguridadUtils();
			if(segUtils.comprobarUsuario(usuario,contrasenya)){
				UsuarioBean usuarioBean = loginDao.login(usuario,parametros);
				return usuarioBean;
			}else{
				throw new HCException("Error en la comprobación de campos", new Exception());
			}
		} catch (Exception e) {
			throw new HCException("Error en LoginBo",e);
		}
	}

}
