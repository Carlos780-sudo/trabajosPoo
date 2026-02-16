package blackJack;

import java.util.Scanner;

public class InterfazBlackJack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		JuegoBlackJack partida = new JuegoBlackJack();
		partida.nuevoIngreso(sc);
		partida.nuevoJuego(sc);
	}
}