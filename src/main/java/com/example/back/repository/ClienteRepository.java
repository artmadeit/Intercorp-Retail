package com.example.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.back.entity.Clientes;

@Repository("repo")
public interface ClienteRepository extends JpaRepository<Clientes, Integer> {
	public Clientes findByCodigo(Integer codigo);
}
