package com.soaint.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.soaint.controller.CrudTarea;
import com.soaint.entities.TarTarea;
import com.soaint.model.Response;
import com.soaint.model.Tarea;
import com.soaint.repository.TareaRepository;
import com.soaint.service.TareaService;
import com.soaint.util.MappingTarea;
import com.soaint.util.Util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TareaServiceImpl implements TareaService {
	@Autowired
	TareaRepository tareaRepository;
	
	@Autowired
	MappingTarea mappingTarea;
	
	@Autowired
	ModelMapper modelMapper;
	
	RestTemplate restTemplate= new RestTemplate();
	
	Map<String,Long> mapaTiempo= null;
	
	
	public ResponseEntity<Response> listarTareas() {
		Iterable<TarTarea> iterableList= null;
		List<Tarea> tareaList=null;
		mapaTiempo= new HashMap<>();
		Util.measureTime(mapaTiempo);
		try{
			log.info("Se obtiene listado de tareas");
			iterableList=tareaRepository.findAll();
			tareaList=StreamSupport.stream(iterableList.spliterator(), false).map(e ->modelMapper.map(e, Tarea.class)).collect(Collectors.toList());
		}catch(Exception e) {
			log.error("Ocurrió un error: ",e);
			Util.measureTime(mapaTiempo);
			return ResponseEntity.ok(new Response(1,"NO OK",mapaTiempo.get("executeTime"),null));
			
		}
		log.info("fin obtiene listado de tareas");
		Util.measureTime(mapaTiempo);
		return ResponseEntity.ok(new Response(0,"OK",mapaTiempo.get("executeTime"),tareaList));
	}
	
	public ResponseEntity<Response<Tarea>> tareaPorId(Integer idTarea) {
		Optional<TarTarea> tareaEntity= null;
		Tarea tarea=null;
		mapaTiempo= new HashMap<>();
		Util.measureTime(mapaTiempo);
		try{
			log.info("Se obtiene tarea por id");
			tareaEntity=tareaRepository.findById(idTarea);
			if (tareaEntity.isPresent()) {
			tarea=	modelMapper.map(tareaEntity.get(), Tarea.class);
			}else {
				Util.measureTime(mapaTiempo);
				return ResponseEntity.ok(new Response(1,"NO OK",mapaTiempo.get("executeTime"),null));
			}
		}catch(Exception e) {
			log.error("Ocurrió un error: ",e);
			Util.measureTime(mapaTiempo);
			return ResponseEntity.ok(new Response(1,"NO OK",mapaTiempo.get("executeTime"),null));
			
		}
		log.info("fin obtiene listado de tareas");
		Util.measureTime(mapaTiempo);
		return ResponseEntity.ok(new Response(0,"OK",mapaTiempo.get("executeTime"),tarea));
	}
	
	public ResponseEntity<Response> insertarTarea(Tarea tarea) {
		TarTarea tareaEntity=null;
		mapaTiempo= new HashMap<>();
		Util.measureTime(mapaTiempo);
		try{
			log.info("Se inserta tarea");
			ResponseEntity<Response<Tarea>> tareaResponse=this.tareaPorId(tarea.getIdTarea());
			if (tareaResponse.getBody()!=null && tareaResponse.getBody().getResponseCode()==0) {
				Util.measureTime(mapaTiempo);
				log.info("fin inserta tarea");
				return ResponseEntity.ok(new Response(0,"OK",mapaTiempo.get("executeTime"),"La tarea ya existe"));
			}else {
				tareaEntity=mappingTarea.modelToEntity(tarea);
				tareaRepository.save(tareaEntity);
			}
		}catch(Exception e) {
			log.error("Ocurrió un error: ",e);
			Util.measureTime(mapaTiempo);
			return ResponseEntity.ok(new Response(1,"NO OK",mapaTiempo.get("executeTime"),null));
			
		}
		Util.measureTime(mapaTiempo);
		log.info("fin inserta tarea");
		return ResponseEntity.ok(new Response(0,"OK",mapaTiempo.get("executeTime"),tareaEntity.getTarId()));
	}
	
	public ResponseEntity<Response> eliminarTarea(Integer idTarea) {
		TarTarea tareaEntity=null;
		mapaTiempo= new HashMap<>();
		Util.measureTime(mapaTiempo);
		try{
			log.info("Se elimina tarea");
			ResponseEntity<Response<Tarea>> tareaResponse=this.tareaPorId(idTarea);
			if (tareaResponse.getBody()!=null && tareaResponse.getBody().getResponseCode()==0) {
				tareaEntity=mappingTarea.modelToEntity(tareaResponse.getBody().getResult());
				tareaRepository.delete(tareaEntity);
				Util.measureTime(mapaTiempo);
				log.info("fin elimina tarea");
				return ResponseEntity.ok(new Response(0,"OK",mapaTiempo.get("executeTime"),tareaEntity.getTarId()));
			}else {
				Util.measureTime(mapaTiempo);
				log.info("fin elimina tarea");
				return ResponseEntity.ok(new Response(1,"NO OK",mapaTiempo.get("executeTime"),null));		
			}
		}catch(Exception e) {
			log.error("Ocurrió un error: ",e);
			Util.measureTime(mapaTiempo);
			log.info("fin elimina tarea");
			return ResponseEntity.ok(new Response(1,"NO OK",mapaTiempo.get("executeTime"),null));
		}
	}

	
	public ResponseEntity<Response> actualizarTarea(Tarea tarea) {
		TarTarea tareaEntity=null;
		mapaTiempo= new HashMap<>();
		Util.measureTime(mapaTiempo);
		try{
			log.info("Se actualiza tarea");
			tareaEntity=mappingTarea.modelToEntity(tarea);
			tareaRepository.save(tareaEntity);
		}catch(Exception e) {
			log.error("Ocurrió un error: ",e);
			Util.measureTime(mapaTiempo);
			return ResponseEntity.ok(new Response(1,"NO OK",mapaTiempo.get("executeTime"),null));
			
		}
		Util.measureTime(mapaTiempo);
		log.info("fin actualiza tarea");
		return ResponseEntity.ok(new Response(0,"OK",mapaTiempo.get("executeTime"),tareaEntity.getTarId()));
	}

}
