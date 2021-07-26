package com.init.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.init.app.models.LibroModel;

@Repository
public interface LibroRepository extends CrudRepository<LibroModel,Long>{

}
