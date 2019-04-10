package com.example.back.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.entity.Clientes;
import com.example.back.repository.ClienteRepository;
import com.example.back.service.ClienteService;

@RestController
@RequestMapping()
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {
	@Autowired //injectar
	@Qualifier("repo")
	private ClienteRepository repo;
	
	@Autowired
	@Qualifier("serv")
	ClienteService serv;
	
	@PutMapping("/clientes")
	public boolean AgregarClientes(@RequestBody @Valid Clientes cli) {
		return serv.crear(cli);
	}
	
	@PostMapping("/clientes")
	public boolean ActualizarClientes(@RequestBody @Valid Clientes cli) {
		return serv.actualizar(cli);
	}
	
	@DeleteMapping("/clientes/{codigo}")
	public boolean borrarClientes(@PathVariable("codigo") Integer codigo) {
		return serv.borrar(codigo);
	}
	
	@GetMapping("/clientes")
	public List<Clientes> getClientes(){
		return repo.findAll();
	}
	
	@GetMapping(value="/clientes/{codigo}")
	public Clientes findByCliente(@PathVariable("codigo") Integer codigo) {
		return repo.findByCodigo(codigo);
	}
}
