package co.web.mongodb.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.web.mongodb.model.Laboratorio;;


public interface LaboratorioRepository extends MongoRepository<Laboratorio, String> {

}
