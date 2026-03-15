package stockProductos;
import java.io.IOException;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 boolean activado = true;
		 Logica p = new Logica();
		 System.out.println("------Gestion de tienda------");
		 p.cargarInventario();
		 do {
		 System.out.println("1.Listar productos");
		 System.out.println("2.Añadir producto");
		 System.out.println("3.Actualizar stock");
		 System.out.println("4.Guardar y salir");
		 int opcion = sc.nextInt();
		 switch (opcion) {
		case 1: {
			p.leerInventario();
		}
		case 2: {
			p.agregarProducto(sc);
		}
		case 3: {
			p.actualizarProducto(sc);
		}
		case 4: {
			p.guardarInventario();
			System.out.println("guardando inventario y cerrando el programa");
			activado = false;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcion);
		}
			 
		 
		 } while (activado);
	}

}
