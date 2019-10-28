package org.ucc.zoologico;

import java.util.ArrayList;
import java.util.List;

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
	
	public void addAnimal(Animal animal) {
		animalesRegistrados.add(animal);
	}

}
