package co.web.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Facultades")
public class Facultad {
	@Id
	private String id;

	private String name;
	private String bloque;
	private boolean active;

	public Facultad() {
	}

	public Facultad(String name, String bloque) {
		this.name = name;
		this.bloque = bloque;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBloque() {
		return bloque;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Facultad [id=" + id + ", name=" + name + ", bloque=" + bloque + ", active=" + active + "]";
	}
}
