package Biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Biblioteca {

	public List<Socios> baseDatosSocios = new ArrayList<>();
	public List<Libros> baseDatosLibros = new ArrayList<>();
	public List<Prestamos> baseDatosPrestamos = new ArrayList<>();
	Prestamos nuevo = new Prestamos();
	Socios miSocio = new Socios();
	
	public void devolderLibro (Scanner sc) {
		System.out.println("Opcion seleccionada: Devolver libro...");
        sc.nextLine();
        System.out.print("Ingrese el codigo del prestamo: ");
        int codigoPrestamo= sc.nextInt();
        Prestamos prestamoEncontrado = buscarPrestamo(codigoPrestamo);
        if (prestamoEncontrado == null) {
        	 System.out.println("Error: codigo erroneo");
        	 return;
        } else
        	System.out.println("Prestamo encontrado " + prestamoEncontrado.getCodigoPrestamo());
        nuevo.finalizarPrestamo();
	}
	
	public void realizarPrestamo(Scanner sc) {
		boolean opcionValida = true;
		Socios sociosPrestamos = null;
	    System.out.println("\n--- Nuevo Préstamo ---");
	    do {
	    System.out.print("Introduce el código del socio: ");
	    int codSocio = sc.nextInt();
	    sociosPrestamos = buscarSocio(codSocio);
	    
	    if (sociosPrestamos == null) {
	    	System.out.println("Error: socio no encontrado");
	    	opcionValida = false;
	    } 
	    	
	    } while (opcionValida);
	    nuevo.cupoDisponible();
	    Libros libro;
	    do {
	    System.out.print("Introduce el código del libro: ");
	    int idLibro = sc.nextInt();
	    libro = buscarLibros(idLibro);
	    if (libro == null) {
	        System.out.println("Error: Libro no encontrado.");
	        opcionValida = false;
	    }
	    } while(opcionValida);
	    int nuevoIdPrestamo = generarCodigoUnicoLibro();
	    Prestamos p = new Prestamos(sociosPrestamos , libro, nuevoIdPrestamo);
	    baseDatosPrestamos.add(p);
	    p.sumarPrestamo();
	    System.out.println("Préstamo registrado correctamente.");
	    System.out.println("Socio: " + miSocio.getNombre() + " | Libro: " + libro.getTitulo());
	}
	
	public int generarCodigoUnicoLibro() {
        Random rand = new Random();
        int nuevoCodigo;
        boolean repetido;
        do {
            repetido = false;
            nuevoCodigo = rand.nextInt(1000);
            for (Libros l : baseDatosLibros) {
                if (l.getCodigoLibro() == nuevoCodigo) {
                    repetido = true;
                    break;
                }
            }
        } while (repetido);
        
        return nuevoCodigo;
    }
	public int generarCodigoUnicoSocios() {
        Random rand = new Random();
        int nuevoCodigo;
        boolean repetido;
        do {
            repetido = false;
            nuevoCodigo = rand.nextInt(1000);
            for (Socios s : baseDatosSocios) {
                if (s.getCodigoSocio() == nuevoCodigo) {
                    repetido = true;
                    break;
                }
            }
        } while (repetido);
        
        return nuevoCodigo;
    }
	
	public int generarCodigoUnicoPrestamos() {
		Random rand = new Random();
		int nuevoCodigo;
		boolean repetido;
		
		do {
			repetido = false;
			nuevoCodigo = rand.nextInt(1000);
			for (Prestamos p : baseDatosPrestamos) {
				if (p.getCodigoPrestamo() == nuevoCodigo) {
					repetido = true;
					break;
				}
			}
		} while (repetido);
		
		return nuevoCodigo;
	}
	
	public void guardarSocio(Socios codigoSocio) {
		baseDatosSocios.add(codigoSocio);
	}
	
	public void guardarLibros(Libros codigoLibro) {
		baseDatosLibros.add(codigoLibro);
	}
	public void guardarPrestamo(Prestamos codigoPrestamo) {
		this.baseDatosPrestamos.add(codigoPrestamo);
	}
	public Libros buscarLibrosTitulo(String tituloLibro) {
		for (Libros n : baseDatosLibros) {
			if (n.getTitulo().equalsIgnoreCase(tituloLibro)) {
				return n;
			}
		}
		return null;
	}
	
	public Libros buscarLibros(int codigoLibro) {
		for (Libros n : baseDatosLibros) {
			if (n.getCodigoLibro() == codigoLibro) {
				return n;
			}
		}
		return null;
	}
	public Socios buscarSocio(int codigoSocio) {
		for (Socios n : baseDatosSocios) {
			if (n. getCodigoSocio() == codigoSocio) {
				return n;
			}
		}
		return null;
	}
	public Prestamos buscarPrestamo(int codigoPrestamo) {
		for (Prestamos n : baseDatosPrestamos) {
			if (n.getCodigoPrestamo() == codigoPrestamo) {
				return n;
			}
		}
		return null;
	}
	
	public void darAltaLibro(Scanner sc) {
        System.out.println("\n--- Alta de Libro Nuevo ---");
        sc.nextLine();
        System.out.print("Ingrese el título: ");
        String titulo = sc.nextLine();
        
        System.out.print("Ingrese el autor: ");
        String autor = sc.nextLine();
        
        System.out.print("Año de publicación: ");
        while (!sc.hasNextInt()) { 
            System.out.print("Por favor, ingrese un año válido: ");
            sc.next();
        }
        int fechaPublicacion = sc.nextInt();
        generarCodigoUnicoLibro();
        Libros nuevoLibro = new Libros();
        baseDatosLibros.add(nuevoLibro);
        System.out.println("Libro registrado con éxito: " + nuevoLibro);
    }
	
	public void darAltaSocio(Scanner sc) {
		System.out.println("\n--- Alta de Nuevo Socio ---");
        sc.nextLine(); 
        
        String nombre;
        boolean clicloNombres = true;
		do {
            System.out.print("Ingrese el Nombre completo: ");
            nombre = sc.nextLine();
            if (miSocio.verificacionNombre(nombre) != false) {
            	clicloNombres = false;	
            } else 
            System.out.println("Error: el nombre no puede estar vacío.");
        } while (clicloNombres);

        String correo;
        
        while (true) {
            System.out.print("Ingrese correo electrónico: ");
            correo = sc.nextLine();
            if (Socios.validacionCorreo(correo)) break;
            System.out.println("Error: formato de correo inválido.");
        }
        generarCodigoUnicoSocios();
        
        Socios nuevoSocio = new Socios();
        baseDatosSocios.add(nuevoSocio);
        
        System.out.println("Socio registrado: " + nuevoSocio);
    }
	
}
