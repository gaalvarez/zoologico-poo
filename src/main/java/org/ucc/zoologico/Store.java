package org.ucc.zoologico;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.ucc.zoologico.exception.AnimalExistException;

public class Store {

	private List<Animal> animalesRegistrados = new ArrayList<>();
	private static Store store = null;
	private static final String RUTA_ANIMALES_CSV = "./animales.csv";

	private Store() {
		// Para no permitir instanciar esta clase.
		cargarRegistrosAnimales();
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

	public void addAnimal(Animal animal) throws AnimalExistException {
		boolean existeAnimal = validarExistenciaAnimal(animal.getNombre());
		if (existeAnimal) {
			throw new AnimalExistException(animal.getNombre());
		}
		animalesRegistrados.add(animal);
		this.guardarRegistroAnimal(animal);
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

	private void guardarRegistroAnimal(Animal animal) {
		BufferedWriter writer = null;
		CSVPrinter csvPrinter = null;
		try {
			Path ruta = Paths.get(RUTA_ANIMALES_CSV);
			Boolean existeArchivo = Files.exists(ruta);
			writer = Files.newBufferedWriter(ruta, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
			if (existeArchivo) {
				csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
			} else {
				csvPrinter = new CSVPrinter(writer,
						CSVFormat.DEFAULT.withHeader("nombre", "peso", "edad", "familia", "tipo"));
			}
			csvPrinter.printRecord(animal.getNombre(), animal.getPeso(), animal.getEdad(), animal.getFamilia(),
					this.obtenerTipo(animal));
			csvPrinter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != writer) {
				try {
					writer.close();
					csvPrinter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private Object obtenerTipo(Animal animal) {
		if (animal instanceof Leon) {
			return "Leon";
		} else if (animal instanceof Zorro) {
			return "Zorro";
		} else if (animal instanceof Lobo) {
			return "Lobo";
		} else if (animal instanceof Tigre) {
			return "Tigre";
		} else {
			return "";
		}
	}

	private void cargarRegistrosAnimales() {
		Path ruta = Paths.get(RUTA_ANIMALES_CSV);
		if (Files.notExists(ruta)) {
			return;
		}
		try {
			Reader reader = Files.newBufferedReader(ruta);
			CSVParser csvParser = new CSVParser(reader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			for (CSVRecord csvRecord : csvParser) {
				// Accessing values by Header names
				String nombre = csvRecord.get("nombre");
				String peso = csvRecord.get("peso");
				String edad = csvRecord.get("edad");
				String familia = csvRecord.get("familia");
				String tipo = csvRecord.get("tipo");
				Animal animal = this.crearAnimal(nombre, peso, edad, familia, tipo);
				this.animalesRegistrados.add(animal);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Animal crearAnimal(String nombre, String peso, String edad, String familia, String tipo) {
		int pesoInt = Integer.parseInt(peso);
		int edadInt = Integer.parseInt(peso);
		if (tipo.equals("Leon")) {
			return new Leon(nombre, familia, pesoInt, edadInt);
		} else if (tipo.equals("Tigre")) {
			return new Tigre(nombre, familia, pesoInt, edadInt);
		} else if (tipo.equals("Zorro")) {
			return new Zorro(nombre, familia, pesoInt, edadInt);
		} else if (tipo.equals("Lobo")) {
			return new Lobo(nombre, familia, pesoInt, edadInt);
		} else {
			throw new IllegalArgumentException("El tipo no corresponde a un animal del zoologico");
		}
	}
}
