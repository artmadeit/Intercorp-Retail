package com.example.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.back.entity.Employees;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer>{
	public Employees findByCodigo(Integer codigo);
}
