package Biblioteca;

public class Prestamos {
	
	private static boolean prestamoActivo;
	private int codigoPrestamo;
	public final int maxDiasPrestamo = 10;
	public final int maxPrestamos= 3;
	private Date fechaInicioPrestamo; 
	private Date fechaFinalPrestamo;
	
	private Socios socio;
	private Libros libro;
	private Date Date;
	public Socios getSocio() { return socio; }
	public Libros getLibro() { return libro; }
	
	 public static boolean isPrestamoActivo() {
		return prestamoActivo;
	}


	public void setPrestamoActivo(boolean prestamoActivo) {
		Prestamos.prestamoActivo = prestamoActivo;
	}


	public int getCodigoPrestamo() {
		return codigoPrestamo;
	}


	public void setCodigoPrestamo(int codigoPrestamo) {
		this.codigoPrestamo = codigoPrestamo;
	}
	

	public Prestamos(Socios socio, Libros libro) {
		this.socio = socio;
		this.libro = libro;
		this.prestamoActivo = true;
		Date nuevaFecha= new Date();
		this.fechaInicioPrestamo = nuevaFecha;
		Date nuevaFecha2= new Date();
		this.fechaFinalPrestamo = nuevaFecha2;
		int generadorCodigo = (int) (Math.random()*11);
		this.codigoPrestamo = generadorCodigo;
		for (Prestamos u : Biblioteca.baseDatosPrestamos) {
			if (Biblioteca.baseDatosPrestamos.contains(codigoPrestamo) ) {
				generadorCodigo = (int) (Math.random()*11);
				this.codigoPrestamo = generadorCodigo;
			} else 
		break;
		}
		
		
 } 
	public void finalizarPrestamo() {
		this.prestamoActivo = false; 
		this.socio.restarPrestamos();
	}
	
	 @Override
	 public String toString() {
		return "Prestamos [codigoPrestamo=" + codigoPrestamo + "Esta activo: " + prestamoActivo + "Fecha vencimiento: " + fechaFinalPrestamo +"]";
	 }
	
}
