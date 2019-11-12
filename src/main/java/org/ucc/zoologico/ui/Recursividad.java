/**
 * 
 */
package org.ucc.zoologico.ui;

/**
 * @author iotec_ceo
 *
 */
public class Recursividad {

	public int sumarVector(int[] vector, int n) {
		if (n == 1) {
			return vector[n - 1];
		} else {
			return vector[n - 1] + sumarVector(vector, n - 1);
		}
	}

	public void escribirCadenaAlReves(String cadena) {
		if (cadena.length() > 1) {
			escribirCadenaAlReves(cadena.substring(1));
		}
		System.out.println(cadena.substring(0, 1));
	}

	public String cadenaAlReves(String cadena) {
		if (cadena.length() <= 1) {
			return cadena.substring(0, 1);	
		} else {
			return cadenaAlReves(cadena.substring(1)) + cadena.charAt(0);
		}
	}

}
