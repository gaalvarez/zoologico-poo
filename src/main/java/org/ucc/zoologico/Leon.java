/**
 * 
 */
package org.ucc.zoologico;

import java.util.Random;

/**
 * @author iotec_ceo
 *
 */
public class Leon extends Animal {
	
	private String sexo;

	public Leon(String nombre, String familia, int peso, int edad) {
		super(nombre, familia, peso, edad);
	}

	@Override
	public int calcularCantidadAlimento() {
		return new Random().nextInt(50);
	}

}
