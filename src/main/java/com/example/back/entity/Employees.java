package com.example.back.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employees implements Serializable{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer codigo;
	
	private String nombre;
	private double sueldo;
	private String posicion;
	
	public Employees() {
	}
	
	public Employees(Integer codigo, String nombre, double sueldo, String posicion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.posicion = posicion;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	
}
