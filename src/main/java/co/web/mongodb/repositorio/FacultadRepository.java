package co.web.mongodb.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.web.mongodb.model.Facultad;

public interface FacultadRepository extends MongoRepository<Facultad, String>{
	//List<Facultad> findByAge(int age);
}
