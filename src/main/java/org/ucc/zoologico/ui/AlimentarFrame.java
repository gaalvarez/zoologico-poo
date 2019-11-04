/**
 * 
 */
package org.ucc.zoologico.ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.ucc.zoologico.Store;
import org.ucc.zoologico.ui.table.TablaAnimalesPanel;

/**
 * @author iotec_ceo
 *
 */
public class AlimentarFrame extends MainFrame {

	private static final long serialVersionUID = -3857195240482629914L;
	private NavegacionPanel navegacion;
	private JLabel buscarLabel;
	private JTextField busquedaTextField;
	private JButton botonBuscar;
	private TablaAnimalesPanel tablaAnimales;

	public AlimentarFrame() {
		super("Registrar Alimento");
		this.crearInterfaz();
		this.configurarEventos();
	}

	private void crearInterfaz() {
		this.navegacion = new NavegacionPanel(this);
		GridBagConstraints constraints0 = new GridBagConstraints();
		constraints0.anchor = GridBagConstraints.EAST;
		constraints0.insets = new Insets(10, 10, 10, 10);
		constraints0.gridx = 0;
		constraints0.gridy = 0;
		constraints0.gridwidth = 4;
		this.getPanel().add(navegacion, constraints0);

		/* inicio paso 2 */
		this.buscarLabel = new JLabel("Nombre a buscar: ");
		GridBagConstraints constraints1 = new GridBagConstraints();
		constraints1.anchor = GridBagConstraints.WEST;
		constraints1.insets = new Insets(10, 10, 10, 10);
		constraints1.gridx = 0;
		constraints1.gridy = 1;
		this.getPanel().add(this.buscarLabel, constraints1);
		this.busquedaTextField = new JTextField();
		this.busquedaTextField.setPreferredSize(new Dimension(200, 20));
		GridBagConstraints constraints2 = new GridBagConstraints();
		constraints2.anchor = GridBagConstraints.WEST;
		constraints2.insets = new Insets(10, 10, 10, 10);
		constraints2.gridx = 1;
		constraints2.gridy = 1;
		constraints2.gridwidth = 2;
		this.getPanel().add(this.busquedaTextField, constraints2);

		this.botonBuscar = new JButton("Buscar");
		GridBagConstraints constraints3 = new GridBagConstraints();
		constraints3.anchor = GridBagConstraints.CENTER;
		constraints3.insets = new Insets(10, 10, 10, 10);
		constraints3.gridy = 1;
		constraints3.gridx = 3;
		this.getPanel().add(this.botonBuscar, constraints3);
		/* fin paso 2 */

		this.tablaAnimales = new TablaAnimalesPanel(this, Store.getInstance().getAnimales());
		GridBagConstraints constraints4 = new GridBagConstraints();
		constraints4.anchor = GridBagConstraints.CENTER;
		constraints4.insets = new Insets(10, 10, 10, 10);
		constraints4.gridx = 0;
		constraints4.gridy = 3;
		constraints4.gridwidth = 4;
		this.getPanel().add(tablaAnimales, constraints4);

		ajustarInterfaz();
	}

	private void configurarEventos() {
		botonBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String busqueda = busquedaTextField.getText();
				if (null != busqueda && !busqueda.isEmpty()) {
					tablaAnimales.buscarAnimal(busqueda);
				}
			}
		});
	}

}
