package co.web.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Facultades")
public class Facultad {
	@Id
	private String id;

	private String nombre;
	private String director;
	private String telefono;
	private String fundacion;

	public Facultad() {
	}

	public Facultad(String nombre , String director , String telefono , String fundacion) {
		this.nombre = nombre;
		this.director = director;
		this.telefono = telefono;
		this.fundacion = fundacion;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFundacion() {
		return fundacion;
	}

	public void setFundacion(String fundacion) {
		this.fundacion = fundacion;
	}

	@Override
	public String toString() {
		return "Facultad [id=" + id + ", nombre=" + nombre + ", director=" + director + ", telefono=" + telefono + ", fundacion=" + fundacion + " ]";
	}
}
