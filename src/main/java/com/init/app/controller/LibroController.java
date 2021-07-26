package com.init.app.controller;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.init.app.models.LibroModel;
import com.init.app.services.LibroService;

@RestController
@RequestMapping("/libros")
public class LibroController {
	@Autowired
	LibroService libroService;
	/*GET -> /libros -> obtener todos los libros*/
	@GetMapping()
	public ArrayList<LibroModel> obtenerLibros(){
		return libroService.obtenerLibros();
	}
	/*GET -> /libros/{id}  -> obtener un libro*/
	@GetMapping(path="/{id}")
	public Optional<LibroModel> obtenerLibro(@PathVariable("id") Long id) {
		return libroService.obtenerLibro(id);
	}
	/*POST -> /libros -> crear libro -> BODY*/
	@PostMapping()
	public LibroModel guardarLibro(@RequestBody LibroModel libro) {
		return libroService.guardarLibro(libro);
	}
	/*DELETE -> /libros/{id}  -> Borrar un libro (cambiar activo a false)*/
	@DeleteMapping(path="/{id}")
	public String borrarLibro(@PathVariable("id") Long id) {
		return libroService.borrarLibro(id);
	}
}
