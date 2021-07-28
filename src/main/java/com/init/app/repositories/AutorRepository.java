package com.init.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.init.app.models.AutorModel;

@Repository
public interface AutorRepository extends CrudRepository<AutorModel,Long>{

}
