package com.clientes.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.apirest.models.Cliente;
import com.clientes.apirest.repository.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Cadastro de Clientes")
@CrossOrigin(origins="*")
public class ClienteController {
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping(value="/clientes")
	@ApiOperation(value="Retorna uma lista de clientes")
	public List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}
	
	@GetMapping(value="/cliente/{id}")
	@ApiOperation(value="Retorna um cliente pelo id")
	public Cliente pegarClientePeloId(@PathVariable(value="id")long id){
		return clienteRepository.findById(id);
	}
	
	@PostMapping(value="/cliente")
	@ApiOperation(value="Salva um cliente no banco de dados")
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping(value="/cliente")
	@ApiOperation(value="Remove um cliente do banco dados")
	public void removerCliente(@RequestBody Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}
	
	@PutMapping(value="/cliente")
	@ApiOperation(value="Altera os dados de um cliente no banco de dados")
	public Cliente atualizarCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
