package com.init.app.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.app.models.AutorModel;
import com.init.app.services.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {
	@Autowired
	AutorService autorService;
	//GET -> /autores -> se muestra listado de autores
	@GetMapping()
	public ArrayList<AutorModel> obtenerAutores(){
		return autorService.obtenerAutores();
	}
	//GET -> /autores/{id} -> se muestra un autor
	@GetMapping(path="/{id}")
	public Optional<AutorModel> obtenerAutor(@PathVariable("id") Long id) {
		return autorService.obtenerAutor(id);
	}
	//DELETE -> /autores/{id} -> se "borra" un autor (cambiar activo a false)
	@DeleteMapping(path="/{id}")
	public String borrarAutor(@PathVariable("id") Long id) {
		return autorService.borrarAutor(id);
	}
}
