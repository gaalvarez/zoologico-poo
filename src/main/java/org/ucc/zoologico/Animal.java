/**
 * 
 */
package org.ucc.zoologico;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gaalvarez
 *
 */
public abstract class Animal {

	private String nombre;
	private String familia;
	private int peso;
	private int edad;
	private Map<Date, Integer> dosisComida = new HashMap<>();

	public Animal(String nombre, String familia, int peso, int edad) {
		this.nombre = nombre;
		this.familia = familia;
		this.peso = peso;
		this.edad = edad;
	}
	
	public String describir() {
		return "Familia: " + this.familia + " Peso: " + this.peso;
	}

	public abstract int calcularCantidadAlimento();

	public void comer(int racion) {
		this.dosisComida.put(new Date(), racion);
	}

	public String getFamilia() {
		return familia;
	}

	public int getPeso() {
		return peso;
	}

	public int getEdad() {
		return edad;
	}

	public Map<Date, Integer> getDosisComida() {
		return dosisComida;
	}
	
	public String getNombre() {
		return this.nombre;
	}

}
