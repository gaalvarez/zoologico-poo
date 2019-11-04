package org.ucc.zoologico;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {

	private List<Animal> animalesRegistrados = new ArrayList<>();
	private static Store store = null;

	private Store() {
		// Para no permitir instanciar esta clase.
	}

	public static Store getInstance() {
		// To ensure only one instance is created
		if (store == null) {
			store = new Store();
		}
		return store;
	}

	public List<Animal> getAnimales() {
		return animalesRegistrados;
	}

	public void addAnimal(Animal animal) throws Exception {
		boolean existeAnimal = validarExistenciaAnimal(animal.getNombre());
		if (existeAnimal) {
			throw new Exception("Animal ya existe");
		}
		animalesRegistrados.add(animal);
	}

	private boolean validarExistenciaAnimal(String nombre) {
		for (Animal animal : animalesRegistrados) {
			if (animal.getNombre().equals(nombre)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * recibe un string con un nombre, con el que filtra la lista de animales
	 * registrados y devuelve quienes tengan un nombre coincidente con la busqueda
	 * 
	 * @param nombre
	 * @return
	 */
	public List<Animal> buscarAnimalesPorNombre(String nombre) {
		if (null != animalesRegistrados && !animalesRegistrados.isEmpty()) {
			return animalesRegistrados.stream().filter(item -> item.getNombre().contains(nombre))
					.collect(Collectors.toList());
		} else {
			return new ArrayList<>();
		}
	}

}
