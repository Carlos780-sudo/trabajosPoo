package Biblioteca;
import java.util.Scanner;
import java.util.Random;

public class Prestamos {
	
	private boolean prestamoActivo;
	public int codigoPrestamo;
	public final int maxDiasPrestamo = 10;
	public final int maxPrestamos= 3;
	public String afiliado;
	public String libro;
	
	Socios s = new Socios();
	

	public void Prestamos(String afiliado, String libro, int codigoPrestamo) {
        this.afiliado = afiliado;
        this.libro = libro;
        this.codigoPrestamo = codigoPrestamo;
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
		this.socios.restarPrestamos();
	}
	
	 @Override
	 public String toString() {
		return "Prestamos [codigoPrestamo=" + codigoPrestamo + "Esta activo: " + prestamoActivo + "Fecha vencimiento: " +"]";
	 }
	
}
