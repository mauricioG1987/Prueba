package co.com.prueba.utilidades;

public class Utilidades {
	
	public static boolean esNumerico(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}

}
