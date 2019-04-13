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

import com.example.back.entity.Employees;
import com.example.back.repository.EmployeeRepository;
import com.example.back.service.EmployeeService;

@RestController
@RequestMapping("/empleados")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeesController {
	@Autowired //injectar
	private EmployeeRepository repositorio;
	
	@Autowired
	@Qualifier("servicio")
	EmployeeService servicio;
	
	@PutMapping
	public boolean AgregarEmpleados(@RequestBody @Valid Employees em) {
		return servicio.crear(em);
	}
	
	@PostMapping
	public boolean ActualizarEmpleados(@RequestBody @Valid Employees em) {
		return servicio.actualizar(em);
	}
	
	@DeleteMapping("/{codigo}")
	public boolean borrarEmpleados(@PathVariable("codigo") Integer codigo) {
		return servicio.borrar(codigo);
	}
	
	@GetMapping
	public List<Employees> getEmployees(){
		return repositorio.findAll();
	}
	
	@GetMapping(value="/{codigo}")
	public Employees findByCodigo(@PathVariable("codigo") Integer codigo) {
		return repositorio.findByCodigo(codigo);
	}
	
}
