package Biblioteca;


public class Prestamos {
	
	private boolean prestamoActivo;
	public int codigoPrestamo;
	public final int maxDiasPrestamo = 10;
	public final int maxPrestamos= 3;
	public Socios codigoSocio;
	public Libros libro;
	private int cantidadLibrosPrestados;
	

	public Prestamos(Socios codigoSocio, Libros libro, int codigoPrestamo) {
        this.codigoSocio = codigoSocio;
        this.libro = libro;
        this.codigoPrestamo = codigoPrestamo;
    }
	public Prestamos() {
    }
	public boolean cupoDisponible() {
	    if (this.cantidadLibrosPrestados >= 3) {
	        System.out.println("Error: límite máximo de 3 préstamos alcanzado.");
	        return false; 
	    }
	    return true; 
	}

	public void sumarPrestamo() {
	    this.cantidadLibrosPrestados++;
	}

	public void restarPrestamos() {
	    if (this.cantidadLibrosPrestados > 0) {
	        this.cantidadLibrosPrestados--;
	    }
	}
	 public boolean isPrestamoActivo() {
		return prestamoActivo;
	}

	public int getCodigoPrestamo() {
		return codigoPrestamo;
	}


	public void setCodigoPrestamo(int codigoPrestamo) {
		this.codigoPrestamo = codigoPrestamo;
	}

	public void finalizarPrestamo() {
		this.prestamoActivo = false; 
		this.restarPrestamos();
	}
	
	public int getCantidadLibrosPrestados() {
		return cantidadLibrosPrestados;
	}
	
	public void setCantidadLibrosPrestados(int cantidadLibrosPrestados) {
		this.cantidadLibrosPrestados = cantidadLibrosPrestados;
	}
	
	 @Override
	 public String toString() {
		return "Prestamos [codigoPrestamo=" + codigoPrestamo + "Esta activo: " + prestamoActivo + "Fecha vencimiento: " +"]";
	 }

}
