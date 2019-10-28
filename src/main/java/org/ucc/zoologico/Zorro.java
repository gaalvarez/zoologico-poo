package org.ucc.zoologico;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Zorro extends Animal implements Can {

	private Map<Date, Vacuna> vacunas = new HashMap<>();

	public Zorro(String nombre, String familia, int peso, int edad) {
		super(nombre, familia, peso, edad);
	}
	
	public Zorro(String nombre, String familia, int peso) {
		super(nombre, familia, peso, 0);
	}
	
	public Zorro(String nombre, String familia) {
		super(nombre, familia, 0, 0);
	}

	@Override
	public void vacunar(Vacuna vacuna) {
		this.vacunas.put(new Date(), vacuna);
	}

	/**
	 * el formato para imprimir las vacunas del lobo debe verse así: |Fecha | Tipo |
	 * Dosis (ml) | |24-SEP-2019 | fiebre| 50 | |25-SEP-2019 | gripa | 30 |
	 */
	@Override
	public String imprimirVacunas() {
		String registro = "|Fecha                                |Tipo              |Dosis          \n";
		for (Map.Entry<Date, Vacuna> entry : vacunas.entrySet()) {
			registro += "|Fecha: " + entry.getKey() + "  ";
			registro += "|Tipo: " + entry.getValue().getTipo() + "       ";
			registro += "|Dosis: " + entry.getValue().getDosis() + "\n";
		}
		return registro;
	}

	@Override
	public int calcularCantidadAlimento() {
		return new Random().nextInt(15);
	}

	@Override
	public String describir() {
		return "Familia: " + this.getFamilia() + " Peso: " + this.getPeso() + " Edad: " + this.getEdad();
	}
}
