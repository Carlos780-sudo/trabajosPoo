package blackJack;

import Ruleta.SaldoNegativoExepcion;

public class Apuestas {

	public int saldo;
	public int apuesta;
	public boolean victora = false;

	
	public int empate(int apuesta) {
		this.saldo = saldo + apuesta;
		return saldo;
	}
	public int aumentoSaldo(int apuesta) {
		this.saldo = saldo + apuesta * 2;
		return saldo;
	}

	public int apuesta(int apuesta) {
		this.saldo = saldo - apuesta;
		return saldo;
		
	}

	public int decremento(int apuesta) {
		this.saldo = saldo - apuesta;
		return saldo;
	}
	
	public void validarSaldo(int saldo) throws SaldoNegativoExepcion {
		if (saldo < 0) {
			throw new SaldoNegativoExepcion("ERROR: no puede poner un saldo negativo");
		} else {
			this.saldo = saldo;
		}
	}

	public void apuestaValida(int apuesta) throws SaldoNegativoExepcion {
		if (apuesta > saldo) {
			throw new SaldoNegativoExepcion("ERROR: no puede apostar mas de lo que tiene");
		} else {
			this.apuesta = apuesta;
		}

	}
}
