package com.init.app.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.app.models.AutorModel;
import com.init.app.repositories.AutorRepository;

@Service
public class AutorService {
	@Autowired
	AutorRepository autorRepository;
	//GET -> /autores -> se muestra listado de autores
	public ArrayList<AutorModel> obtenerAutores(){
		ArrayList<AutorModel> listado = (ArrayList<AutorModel>)autorRepository.findAll();
		listado.removeIf(l -> l.getActivo() == false);
		return listado;
	}
	//GET -> /autores/{id} -> se muestra un autor
	public Optional<AutorModel> obtenerAutor(Long id) {
		return autorRepository.findById(id);
	}
	//DELETE -> /autores/{id} -> se "borra" un autor (cambiar activo a false)
	public String borrarAutor(Long id) {
		Optional<AutorModel> autor = autorRepository.findById(id);
	
		if(autor.isPresent()) {
			autor.get().setActivo(false);
			autorRepository.save(autor.get());
			return "Autor borrado";
		}
		return "ERROR. No se encontro el autor en la base de datos";
	}

}
