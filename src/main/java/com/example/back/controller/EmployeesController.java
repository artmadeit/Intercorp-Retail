package com.example.back.controller;

import java.util.List;

import javax.validation.Valid;

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

@RestController
@RequestMapping("/empleados")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeesController {
	
	private EmployeeRepository repositorio;
	
	public EmployeesController(EmployeeRepository employeeRepository) {
		this.repositorio = employeeRepository;
	}
	
	@PutMapping
	public Employees AgregarEmpleados(@RequestBody @Valid Employees em) {
		return repositorio.save(em);
	}
	
	@PostMapping
	public Employees ActualizarEmpleados(@RequestBody @Valid Employees em) {
		return repositorio.save(em);
	}
	
	@DeleteMapping("/{codigo}")
	public void borrarEmpleados(@PathVariable("codigo") Integer codigo) {
		repositorio.delete(codigo);
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
