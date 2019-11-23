package co.web.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Bloques")
public class Bloque {
	@Id
	private String id;
	private String nombre;
	private String ubicacion;
	private String encargado;
	private String salones;
	private boolean active;

	
	public Bloque() {

	}

	public Bloque(String nombre, String ubicacion, String encargado, String salones) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.encargado = encargado;
		this.salones = salones;

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

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public String getSalones() {
		return salones;
	}

	public void setSalones(String salones) {
		this.salones = salones;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	@Override
	public String toString() {
		return "Bloque [id=" + id + ",nombre=" + nombre + ", ubicacion=" + ubicacion + ",encargado =" + encargado+ ",salones=" + salones + ", active="+active+"]";
	}

}
