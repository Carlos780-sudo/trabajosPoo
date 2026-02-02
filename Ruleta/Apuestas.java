package Ruleta;

public class Apuestas {

	public int saldo;
	public int apuesta;
	public boolean victora = false;

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

	public boolean isVictora() {
		return victora;
	}

	public void setVictora(boolean victora) {
		this.victora = victora;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public int getApuesta() {
		return apuesta;
	}

	public void setApuesta(int apuesta) {
		this.apuesta = apuesta;
	}

	private final int MULTIPLICADOR_NUMERO = 36;
	private final int MULTIPLICADOR_COLOR = 2;
	private final int MULTIPLICADOR_PAR_IMPAR = 2;
	private final int MULTIPLICADOR_FILA = 3;
	private final int MULTIPLICADOR_DOCENA = 2;

	public int apuesta(int apuesta) {
		this.saldo = apuesta - saldo;
		return saldo;
	}

	public int decremento(int apuesta) {
		this.saldo = saldo - apuesta;
		return saldo;
	}

	public int aumentoPorNumero(int apuesta) {
		this.saldo = saldo + apuesta * MULTIPLICADOR_NUMERO;

		return saldo;
	}

	public int aumentoColor(int apuesta) {
		this.saldo = saldo + apuesta * MULTIPLICADOR_COLOR;
		return saldo;
	}

	public int aumentoPorPar_Impar(int apuesta) {

		this.saldo = saldo + apuesta * MULTIPLICADOR_PAR_IMPAR;

		return saldo;
	}

	public int aumentoPorFila(int apuesta) {

		this.saldo = saldo + apuesta * MULTIPLICADOR_FILA;

		return saldo;
	}

	public int aumentoPorDocena(int apuesta) {

		this.saldo = saldo + apuesta * MULTIPLICADOR_DOCENA;
		return saldo;
	}
}