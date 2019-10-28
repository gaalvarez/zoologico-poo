/**
 * 
 */
package org.ucc.zoologico;

import java.util.Random;

/**
 * @author iotec_ceo
 *
 */
public class Tigre extends Animal {

	public Tigre(String nombre, String familia, int peso, int edad) {
		super(nombre, familia, peso, edad);
	}

	@Override
	public int calcularCantidadAlimento() {
		return new Random().nextInt(50);
	}

}
