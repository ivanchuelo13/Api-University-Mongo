package co.web.mongodb.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.web.mongodb.model.Bloque;

public interface BloqueRepository extends MongoRepository<Bloque, String> {

}
