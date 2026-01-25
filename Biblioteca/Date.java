package Biblioteca;

public class Date {

	private int dia;
	private int mes;
	private int year;
	
	public Date() {
		this.dia = dia;
		this.mes = mes;
		this.year = year;
	}
	public int getDia() {
		return this.dia;
	}
	
	public void setDia(int nuevoDia) {
		if (nuevoDia > 31 || nuevoDia < 1 ) return;
		this.dia= nuevoDia;
	}
	
	public String toString() {
		return this.getDia()+ "/" + this.mes+ "/"+ this.year;
	}
}
