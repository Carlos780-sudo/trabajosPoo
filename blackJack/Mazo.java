package blackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Mazo {
	private List<Carta> cartas;

    public Mazo() {
        this.cartas = new ArrayList<>();
        generarMazo();
        barajarMazo();
    }
	

	public void generarMazo() {
		String[] palos = { "Corazones", "Diamantes", "Tréboles", "Picas" };
		String[] nombres = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

		for (String palo : palos) {
			for (String nombre : nombres) {
				int valor;

				if (nombre.equals("J") || nombre.equals("Q") || nombre.equals("K")) {
					valor = 10;
				} else if (nombre.equals("A")) {
					valor = 11; //cuadrar valor de 11-1 cuando el resultado pase de 21
				} else {
					valor = Integer.parseInt(nombre);
				}
		
				cartas.add(new Carta(palo, nombre, valor));
			}
		}
	}
	public void barajarMazo() {
	    Collections.shuffle(cartas); 
	}
	public Carta repartirCarta() {
        if (cartas.isEmpty()) {
            return null;
        }
        return cartas.remove(0); // El método remove(0) saca el elemento y reduce el .size()
    }
}
