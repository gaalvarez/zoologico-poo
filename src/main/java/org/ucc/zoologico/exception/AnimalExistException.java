/**
 * 
 */
package org.ucc.zoologico.exception;

/**
 * @author iotec_ceo
 *
 */
public class AnimalExistException extends Exception {

	private static final long serialVersionUID = -6974986575197718259L;
	private String nombre;

	public AnimalExistException(String nombre) {
		super("Ya existe un animal con el nombre: " + nombre + ". Seleccione otro nombre.");
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

}
