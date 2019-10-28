/**
 * 
 */
package org.ucc.zoologico;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author iotec_ceo
 *
 */
public class Lobo extends Animal implements Can {

	private String colorPelo;
	private Map<Date, String> vacunas = new HashMap<>();

	public Lobo(String nombre, String familia, int peso, int edad) {
		super(nombre, familia, peso, edad);
	}

	@Override
	public void vacunar(Vacuna vacuna) {
		this.vacunas.put(new Date(), vacuna.getTipo());
	}

	/**
	 * el formato para imprimir las vacunas del lobo debe verse así:
	 * |Fecha       |  Tipo  |
	 * |24-SEP-2019 |  fiebre|
	 * |25-SEP-2019 |  gripa |
	 */
	@Override
	public String imprimirVacunas() {
		String registro = "|Fecha                                |Tipo          \n";
		for (Map.Entry<Date,String> entry : vacunas.entrySet()) {
			registro += "|Fecha: " + entry.getKey() + "  ";
			registro += "|Tipo: " + entry.getValue() + "\n";
		}
		return registro;
	}

	@Override
	public int calcularCantidadAlimento() {
		return new Random().nextInt(15);
	}

}
