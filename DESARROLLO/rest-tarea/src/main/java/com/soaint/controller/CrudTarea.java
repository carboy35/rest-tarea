package com.soaint.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.soaint.entities.TarTarea;
import com.soaint.model.Response;
import com.soaint.model.Tarea;
import com.soaint.repository.TareaRepository;
import com.soaint.service.TareaService;
import com.soaint.util.Util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/rest-tarea/tarea")
public class CrudTarea {
	@Autowired
	TareaRepository tareaRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	TareaService tareaService;
	
	
	RestTemplate restTemplate= new RestTemplate();
	Map<String,Long> mapaTiempo= null;
	@GetMapping
	public ResponseEntity<Response> listarTareas(){
		return tareaService.listarTareas();
	}
	
	@PostMapping
	public ResponseEntity<Response> agregarTarea(@Valid @RequestBody Tarea tarea){
		return tareaService.insertarTarea(tarea);
	}
	
	@DeleteMapping("/{idTarea}")
	public ResponseEntity<Response> eliminarTarea(@PathVariable("idTarea") Integer idTarea){
		return tareaService.eliminarTarea(idTarea);
	}
	
	@PutMapping
	public ResponseEntity<Response> actualizarTarea(@RequestBody Tarea tarea){
		return tareaService.actualizarTarea(tarea);
	}
	
//	Map<String,Long> mapaTiempo= null;
//	@SuppressWarnings("rawtypes")
//	@PostMapping
//	public ResponseEntity<Response> save(@RequestBody Usuarios usuario){
//		Usuario usuarioEntity= null;
//		mapaTiempo= new HashMap<>();
//		Util.measureTime(mapaTiempo);
//		try {
//			log.info("Se guarda usuario");
//			Usuario usuarioE=modelMapper.map(usuario, TarTarea.class);
//			usuarioEntity=usuarioRepository.save(usuarioE);
//		}catch(Exception e) {
//			Util.measureTime(mapaTiempo);
//			log.error("Ocurrió un error: ",e);
//			return ResponseEntity.ok(new Response(1,"NO OK",mapaTiempo.get("executeTime"),null));
//		}
//		Util.measureTime(mapaTiempo);
//		return ResponseEntity.ok(new Response(0,"OK",mapaTiempo.get("executeTime"),ResultUser.builder().registerCount(usuarioEntity.getId()).build()));
//	}
//	@GetMapping("/all")
//	public ResponseEntity<Response> getAll(){
//		List<Usuario> usuarioList= null;
//		List<Usuarios> usuariosModelList= null;
//		mapaTiempo= new HashMap<>();
//		Util.measureTime(mapaTiempo);
//		try{
//			log.info("Se obtiene usuarios registrados");
//			usuarioList=(List<Usuario>)usuarioRepository.findAll();
//			usuariosModelList=usuarioList.stream().map(e ->modelMapper.map(e, Usuarios.class)).collect(Collectors.toList());
//			
//		}catch(Exception e) {
//			log.error("Ocurrió un error: ",e);
//			Util.measureTime(mapaTiempo);
//			return ResponseEntity.ok(new Response(1,"NO OK",mapaTiempo.get("executeTime"),null));
//			
//		}
//		Util.measureTime(mapaTiempo);
//		return ResponseEntity.ok(new Response(0,"OK",mapaTiempo.get("executeTime"),usuariosModelList));
//	}
//	
//	@GetMapping("/email/{data}")
//	public ResponseEntity<Response> getByEmail(@PathVariable String data){
//		List<Usuario> usuarioList= null;
//		List<Usuarios> usuariosModelList= null;
//		mapaTiempo= new HashMap<>();
//		Util.measureTime(mapaTiempo);
//		try{
//			log.info("Se obtiene usuarios registrados");
//			usuarioList=(List<Usuario>)usuarioRepository.getByEmail(data);
//			usuariosModelList=usuarioList.stream().map(e ->modelMapper.map(e, Usuarios.class)).collect(Collectors.toList());
//			
//		}catch(Exception e) {
//			log.error("Ocurrió un error: ",e);
//			Util.measureTime(mapaTiempo);
//			return ResponseEntity.ok(new Response(1,"NO OK",mapaTiempo.get("executeTime"),null));
//			
//		}
//		Util.measureTime(mapaTiempo);
//		return ResponseEntity.ok(new Response(0,"OK",mapaTiempo.get("executeTime"),usuariosModelList));
//	}

}
