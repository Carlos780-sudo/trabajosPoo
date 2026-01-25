package Biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Biblioteca {

	public static List<Socios> baseDatosSocios = new ArrayList<>();
	public static List<Libros> baseDatosLibros = new ArrayList<>();
	public static List<Prestamos> baseDatosPrestamos = new ArrayList<>();
	
	public static void guardarSocio(Socios codigoSocio) {
		baseDatosSocios.add(codigoSocio);
	}
	
	public static void guardarLibros(Libros codigoLibro) {
		baseDatosLibros.add(codigoLibro);
	}
	public static void guardarPrestamo(Prestamos codigoPrestamo) {
		baseDatosPrestamos.add(codigoPrestamo);
	}
	public static Libros buscarLibrosTitulo(String tituloLibro) {
		for (Libros n : baseDatosLibros) {
			if (n.getTitulo().equalsIgnoreCase(tituloLibro)) {
				return n;
			}
		}
		return null;
	}
	
	public static Libros buscarLibros(int codigoLibro) {
		for (Libros n : baseDatosLibros) {
			if (n.getCodigoLibro() == codigoLibro) {
				return n;
			}
		}
		return null;
	}
	public static Socios buscarSocio(int codigoSocio) {
		for (Socios n : baseDatosSocios) {
			if (n. getCodigoSocio() == codigoSocio) {
				return n;
			}
		}
		return null;
	}
	public static Prestamos buscarPrestamo(int codigoPrestamo) {
		for (Prestamos n : baseDatosPrestamos) {
			if (n.getCodigoPrestamo() == codigoPrestamo) {
				return n;
			}
		}
		return null;
	}
	
	public static void darAltaLibro(Scanner sc) {
		System.out.println("Alta de libro nuevo");
		sc.nextLine();
		
		System.out.print("Ingrese el titulo: ");
		String titulo = sc.nextLine();
		
		System.out.print("Ingrese el autor");
		String autor = sc.nextLine();
		
		System.out.print("Fecha de publicación: ");
	    int fechaPublicacion = sc.nextInt();
	    
	    Libros nuevoLibro = new Libros(titulo, autor, fechaPublicacion);
	    
	    Biblioteca.baseDatosLibros.add(nuevoLibro);
	    System.out.println("Libro registrado"+ nuevoLibro);
		
	}
	
	public static void darAltaSocio(Scanner sc) {
		System.out.println("Alta de nuevo socio");
		sc.nextLine();
		String nombre= "";
		while (true) {
		System.out.print("Ingrese el Nombre completo: ");
		nombre = sc.nextLine();
		if (Socios.verificacionNombre(nombre)) {
			break;
		} else {
			System.out.println("Error-> el nombre no puede estar vacio");
		}
		
		}
		String correo= "";
		while (true) {
		System.out.print("Ingrese un correo electronico: ");
		correo = sc.nextLine();
		if (Socios.validacionCorreo(correo)) {
			break;
		} else {
			System.out.println("Error-> el correo tiene que tener un formato valido");
		}
		}
		
		Socios nuevoSocio = new Socios(nombre, correo);
		Biblioteca.baseDatosSocios.add(nuevoSocio);
		
		System.out.println("Socio registrado" + nuevoSocio);
	}
	
	
}
