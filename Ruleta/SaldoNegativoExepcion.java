package Ruleta;

public class SaldoNegativoExepcion extends Exception {
	
	public SaldoNegativoExepcion() {
        super();
    }
	public SaldoNegativoExepcion(String mensaje) {
        super(mensaje);
    }

}
