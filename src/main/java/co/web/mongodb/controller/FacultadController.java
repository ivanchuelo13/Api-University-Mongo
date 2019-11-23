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

import co.web.mongodb.model.Bloque;
import co.web.mongodb.model.Facultad;
import co.web.mongodb.repositorio.BloqueRepository;
import co.web.mongodb.repositorio.FacultadRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FacultadController {

	@Autowired
	FacultadRepository repository;
	@Autowired
	BloqueRepository repositorybloque;

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

	@PostMapping("/bloques/create")
	public Bloque postBloque(@RequestBody Bloque bloque) {
		Bloque _bloque = repositorybloque.save(new Bloque(bloque.getNombre(), bloque.getUbicacion(), bloque.getEncargado(), bloque.getSalones()));
		return _bloque;
	}

	@PostMapping("/facultades/create")
	public Facultad postFacultad(@RequestBody Facultad facultad) {

		Facultad _facultad = repository.save(new Facultad(facultad.getNombre(), facultad.getDirector(),facultad.getTelefono(), facultad.getFundacion()));
		return _facultad;
	}
	
	@DeleteMapping("/bloques/{id}")
	public ResponseEntity<String> deleteBloques(@PathVariable("id") String id) {
		System.out.println("Delete bloqyues with ID = " + id + "...");
		repositorybloque.deleteById(id);
		return new ResponseEntity<>("Bloque eliminado jeje!", HttpStatus.OK);
	}

	@DeleteMapping("/facultades/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") String id) {
		System.out.println("Delete Customer with ID = " + id + "...");

		repository.deleteById(id);

		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}
	
	
	@DeleteMapping("/bloques/delete")
	public ResponseEntity<String> deleteAllBloques() {
		System.out.println("Delete ALL Bloques :v...");

		repositorybloque.deleteAll();

		return new ResponseEntity<>("All bloques eliminados!", HttpStatus.OK);
	}
	

	@DeleteMapping("/facultades/delete")
	public ResponseEntity<String> deleteAllCustomers() {
		System.out.println("Delete All Customers...");

		repository.deleteAll();

		return new ResponseEntity<>("All customers have been deleted!", HttpStatus.OK);
	}
	
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
}
