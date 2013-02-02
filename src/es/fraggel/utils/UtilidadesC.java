package es.fraggel.utils;

import es.fraggel.beans.NavegacionBean;
import es.fraggel.properties.Constantes;

public class UtilidadesC {

		public UtilidadesC(){}
		
		public void calculaPaginacion(NavegacionBean navega,int total){
			if(navega.getPagAnterior()!=-1){
				navega.setPaginacionFin(navega.getPaginacionInicio());
				navega.setPaginacionInicio(navega.getPaginacionInicio()-Constantes.paginasPaginacion);
			}else if(navega.getPagSiguiente()!=-1){
				int finTMP=navega.getPaginacionFin();
				int iniTMP=navega.getPaginacionInicio();
				navega.setPaginacionFin(navega.getPaginacionFin()+Constantes.paginasPaginacion);
				if(finTMP!=total && finTMP<total){
					navega.setPaginacionInicio(finTMP);
				}else{
					navega.setPaginacionInicio(iniTMP);
				}
			}else if(navega.getPagIr()!=0){
				navega.setPaginacionInicio(navega.getPagIr()*Constantes.paginasPaginacion);
				navega.setPaginacionFin(navega.getPagIr()*Constantes.paginasPaginacion+Constantes.paginasPaginacion);
			}else if(navega.getPagInicio()!=-1){
				navega.setPaginacionInicio(0);
				navega.setPaginacionFin(Constantes.paginasPaginacion);
			}else if(navega.getPagFin()!=-1){
				navega.setPaginacionInicio(total+1);
				navega.setPaginacionFin(total);
			}else{
				navega.setPaginacionInicio(0);
				navega.setPaginacionFin(Constantes.paginasPaginacion);
			}
			if(navega.getPaginacionInicio() <0){
				navega.setPaginacionInicio(0);
				navega.setPaginacionFin(Constantes.paginasPaginacion);
			}
			if((navega.getPaginacionFin()>total && total>0 && navega.getBusqueda()==-1) || navega.getPaginacionFin()<0){
				navega.setPaginacionFin(total);
			}
			if(navega.getPaginacionInicio()>navega.getPaginacionFin()){
				//si es mayor al total poner el total menos el multiplo de la paginacion
				int tmpFin=navega.getPaginacionFin();
				while(tmpFin%Constantes.paginasPaginacion!=0){
					tmpFin++;
				}
				navega.setPaginacionInicio(tmpFin-Constantes.paginasPaginacion);
			}
		}

		public void recualculaPaginacion(NavegacionBean navega,
				int total) {
			if(navega.getPaginacionInicio() <0){
				navega.setPaginacionInicio(0);
				navega.setPaginacionFin(Constantes.paginasPaginacion);
			}
			if(navega.getPaginacionFin()>total || navega.getPaginacionFin()<0){
				navega.setPaginacionFin(total);
			}
			
		}
}
