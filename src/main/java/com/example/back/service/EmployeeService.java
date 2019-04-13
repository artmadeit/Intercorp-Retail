package com.example.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.entity.Employees;
import com.example.back.repository.EmployeeRepository;

@Service("servicio")
public class EmployeeService {
	@Autowired //injectar
	private EmployeeRepository repositorio;
	
	public boolean crear(Employees em) {
		try {
			//repositorio.save(em);
			repositorio.save(em);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean actualizar(Employees em) {
		try {
			repositorio.save(em);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean borrar(Integer codigo) {
		try {
			Employees e = repositorio.findByCodigo(codigo);
			repositorio.delete(e);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
