package com.test.arydias.crudClientCity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.test.arydias.crudClientCity.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>  {
	
	public List<Cliente> findByNome(@Param("nome") String nome);
	
}
