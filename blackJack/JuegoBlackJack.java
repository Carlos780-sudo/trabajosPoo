package blackJack;

import java.util.Scanner;
import Ruleta.SaldoNegativoExepcion;
public class JuegoBlackJack {

	Mazo cartasJuego = new Mazo();
	Apuestas jugadorApuesta = new Apuestas();
	public boolean entradaValida = false;
	private int puntosJugador = 0;
	private int puntosCasa = 0;
	private final int numeroMaximo = 21;

	public void respuestaValida(String respuesta) throws SaldoNegativoExepcion {
		if (!respuesta.equalsIgnoreCase("SI") && !respuesta.equalsIgnoreCase("NO")) {
			throw new SaldoNegativoExepcion("ERROR: respuesta incorrecta responde con un SI/NO ");
		}
	}

	public void ganadorRonda(Scanner sc) {
		if (puntosJugador > numeroMaximo) {
			System.out.println("Te has pasado de 21! Has perdido esta ronda.");
			jugadorApuesta.decremento(jugadorApuesta.apuesta);
			System.out.println("Tu nuevo saldo es: " + jugadorApuesta.saldo);
			nuevaRonda(sc);
		} else if (puntosCasa > numeroMaximo || puntosJugador > puntosCasa) {
			System.out.println("Has ganado esta ronda.");
			jugadorApuesta.aumentoSaldo(jugadorApuesta.apuesta);
			System.out.println("Tu nuevo saldo es: " + jugadorApuesta.saldo);
			nuevaRonda(sc);
		} else if (puntosJugador < puntosCasa) {
			System.out.println("La casa gana.");
			jugadorApuesta.decremento(jugadorApuesta.apuesta);
			System.out.println("Tu nuevo saldo es: " + jugadorApuesta.saldo);
			nuevaRonda(sc);
		} else {
			System.out.println("¡Empate! nadie gana ");
			jugadorApuesta.empate(jugadorApuesta.apuesta);
			System.out.println("Tu nuevo saldo es: " + jugadorApuesta.saldo);
			nuevaRonda(sc);
		}
	}

	public void nuevaRonda(Scanner sc) {
		String respuesta = "";
		while (jugadorApuesta.saldo > 0) {
			do {
				try {
					System.out.println("Quieres iniciar otra ronda SI/NO");
					respuesta = sc.next();
					respuestaValida(respuesta);
					entradaValida = true;
				} catch (SaldoNegativoExepcion e) {
					System.out.println(e.getMessage());
				}
			} while (!entradaValida);
			entradaValida = false;
			if (respuesta.equalsIgnoreCase("si")) {
				nuevoJuego(sc);
			} else {
				System.out.println("Perdiste todo tu saldo.");
				break;
			}
		}
	}

	public void turnoJugador(Scanner sc) {
		String respuesta = "";
		while (puntosJugador < numeroMaximo) {
			do {
				try {
					System.out.println("quiere una nueva carta: SI/NO");
					respuesta = sc.next();
					respuestaValida(respuesta);
					entradaValida = true;
				} catch (SaldoNegativoExepcion e) {
					System.out.println(e.getMessage());
				}
			} while (!entradaValida);
			entradaValida = false;
			if (respuesta.equalsIgnoreCase("si")) {
				nuevaCartaJugador();
			} else {
				System.out.println("Te plantas con: " + puntosJugador);
				break;
			}
		}
	}

	public void turnoCasa() {
		if (puntosJugador <= numeroMaximo) {
			System.out.println("----Turno de la casa----");
			while (puntosCasa < 17) {
				nuevaCartaCasa();
			}
		}
	}

	public void nuevaCartaCasa() {

		Carta nuevaCarta = cartasJuego.repartirCarta();
		int nuevoValor = nuevaCarta.getValor();
		if (nuevaCarta.getNombre().contains("A") && puntosCasa + nuevoValor > numeroMaximo) {
			nuevoValor = 1;
		}
		puntosCasa += nuevoValor;
		System.out.println("la nueva carta de la casa es: " + nuevaCarta + " Puntos: " + puntosCasa);
	}

	public void nuevaCartaJugador() {
		Carta nuevaCarta = cartasJuego.repartirCarta();
		int nuevoValor = nuevaCarta.getValor();
		if (nuevaCarta.getNombre().contains("A") && puntosJugador + nuevoValor > numeroMaximo) {
			nuevoValor = 1;
		}
		puntosJugador += nuevoValor;
		System.out.println("la nueva es carta: " + nuevaCarta + " Puntos: " + puntosJugador);
	}

	public void nuevoPuntuaje() {
		this.puntosJugador = 0;
		this.puntosCasa = 0;
	}

	public void nuevoIngreso(Scanner sc) {
		do {
			try {
				System.out.println("-----bienvenido al Black Jack-----");
				System.out.print("Ingrese el saldo inical: ");
				int saldoInicial = sc.nextInt();
				jugadorApuesta.validarSaldo(saldoInicial);
				entradaValida = true;
			} catch (SaldoNegativoExepcion e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println("ERROR: Por favor, ingrese un número entero válido.");
	            sc.nextLine();
			}
		} while (!entradaValida);
		entradaValida = false;
	}

	public void nuevoJuego(Scanner sc) {
		System.out.println("Iniciando un nuevo juego...");
		nuevoPuntuaje();
		int saldo = jugadorApuesta.saldo;
		System.out.println("Su saldo es: " + saldo);
		do {
			try {
				System.out.print("¿Cuánto dinero quieres apostar?: ");
				int apuesta = sc.nextInt();
				jugadorApuesta.apuestaValida(apuesta);
				entradaValida = true;
			} catch (SaldoNegativoExepcion e) {
				System.out.println(e.getMessage());
			}

		} while (!entradaValida);
		entradaValida = false;
		cupier();
		turnoJugador(sc);
		turnoCasa();
		ganadorRonda(sc);

	}

	public void cupier() {
		System.out.println("barajando el mazo...");
		cartasJuego.barajarMazo();
		System.out.println("repartindo cartas...");
		nuevaCartaJugador();
		nuevaCartaJugador();
		System.out.println("Tu puntaje total: " + puntosJugador);
		nuevaCartaCasa();

	}
}
