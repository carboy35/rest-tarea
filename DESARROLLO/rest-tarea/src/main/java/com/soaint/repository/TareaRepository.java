package com.soaint.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.soaint.entities.TarTarea;


@Repository
public interface TareaRepository extends CrudRepository<TarTarea,Integer> {
	
//	@Query("SELECT u FROM Usuario u WHERE u.email= :email")
//	List<TarTarea> getByEmail(@Param("email") String email);

}
