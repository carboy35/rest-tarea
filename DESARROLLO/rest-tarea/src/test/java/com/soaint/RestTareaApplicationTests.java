package com.soaint;
//package com.soaint;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.soaint.controller.CrudTarea;
import com.soaint.model.Response;
import com.soaint.model.Tarea;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

@SpringBootTest
class RestTareaApplicationTests {
	@Autowired
	CrudTarea crudTarea;
	

	@Test
	void testGetAll() {
		ResponseEntity<Response> response=	crudTarea.listarTareas();
		assertEquals(response.getBody().getResponseCode(),0);
	}
	
	@Test
	void testPost() {
		Tarea tarea=null;
		tarea = new Tarea();
		tarea.setIdTarea(1);
		tarea.setDescripcion("prueba tarea");
		tarea.setFechaCreacion(new Date());
		tarea.setVigente(true);
		
		ResponseEntity<Response> response=	crudTarea.agregarTarea(tarea);
		assertEquals(response.getBody().getResponseCode(),0);
		
		
		// probar caso sin un parametro
		tarea = new Tarea();
	//	tarea.setIdTarea(1);
		tarea.setDescripcion("prueba tarea");
		tarea.setFechaCreacion(new Date());
		tarea.setVigente(true);
		 response=	crudTarea.agregarTarea(tarea);
		assertEquals(response.getBody().getResponseCode(),1);
	}
	
	@Test
	void testUpdate() {
		Tarea tarea=null;
		tarea = new Tarea();
		tarea.setIdTarea(1);
		tarea.setDescripcion("prueba tarea");
		tarea.setFechaCreacion(new Date());
		tarea.setVigente(true);
		
		ResponseEntity<Response> response=	crudTarea.actualizarTarea(tarea);
		assertEquals(response.getBody().getResponseCode(),0);
	}
	
	
	@Test
	void testDelete() {
		
		
		ResponseEntity<Response> response=	crudTarea.eliminarTarea(1);
		assertEquals(response.getBody().getResponseCode(),0);
	}
	
}
