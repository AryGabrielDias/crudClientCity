package com.test.arydias.crudClientCity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.arydias.crudClientCity.models.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	public Cidade findByNome(@Param("nome") String nome);
	
	public List<Cidade> findByEstado(@Param("estado") String estado);

	
}
