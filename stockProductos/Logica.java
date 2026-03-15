package stockProductos;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class Logica {
	
	List<Producto> inventario = new ArrayList<>(); 
	
	public void actualizarProducto (Scanner sc) {
		System.out.println("ingrese el id del producto");
		int idBuscado = sc.nextInt();
		sc.nextLine();
	
		for (int i = 0 ; i < inventario.size(); i++ ) {
			Producto p = inventario.get(i);
			if(p.getId() == idBuscado) {
				System.out.println("producto encontrado: "+ p.getNombre());
				System.out.print("ingrese el nuevo precio: ");
				double precio = sc.nextDouble();
				System.out.print("ingrese el nuevo stock: ");
				int stock = sc.nextInt();
				p.setPrecio(precio);
				p.setStock(stock);
				System.out.println("valores actualizados con exito");
				sc.nextLine();
				break;
			} else {
				System.out.println("ERROR: prodcuto no encontrado "+ idBuscado );
				break;
			}
		}
	}
	public void agregarProducto (Scanner sc) {
		System.out.println("ingrese el id del nuevo producto");
		int id = sc.nextInt();
		System.out.println("ingrese el nombre del producto");
		String nombre = sc.next();
		System.out.println("ingrese el precio del producto");
		double precio = sc.nextDouble();
		System.out.println("ingrese el stock del producto");
		int stock = sc.nextInt();
		
		Producto n = new Producto(id, nombre, precio, stock);
		inventario.add(n);
	}
	public void cargarInventario () throws IOException {
		File producto = new File ("Productos.csv");
		
		if(!producto.exists()) {
			System.out.println("el archivo no existe creando uno nuevo");
			producto.createNewFile();
			System.out.println("archivo Productos creado con exito");
		}
		
	}
	
	public void leerInventario () {
		try (FileReader lectura = new FileReader("Productos.csv");
				BufferedReader buffer = new BufferedReader(lectura);){
				
				String linea;
				while((linea= buffer.readLine()) != null) {
					System.out.println(linea);
				}
				buffer.close();
			}catch (IOException e) {
				System.out.println("ERROR: lectura incorrecta ");
			}
	}
	
	public void guardarInventario () {
		try(FileWriter fw = new FileWriter("Productos.csv")){
			
			for(Producto p : inventario) {
				String linea = p.getId() + ", " + p.getNombre() + ", " + p.getPrecio() + ", " + p.getStock() + "\n ";  
				fw.write(linea);
			}
		} catch (IOException e) {
			System.out.println("error en el guardado de datos");
		}
	}
	
}
