package Biblioteca;
import java.util.Scanner;


public class Terminal {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Biblioteca biblio  = new Biblioteca();
		Prestamos admin = new Prestamos();
		Socios membresia = new Socios();
		Libros libro = new Libros();
		Scanner sc = new Scanner(System.in);
		int opcion=0;
        boolean encendido= true;
		while (encendido) {
		do {
		System.out.println("Bienvenido a la biblioteca");
		System.out.println("Cual operacion desea hacer hoy:");
		System.out.println("1. Dar alta libro");
		System.out.println("2. Dar alta socio");
		System.out.println("3. Iniciar un prestamo de libro");
		System.out.println("4. Devolver un libro");
		System.out.println("5. Consultar reguistros");
		System.out.println("6. Salir del programa");
		opcion= sc.nextInt();
		switch (opcion) {
        case 1:
        	biblio.darAltaLibro(sc);
            break;
        case 2:
            biblio.darAltaSocio(sc);
            break;
        case 3:
            biblio.realizarPrestamo(sc);
            break;
        case 4:
            biblio.devolderLibro(sc);
            break;
        case 5:
        	int opcion2=0;
			do {
        		
            System.out.println("Opción seleccionada: Consultar registros...");
            sc.nextLine();
            System.out.println("Cual registro quiere consultar: ");
            System.out.println("1. registro de los libros");
            System.out.println("2. registro de socios");
            System.out.println("3. registro de prestamos");
            opcion2= sc.nextInt();
            switch (opcion2) {
            case 1 : 
            	System.out.println("Opcion seleccionada: registro de libros");
            	sc.nextLine();
            	System.out.print("Ingrese el título del libro: ");
                String tituloLibro2 = sc.nextLine();
                Libros libroEncontrado2 = biblio.buscarLibrosTitulo(tituloLibro2);
                
                if (libroEncontrado2 == null) {
                    System.out.println("Error: Libro no encontrado.");
                    return;
                }
                if (!libroEncontrado2.getDisponibilidad()) {
                    System.out.println("Error: El libro no esta en base de datos.");
                    return;
                }
            	
            case 2: 
            	 System.out.print("Ingrese el codigo exacto del socio: ");
                 int codigoSocio2 = sc.nextInt();
                 Socios socioEncontrado2 = biblio.buscarSocio(codigoSocio2);
                 if (socioEncontrado2 == null) {
                 	System.out.println("Error: no hay ningun socio con este codigo");
                 	return;
                 }
                 
                 System.out.println("Socio encontrado: " + socioEncontrado2.getNombre());
                 
            case 3:
            	 System.out.print("Ingrese el codigo del prestamo: ");
                 int codigoPrestamo2= sc.nextInt();
                 Prestamos prestamoEncontrado2 = biblio.buscarPrestamo(codigoPrestamo2);
                 if (prestamoEncontrado2 == null) {
                 	 System.out.println("Error: codigo erroneo");
                 	 return;
            } else 
            	System.out.println("Prestamo encontrado " + prestamoEncontrado2.getCodigoPrestamo());
            System.out.println();
            break;
        	} 
        	}while (opcion2 <=  0 || opcion2 > 3);
        case 6:
            System.out.println("Saliendo del sistema. ¡Hasta luego!");
            encendido= false;
            break;
        default:
            System.out.println("ERROR: Opcion incorrecta. Marque un numero del 1 al 6.");
    }

} while (opcion != 6); 
		}
sc.close();
		
		
		}

	private static Socios Socios(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Libros Libros(String string, String string2, int i) {
		// TODO Auto-generated method stub
		return null;
	}
		}
	

