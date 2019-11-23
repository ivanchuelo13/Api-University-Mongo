package co.web.mongodb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.web.mongodb.model.*;
import co.web.mongodb.repositorio.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FacultadController {

	@Autowired
	FacultadRepository repository;
	@Autowired
	BloqueRepository repositorybloque;
	@Autowired
	LaboratorioRepository repositoryLab;

	// METODOS PARA CONSULTAR GETSS GENERALES
	@GetMapping("/laboratorios")
	public List<Laboratorio> getAllLab() {
		System.out.println("Get Labs OP...");
		List<Laboratorio> lab = new ArrayList<>();
		repositoryLab.findAll().forEach(lab::add);
		return lab;
	}

	@GetMapping("/bloques")
	public List<Bloque> getAllBloques() {
		System.out.println("Get all Bloques Op...");
		List<Bloque> bloques = new ArrayList<>();
		repositorybloque.findAll().forEach(bloques::add);
		return bloques;
	}

	@GetMapping("/facultades")
	public List<Facultad> getAllCustomers() {
		System.out.println("Get all Facultades OP...");
		List<Facultad> facultades = new ArrayList<>();
		repository.findAll().forEach(facultades::add);
		return facultades;
	}

	// METODOS POST PARA INSERTAR LOS DATOS
	@PostMapping("/laboratorios/create")
	public Laboratorio postLab(@RequestBody Laboratorio lab) {
		Laboratorio _lab = repositoryLab
				.save(new Laboratorio(lab.getNombre(), lab.getTipo_laboratorio(), lab.getSalon()));
		return _lab;
	}

	@PostMapping("/bloques/create")
	public Bloque postBloque(@RequestBody Bloque bloque) {
		Bloque _bloque = repositorybloque.save(
				new Bloque(bloque.getNombre(), bloque.getUbicacion(), bloque.getEncargado(), bloque.getSalones()));
		return _bloque;
	}

	@PostMapping("/facultades/create")
	public Facultad postFacultad(@RequestBody Facultad facultad) {

		Facultad _facultad = repository.save(new Facultad(facultad.getNombre(), facultad.getDirector(),
				facultad.getTelefono(), facultad.getFundacion()));
		return _facultad;
	}

	// METODOS PARA ELIMINAR POR ID
	@DeleteMapping("/laboratorios/{id}")
	public ResponseEntity<String> deleteLab(@PathVariable("id") String id) {
		System.out.println("Delete laboratorio Op with ID = " + id + "...");
		repositoryLab.deleteById(id);
		return new ResponseEntity<>("Laboratorio eliminado jeje!", HttpStatus.OK);
	}

	@DeleteMapping("/bloques/{id}")
	public ResponseEntity<String> deleteBloques(@PathVariable("id") String id) {
		System.out.println("Delete bloques with ID = " + id + "...");
		repositorybloque.deleteById(id);
		return new ResponseEntity<>("Bloque eliminado jeje!", HttpStatus.OK);
	}

	@DeleteMapping("/facultades/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") String id) {
		System.out.println("Delete Customer with ID = " + id + "...");

		repository.deleteById(id);

		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}

	// DANGER METODOS PARA ELIMINAR TODA UNA TABLA
	@DeleteMapping("/laboratorios/delete")
	public ResponseEntity<String> deleteAllLab() {
		System.out.println("Delete ALL Laboratorios :v...");
		repositoryLab.deleteAll();
		return new ResponseEntity<>("All laboratorios eliminados D:!", HttpStatus.OK);
	}

	@DeleteMapping("/bloques/delete")
	public ResponseEntity<String> deleteAllBloques() {
		System.out.println("Delete ALL Bloques :v...");
		repositorybloque.deleteAll();
		return new ResponseEntity<>("All bloques eliminados D:!", HttpStatus.OK);
	}

	@DeleteMapping("/facultades/delete")
	public ResponseEntity<String> deleteAllCustomers() {
		System.out.println("Delete All Customers...");

		repository.deleteAll();

		return new ResponseEntity<>("All customers have been deleted! D:", HttpStatus.OK);
	}

	// METODOS PARA BUSCAR POR ID
	@GetMapping("/bloques/{id}")
	public Optional<Bloque> findByblock(@PathVariable("id") String id) {
		System.out.println("Get bloque por ID OP...");
		Optional<Bloque> bloque = repositorybloque.findById(id);
		return bloque;
	}

	@GetMapping("/facultades/{id}")
	public Optional<Facultad> findByAge(@PathVariable("id") String id) {
		System.out.println("Get Faucltad por ID OP...");
		Optional<Facultad> facultad = repository.findById(id);
		return facultad;
	}

	@GetMapping("/laboratorios/{id}")
	public Optional<Laboratorio> findByLab(@PathVariable("id") String id) {
		System.out.println("Get Lab por ID OP...");
		Optional<Laboratorio> lab = repositoryLab.findById(id);
		return lab;
	}

	
	//METODOS PARA MODIFICAR DATOS 
	@PutMapping("/bloques/{id}")
	public ResponseEntity<Bloque> updateBloque(@PathVariable("id") String id, @RequestBody Bloque bloque) {
		System.out.println("Update Bloque with ID = " + id + "...");

		Optional<Bloque> bloqueData = repositorybloque.findById(id);

		if (bloqueData.isPresent()) {
			Bloque _bloque = bloqueData.get();
			_bloque.setActive(bloque.isActive());
			_bloque.setNombre(bloque.getNombre());
			_bloque.setEncargado(bloque.getEncargado());
			_bloque.setSalones(bloque.getSalones());
			_bloque.setUbicacion(bloque.getUbicacion());
			return new ResponseEntity<>(repositorybloque.save(_bloque), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/facultades/{id}")
	public ResponseEntity<Facultad> updateFacultad(@PathVariable("id") String id, @RequestBody Facultad facultad) {
		System.out.println("Update Customer with ID = " + id + "...");

		Optional<Facultad> facultadData = repository.findById(id);

		if (facultadData.isPresent()) {
			Facultad _facultad = facultadData.get();
			
			_facultad.setNombre(facultad.getNombre());
			_facultad.setDirector(facultad.getDirector());
			_facultad.setTelefono(facultad.getTelefono());
			_facultad.setFundacion(facultad.getFundacion());
			return new ResponseEntity<>(repository.save(_facultad), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/laboratorios/{id}")
	public ResponseEntity<Laboratorio> updateLab(@PathVariable("id") String id, @RequestBody Laboratorio lab) {
		System.out.println("Update Lab with ID = " + id + "...");

		Optional<Laboratorio> labData = repositoryLab.findById(id);

		if (labData.isPresent()) {
			Laboratorio _lab = labData.get();
			_lab.setDisponibilidad(lab.isDisponibilidad());
			_lab.setNombre(lab.getNombre());
			_lab.setTipo_laboratorio(lab.getTipo_laboratorio());
			_lab.setSalon(lab.getSalon());
			return new ResponseEntity<>(repositoryLab.save(_lab), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
