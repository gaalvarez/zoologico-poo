/**
 * 
 */
package org.ucc.zoologico.ui.table;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.ucc.zoologico.Animal;
import org.ucc.zoologico.Store;
import org.ucc.zoologico.ui.SeleccionAnimal;

/**
 * @author iotec_ceo
 *
 */
public class TablaAnimalesPanel extends JPanel {

	private static final long serialVersionUID = -142138799015095198L;
	
	private JFrame frameContenedor;
	private JTable tablaAnimales;
	private List<Animal> animales;
	private AnimalesModel model;
	private Animal animalSeleccionado;

	public TablaAnimalesPanel(JFrame frameContenedor) {
		super(new GridBagLayout());
		this.animales = new ArrayList<Animal>();
		this.frameContenedor = frameContenedor;
		this.crearInterfaz();
		this.configurarEventos();
	}

	public TablaAnimalesPanel(JFrame frameContenedor, List<Animal> animales) {
		super(new GridBagLayout());
		this.animales = animales;
		this.frameContenedor = frameContenedor;
		this.crearInterfaz();
		this.configurarEventos();
	}

	public void crearInterfaz() {
		tablaAnimales = new JTable();
		tablaAnimales.setPreferredScrollableViewportSize(new Dimension(500, animales.size() * 16));
		JScrollPane scrollPane = new JScrollPane(tablaAnimales);
		model = new AnimalesModel(this.animales);
		tablaAnimales.setModel(model);
		actualizarTabla(animales);
		add(scrollPane);
	}

	public void configurarEventos() {
		tablaAnimales.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting() && tablaAnimales.getSelectedRow() != -1) {
					animalSeleccionado = model.getAnimalPorIndice(tablaAnimales.getSelectedRow());
					if (frameContenedor instanceof SeleccionAnimal) {
						((SeleccionAnimal) frameContenedor).seleccionarAnimal(animalSeleccionado);
					}
				}

			}
		});
	}

	public void buscarAnimal(String nombre) {
		List<Animal> animales = Store.getInstance().buscarAnimalesPorNombre(nombre);
		actualizarTabla(animales);
	}

	private void actualizarTabla(List<Animal> animales) {
		model.setAnimales(animales);
		model.fireTableDataChanged();
	}
	
	public Animal getAnimalSeleccionado() {
		return this.animalSeleccionado;
	}

}
