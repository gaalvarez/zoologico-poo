/**
 * 
 */
package org.ucc.zoologico.ui.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.ucc.zoologico.Animal;
import org.ucc.zoologico.Leon;
import org.ucc.zoologico.Lobo;
import org.ucc.zoologico.Tigre;
import org.ucc.zoologico.Zorro;

/**
 * @author gaalvarez
 *
 */
public class AnimalesModel extends AbstractTableModel {

	private List<Animal> animales;
	private String titulosColumnas[] = new String[] { "Nombre", "Familia", "Tipo" };
	
	
	private static final long serialVersionUID = -2997158644206571030L;

	public AnimalesModel(List<Animal> animales) {
		super();
		this.animales = animales;
	}

	@Override
	public int getRowCount() {
		return this.animales.size();
	}

	@Override
	public int getColumnCount() {
		return this.titulosColumnas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Animal animal = this.animales.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return animal.getNombre();
		case 1:
			return animal.getFamilia();
		case 2:
			return obtenerTipo(animal);
		default:
			return "";
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

	/**
	 * agregar despues
	 */
	@Override
	public String getColumnName(int column) {
		return this.titulosColumnas[column];
	}

	public void setAnimales(List<Animal> animales) {
		this.animales = animales;
	}

	public Animal getAnimalPorIndice(int indice) {
		return this.animales.get(indice);
	}
}
