package com.init.app.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.init.app.models.LibroModel;
import com.init.app.repositories.LibroRepository;

@Service
public class LibroService {
	@Autowired
	LibroRepository libroRepository;
	/*GET -> /libros -> obtener todos los libros*/
	public ArrayList<LibroModel> obtenerLibros(){
		ArrayList<LibroModel> listado = (ArrayList<LibroModel>)libroRepository.findAll();
		listado.removeIf(l -> l.getActivo() == false);
		return listado;
	}
	/*GET -> /libros/{id}  -> obtener un libro*/
	public Optional<LibroModel> obtenerLibro(Long id) {
		return libroRepository.findById(id);
	}
	/*POST -> /libros -> crear libro -> BODY*/
	public LibroModel guardarLibro(LibroModel libro) {	
		return libroRepository.save(libro);
	}
	/*DELETE -> /libros/{id}  -> Borrar un libro (cambiar activo a false)*/
	public String borrarLibro(Long id) {
		Optional<LibroModel> libro = libroRepository.findById(id);
	
		if(libro.isPresent()) {
			libro.get().setActivo(false);
			libroRepository.save(libro.get());
			return "Libro borrado";
		}
		return "ERROR. No se encontro el libro en la base de datos";
	}
}
