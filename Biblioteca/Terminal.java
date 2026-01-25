package Biblioteca;
import java.util.Scanner;


public class Terminal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc = new Scanner(System.in);
		int opcion=0;
		Biblioteca.baseDatosLibros.add(new Libros("Don Quijote", "Miguel de Cervantes", 1605));
        Biblioteca.baseDatosLibros.add(new Libros("100 años de soledad", "Gabriel García Márquez", 1967));
        Biblioteca.baseDatosLibros.add(new Libros("El resplandor", "Stephen King", 1977));
        Biblioteca.baseDatosLibros.add(new Libros("Harry Potter 1", "J. K. Rowling", 1997));
        Biblioteca.baseDatosLibros.add(new Libros("Juego de Tronos", "George R. R. Martin", 1996));
        Biblioteca.baseDatosLibros.add(new Libros("El exorcista", "William Peter Blatty", 1949));

        Biblioteca.baseDatosSocios.add(new Socios("Juan Pablo Cardenas", "Juan@correo.com"));
        Biblioteca.baseDatosSocios.add(new Socios("Jhon Andres Juares", "jhon@correo.com"));
        Biblioteca.baseDatosSocios.add(new Socios("Maria Camila Contreras", "Maria@correo.com"));
        boolean encendido= true;
		while (encendido) {
		do {
		System.out.println("Biembenido a la biblioteca");
		System.out.println("Cual operaciondesea hacer hoy:");
		System.out.println("1. Dar alta libro");
		System.out.println("2. Dar alta socio");
		System.out.println("3. Iniciar un prestamo de libro");
		System.out.println("4. Devolver un libro");
		System.out.println("5. Consultar reguistros");
		System.out.println("6. Salir del programa");
		opcion= sc.nextInt();
		switch (opcion) {
        case 1:
        	Biblioteca.darAltaLibro(sc);
            break;
        case 2:
            Biblioteca.darAltaSocio(sc);
            break;
        case 3:
            System.out.println("Opción seleccionada: Iniciar préstamo...");
            sc.nextLine();
            
            System.out.print("Ingrese el codigo exacto del socio: ");
            int codigoSocio = sc.nextInt();
            Socios socioEncontrado = Biblioteca.buscarSocio(codigoSocio);
            if (socioEncontrado == null) {
            	System.out.println("Error: no hay ningun socio con este codigo");
            	return;
            }
            
            System.out.println("Socio encontrado: " + socioEncontrado.getNombre());
            
            if (socioEncontrado.getCantidadLibrosPrestados() >= 3) {
                System.out.println("Error: " + socioEncontrado.getNombre() + " ya alcanzo su limite de 3 libros.");
                return;
            }
            System.out.print("Ingrese el título del libro: ");
            String tituloLibro = sc.nextLine();
            Libros libroEncontrado = Biblioteca.buscarLibrosTitulo(tituloLibro);
            
            if (libroEncontrado == null) {
                System.out.println("Error: Libro no encontrado.");
                return;
            }
            if (!libroEncontrado.getDisponibilidad()) {
                System.out.println("Error: El libro no esta disponible.");
                return;
            }
            Prestamos nuevoPrestamo = new Prestamos(socioEncontrado, libroEncontrado);
            Socios.sumarPrestamo();
            Libros.setDisponibilidad(false);
            Biblioteca.baseDatosPrestamos.add(nuevoPrestamo);

            System.out.println("Prestamo realizado con exito.");
            System.out.println(nuevoPrestamo);
            break;
        case 4:
            System.out.println("Opcion seleccionada: Devolver libro...");
            sc.nextLine();
            System.out.print("Ingrese el codigo del prestamo: ");
            int codigoPrestamo= sc.nextInt();
            Prestamos prestamoEncontrado = Biblioteca.buscarPrestamo(codigoPrestamo);
            if (prestamoEncontrado == null) {
            	 System.out.println("Error: codigo erroneo");
            	 return;
            } else
            	System.out.println("Prestamo encontrado " + prestamoEncontrado.getCodigoPrestamo());
            Prestamos.finalizarPrestamo();
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
                Libros libroEncontrado2 = Biblioteca.buscarLibrosTitulo(tituloLibro2);
                
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
                 Socios socioEncontrado2 = Biblioteca.buscarSocio(codigoSocio2);
                 if (socioEncontrado2 == null) {
                 	System.out.println("Error: no hay ningun socio con este codigo");
                 	return;
                 }
                 
                 System.out.println("Socio encontrado: " + socioEncontrado2.getNombre());
                 
                 if (socioEncontrado2.getCantidadLibrosPrestados() >= 3) {
                     System.out.println("Error: " + socioEncontrado2.getNombre() + " ya alcanzo su limite de 3 libros.");
                     return;
                 }
            case 3:
            	 System.out.print("Ingrese el codigo del prestamo: ");
                 int codigoPrestamo2= sc.nextInt();
                 Prestamos prestamoEncontrado2 = Biblioteca.buscarPrestamo(codigoPrestamo2);
                 if (prestamoEncontrado2 == null) {
                 	 System.out.println("Error: codigo erroneo");
                 	 return;
            } else 
            	System.out.println("Prestamo encontrado " + prestamoEncontrado.getCodigoPrestamo());
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
		}
	

