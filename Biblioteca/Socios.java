package Biblioteca;
public class Socios {

	private String nombre;
	public int codigoSocio;
	private String correo;
	
	public Socios(String nombre, String correo, int codigoSocio) {
		this.nombre = nombre;
		this.correo = correo;
		this.codigoSocio = codigoSocio;
	}	
	public Socios() {
		
	}
	 public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCodigoSocio() {
		return codigoSocio;
	}


	public void setCodigoSocio(int codigoSocio) {
		this.codigoSocio = codigoSocio;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	 public static boolean validacionCorreo(String correo) {
		 if (correo == null || correo.isEmpty()) {
	            return false;
	        }
		 int posicionArroba = correo.indexOf('@');
	        if (posicionArroba == -1) {
	            return false;
	        }
	        if (correo.indexOf('@', posicionArroba + 1) != -1) {
	            return false;
	        }
	        int posicionPunto = correo.lastIndexOf('.');
	        if (posicionPunto == -1 || posicionPunto < posicionArroba) {
	            return false; 
	        }
	        if (posicionArroba == 0) {
	            return false;
	        }
	        if (posicionPunto == correo.length() - 1) {
	            return false;
	        }
	        if (correo.contains(" ")) {
	            return false;
	        }
	        return true;   
	}
	 
	 public boolean verificacionNombre(String nombre) {
		 return nombre != null && !nombre.trim().isEmpty();
	 }


	 @Override
	 public String toString() {
		return "Socios [nombre=" + nombre + ", codigoSocio=" + codigoSocio + ", correo=" + correo + "]";
	 }
	
}
