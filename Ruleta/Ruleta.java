package Ruleta;

public class Ruleta {

	public int bolita;
	public String ROJO = "rojo";
	public String NEGRO = "negro";
	public String VERDE = "verde";
	private String[] COLORES = { VERDE, ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, NEGRO, ROJO,
			NEGRO, ROJO, NEGRO, ROJO, NEGRO, ROJO, ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO,
			NEGRO, ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, ROJO };
	private String color = COLORES[bolita];
	
	
	public String obtenerColor(int bolita) {
	    if (bolita >= 0 && bolita < COLORES.length) {
	        return COLORES[bolita];
	    }
	    return null;
	}
		
	public int bolita() {
		this.bolita= (int) (Math.random()* 37);
		return bolita;
	}
	
	public boolean apostarDocena(int bolita, int docenaApostada) {
		
		switch (docenaApostada) {
		case 1 -> {
			if (bolita >= 1 && bolita <= 12) {
			return true;
		}
		}
		case 2 -> {
			if (bolita >= 13 && bolita <= 24) {
				return true;
			}
		}
		case 3 -> {
			if (bolita >= 25 && bolita <= 36) {
				return true;
			}
		}
		
		}
		return false;
	}
	
	public boolean apostarFila (int filaApostada) {
			
		switch(filaApostada) {
			case 1 -> {
				if (this.bolita != 0 && this.bolita % 3 == 1) {
					System.out.println("Has ganado!");
					return true;
				} else {
				System.out.println("Has perdido!");
				}
				break;
			}
			case 2 -> {
				if (this.bolita != 0 && this.bolita % 3 == 2) {
					System.out.println("Has ganado!");
					return true;
				} else {
					System.out.println("Has perdido!");
				}
				break;
			}
			case 3 -> {
				if (this.bolita != 0 && this.bolita % 3 == 0) {
					System.out.println("Has ganado!");
					return true;
				} else {
					System.out.println("Has perdido!");
				}
				break;
			}
			default->
		        System.out.println("Opción no válida.");
		        
		}
		
		return false;
	}
	
	
	public boolean apostarNumero (int bolita, int numeroApostado) {
		if (numeroApostado == bolita) {
			return true;
		}
		return false;
	}
	
	
	public boolean apostarPar(int bolita) {
		
			if (bolita %2 ==0) {
				return true;
			}
				return false;
	}
	
	public boolean apostarImpar(int bolita) {
		if (bolita %2 !=0) {
			return true;
			
			}
		else {
			return false;
		}
		
	}

		
	}
	

