package Ruleta;

import java.util.Scanner;

public class JuegoInterfaz {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Ruleta rule = new Ruleta();
		boolean sistema = true;
		Apuestas jugador = new Apuestas();
		int tirada;
		String resultadoColor;
		boolean entradaValida = false;
		
		do {
			try {
				System.out.println("----BIENVENIDO A LA RULETA-----");
				System.out.print("Ingrese el saldo inical: ");
				jugador.validarSaldo(sc.nextInt());
				entradaValida = true;
			} catch (SaldoNegativoExepcion e) {
				System.out.println(e.getMessage());
			}
		} while (!entradaValida);
		entradaValida= false;
		do {
			System.out.println("¿Qué opción quieres apostar?");
			System.out.println("1. Apostar a un color");
			System.out.println("2. Apostar a una fila");
			System.out.println("3. Apostar a par/impar");
			System.out.println("4. Apostar a un número");
			System.out.println("5. Apostar a una docena");
			System.out.println("6. Apagar sistema");
			int opcion = sc.nextInt();

			switch (opcion) {
			case 1 -> {
				do {
					try {
						System.out.print("¿Cuánto dinero quieres apostar?: ");
						jugador.apuestaValida(sc.nextInt());
						entradaValida= true;
				} catch (SaldoNegativoExepcion e) { 
					System.out.println(e.getMessage());
					}
				
				} while (!entradaValida);

				System.out.println("¿A qué color?");
				System.out.println("1. Negro");
				System.out.println("2. Rojo");
				int opcion2 = sc.nextInt();

				System.out.println("Se cierran las apuestas y se tira la bolita ");
				tirada = rule.bolita();
				resultadoColor = rule.obtenerColor(tirada);
				System.out.println("El resultado es: " + tirada + " de color " + resultadoColor);
				switch (opcion2) {
				case 1 -> {
					if (resultadoColor.equals(rule.NEGRO)) {
						System.out.println("Has ganado!");
						jugador.aumentoColor(jugador.apuesta);
					} else {
						System.out.println("Has perdido!");
						jugador.decremento(jugador.apuesta);
					}
				}
				case 2 -> {
					if (resultadoColor.equals(rule.ROJO)) {
						System.out.println("Has ganado!");
						jugador.aumentoColor(jugador.apuesta);
					} else {
						System.out.println("Has perdido!");
						jugador.decremento(jugador.apuesta);
					}

				}
				default -> System.out.println("Opción no válida.");

				}
				System.out.println("Su nuevo saldo es: " + jugador.saldo);
			}
			case 2 -> {
				do {
					try {
						System.out.print("¿Cuánto dinero quieres apostar?: ");
						jugador.apuestaValida(sc.nextInt());
						entradaValida= true;
				} catch (SaldoNegativoExepcion e) { 
					System.out.println(e.getMessage());
					}
				
				} while (!entradaValida);
				System.out.println("A qué fila quieres apostar?");
				System.out.println("1. Primera fila (la fila del número 1)");
				System.out.println("2. Segunda fila (la fila del número 2");
				System.out.println("3. tercera fila (la fila del número 3");
				int opcionFila = sc.nextInt();
				System.out.println();

				System.out.println("Se cierran las apuestas y se tira la bolita ");
				tirada = rule.bolita();
				resultadoColor = rule.obtenerColor(tirada);
				System.out.println("El resultado es: " + tirada + " de color " + resultadoColor);

				boolean apostarFila = rule.apostarFila(opcionFila);

				if (apostarFila == true) {
					jugador.aumentoPorFila(jugador.apuesta);
				} else {
					jugador.decremento(jugador.apuesta);
				}

				System.out.println("Su nuevo saldo es: " + jugador.saldo);
				break;
			}
			case 3 -> {
				do {
					try {
						System.out.print("¿Cuánto dinero quieres apostar?: ");
						jugador.apuestaValida(sc.nextInt());
						entradaValida= true;
				} catch (SaldoNegativoExepcion e) { 
					System.out.println(e.getMessage());
					}
				
				} while (!entradaValida);
				System.out.println("Elije una opcion a apostar: ");
				System.out.println("1. Par");
				System.out.println("2. Impar");
				int opcion3 = sc.nextInt();

				System.out.println("Se cierran las apuestas y se tira la bolita ");
				tirada = rule.bolita();
				resultadoColor = rule.obtenerColor(tirada);
				System.out.println("El resultado es: " + tirada + " de color " + resultadoColor);

				switch (opcion3) {

				case 1 -> {
					boolean victoriaPar = rule.apostarPar(tirada);
					if (victoriaPar == true) {
						System.out.println("Has ganado!");
						jugador.aumentoPorPar_Impar(jugador.apuesta);
					} else {
						System.out.println("Has perdido!");
						jugador.decremento(jugador.apuesta);
					}
					System.out.println("Su nuevo saldo es: " + jugador.saldo);
				}

				case 2 -> {
					boolean victoriaImpar = rule.apostarImpar(tirada);
					if (victoriaImpar == true) {
						System.out.println("Has ganado!");
						jugador.aumentoPorPar_Impar(jugador.apuesta);
					} else {
						System.out.println("Has perdido!");
						jugador.decremento(jugador.apuesta);
					}
					System.out.println("Su nuevo saldo es: " + jugador.saldo);
				}
				}

			}

			case 4 -> {
				do {
					try {
						System.out.print("¿Cuánto dinero quieres apostar?: ");
						jugador.apuestaValida(sc.nextInt());
						entradaValida= true;
				} catch (SaldoNegativoExepcion e) { 
					System.out.println(e.getMessage());
					}
				
				} while (!entradaValida);
				int numero;
				do {
					System.out.println("Elige un número de 0 a 36 ");
					numero = sc.nextInt();
				} while (numero < 0 || numero > 36);
				System.out.println("Se cierran las apuestas y se tira la bolita ");
				tirada = rule.bolita();
				resultadoColor = rule.obtenerColor(tirada);
				System.out.println("El resultado es: " + tirada + " de color " + resultadoColor);

				boolean victoriaNumero = rule.apostarNumero(tirada, numero);
				if (victoriaNumero == true) {
					System.out.println("Has ganado!");
					jugador.aumentoPorNumero(jugador.apuesta);
				} else {
					System.out.println("Has perdido!");
					jugador.decremento(jugador.apuesta);
				}
				System.out.println("Su nuevo saldo es: " + jugador.saldo);
			}

			case 5 -> {
				do {
					try {
						System.out.print("¿Cuánto dinero quieres apostar?: ");
						jugador.apuestaValida(sc.nextInt());
						entradaValida= true;
				} catch (SaldoNegativoExepcion e) { 
					System.out.println(e.getMessage());
					}
				
				} while (!entradaValida);
				System.out.println("¿A qué docena quieres apostar?");
				System.out.println("1. Primera docena");
				System.out.println("2. Segunda docena");
				System.out.println("3. Tercera docena");
				int opcionDocena = sc.nextInt();

				System.out.println("Se cierran las apuestas y se tira la bolita ");
				tirada = rule.bolita();
				resultadoColor = rule.obtenerColor(tirada);
				System.out.println("El resultado es: " + tirada + " de color " + resultadoColor);

				boolean victoriaDocena = rule.apostarDocena(tirada, opcionDocena);
				if (victoriaDocena == true) {
					System.out.println("Has ganado!");
					jugador.aumentoPorDocena(jugador.apuesta);
				} else {
					System.out.println("Has perdido!");
					jugador.decremento(jugador.apuesta);
				}
				System.out.println("Su nuevo saldo es: " + jugador.saldo);
			}
			case 6 -> {
				System.out.print("Adios mundo");
				System.out.println();
				System.out.println("...lavando el dinero sobrante :)");
				sistema = false;
			}
			}
		} while (sistema);
	}

}
