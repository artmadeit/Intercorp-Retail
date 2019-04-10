package com.example.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.back.entity.Clientes;
import com.example.back.repository.ClienteRepository;

@Service("serv")
public class ClienteService {
	@Autowired //injectar
	@Qualifier("repo")
	private ClienteRepository repo;
	
	public boolean crear(Clientes cli) {
		try {
			repo.save(cli);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean actualizar(Clientes cli) {
		try {
			repo.save(cli);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean borrar(Integer codigo) {
		try {
			Clientes c = repo.findByCodigo(codigo);
			repo.delete(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
