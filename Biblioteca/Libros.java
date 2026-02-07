package Biblioteca;
public class Libros {
	
	public int codigoLibro;
	private String titulo;
	private String autor;
	private int fechaPublicacion;
	private Boolean disponibilidad;
	
	public void Libro(String titulo, String autor, int fechaPublicacion){
		this.titulo = titulo;
		this.autor = autor;
		this.fechaPublicacion = fechaPublicacion;
	}
	
	public int getCodigoLibro() {
		return codigoLibro;
	}
	public void setCodigoLibro(int codigoLibro) {
		this.codigoLibro = codigoLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(int fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	public Boolean getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(Boolean disponibilidad) {
		disponibilidad = disponibilidad;
	}
	public void verificadorFecha(int fechaPublicacion) {
		int fechaActual = java.time.Year.now().getValue(); //que la fecha la de el usuario
		if (fechaPublicacion >= 500 && fechaPublicacion <= (fechaActual + 1)) {
            this.fechaPublicacion = fechaPublicacion;
            System.out.println("Año guardado correctamente: " + this.fechaPublicacion);
        } else {
            System.out.println("Error: El año " + fechaPublicacion + " no es coherente.");
         
        }
	}
	@Override
	public String toString() {
		return "Libros [codigoLibro=" + codigoLibro + ", titulo=" + titulo + ", autor=" + autor + ", fechaPublicacion="
				+ fechaPublicacion + ", disponibilidad=" + disponibilidad + "]";
	}
		

}
