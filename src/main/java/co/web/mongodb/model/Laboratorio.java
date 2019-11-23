package co.web.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Laboratorios")
public class Laboratorio {

	@Id
	private String id;
	private String nombre;
	private String tipo_laboratorio;
	private String salon;
	private boolean disponibilidad;

	public Laboratorio() {

	}

	public Laboratorio(String nombre, String tipo_laboratorio, String salon) {
		this.nombre = nombre;
		this.tipo_laboratorio = tipo_laboratorio;
		this.salon = salon;
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

	public String getTipo_laboratorio() {
		return tipo_laboratorio;
	}

	public void setTipo_laboratorio(String tipo_laboratorio) {
		this.tipo_laboratorio = tipo_laboratorio;
	}

	public String getSalon() {
		return salon;
	}

	public void setSalon(String salon) {
		this.salon = salon;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	@Override
	public String toString() {
		return "Laboratorio[id=" + id + ", nombre=" + nombre + ",tipo_laboratotio=" + tipo_laboratorio + ",salon="
				+ salon + ",disponibilidad=" + disponibilidad + "]";
	}

}
