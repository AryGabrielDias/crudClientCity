package com.test.arydias.crudClientCity.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.arydias.crudClientCity.models.Cliente;
import com.test.arydias.crudClientCity.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

	private ClienteRepository cr;
	
	ClienteResource(ClienteRepository clienteRepository) {
		this.cr = clienteRepository;
	}
	
	@GetMapping(produces="application/json")
	public @ResponseBody List<Cliente> findAll(){
		return cr.findAll();
	}
	
	@RequestMapping(produces="application/json",
			        path = {"getNome/{nome}"},
			        method = RequestMethod.GET)
	public @ResponseBody List<Cliente> findByNome(@PathVariable(value="nome") String nome){
		return cr.findByNome(nome);
	}
	
	
	@RequestMapping(produces="application/json",
					path = {"/{id}"},
					method = RequestMethod.GET)
	public @ResponseBody Cliente findById(@PathVariable(value="id") long id){
		
		Optional<Cliente> cliente = cr.findById(id);
		
		return cliente.get();
	}
	
	@PostMapping()
	public Cliente cadastraCliente(@RequestBody @Valid Cliente cliente) {
		return cr.save(cliente);
	}
	
	@DeleteMapping()
	public Cliente deletaCliente(@RequestBody @Valid Cliente cliente) {
		cr.delete(cliente);
		return cliente;
	}
}
