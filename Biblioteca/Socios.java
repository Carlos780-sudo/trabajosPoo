package Biblioteca;

public class Socios {

	private String nombre;
	private int codigoSocio;
	private String correo;
	private static int cantidadLibrosPrestados = 0;
	
	
	public Socios(String nombre, String correo) {
		
		this.nombre = nombre;
		this.correo = correo;
		int generadorCodigo = (int) (Math.random()*5);
		this.codigoSocio = generadorCodigo;
		for (Socios u : Biblioteca.baseDatosSocios) {
			if (Biblioteca.baseDatosSocios.contains(codigoSocio) ) {
				generadorCodigo = (int) (Math.random()*5);
				this.codigoSocio = generadorCodigo;
			} else 
		break;
		}
		return;
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
	
	public int getCantidadLibrosPrestados() {
		return cantidadLibrosPrestados;
	}

	public static void sumarPrestamo() {
		cantidadLibrosPrestados++;
	}
	
	public static void restarPrestamos() {
		cantidadLibrosPrestados--;
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
	 
	 public  static boolean verificacionNombre(String nombre) {
		 if (nombre != null || nombre.isEmpty()) {
			 return false;
		 }
		 return true;
	 }


	 @Override
	 public String toString() {
		return "Socios [nombre=" + nombre + ", codigoSocio=" + codigoSocio + ", correo=" + correo + "]";
	 }
	
}
