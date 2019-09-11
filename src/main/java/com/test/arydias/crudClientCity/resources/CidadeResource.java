package com.test.arydias.crudClientCity.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.arydias.crudClientCity.models.Cidade;
import com.test.arydias.crudClientCity.repository.CidadeRepository;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {

	private CidadeRepository cr;
	
	CidadeResource(CidadeRepository cidadeRepository) {
		this.cr = cidadeRepository;
	}
	
	@GetMapping(produces="application/json")
	public @ResponseBody List<Cidade> findAll(){
		return cr.findAll();
	}
	
	@GetMapping(produces="application/json",
			    path = {"/getEstado/{estado}"})
	public @ResponseBody List<Cidade> findByState(@PathVariable(value="estado") String estado){
		return cr.findByEstado(estado);
	}
	
	@GetMapping(produces="application/json",
		        path = {"getNome/{nome}"})
	public @ResponseBody Cidade findByName(@PathVariable(value="nome") String nome) {
		return cr.findByNome(nome);
	}
	
	@PostMapping()
	public Cidade cadastraCidade(@RequestBody @Valid Cidade cidade) {
		return cr.save(cidade);
	}
	
	@DeleteMapping()
	public Cidade deletaCidade(@RequestBody Cidade cidade) {
		cr.delete(cidade);
		return cidade;
	}
}
