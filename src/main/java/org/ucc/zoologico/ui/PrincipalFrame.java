package org.ucc.zoologico.ui;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class PrincipalFrame extends MainFrame {

	private JButton registrarButton;
	private JButton alimentarButton;
	private JButton vacunarButton;

	/**
	 * Create the frame.
	 */
	public PrincipalFrame() {
		super("ZOOLOGICO");
		this.crearInterfaz();
		this.agregarHandlers();
	}
	
	public void crearInterfaz() {

		this.registrarButton = new JButton("Registrar");
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.gridx = 0;
		constraints.gridy = 1;
		this.getPanel().add(this.registrarButton, constraints);

		this.alimentarButton = new JButton("Alimentar");
		GridBagConstraints constraints2 = new GridBagConstraints();
		constraints2.anchor = GridBagConstraints.WEST;
		constraints2.insets = new Insets(10, 10, 10, 10);
		constraints2.gridy = 1;
		constraints2.gridx = 1;
		this.getPanel().add(this.alimentarButton, constraints2);

		this.vacunarButton = new JButton("Vacunar");
		GridBagConstraints constraints3 = new GridBagConstraints();
		constraints3.anchor = GridBagConstraints.CENTER;
		constraints3.insets = new Insets(10, 10, 10, 10);
		constraints3.gridy = 2;
		constraints3.gridx = 0;
		constraints3.gridwidth = 2;
		this.getPanel().add(this.vacunarButton, constraints3);

		// add the panel to this frame
		getContentPane().add(this.getPanel());

		this.ajustarInterfaz();
	}
	
	public void agregarHandlers() {
		registrarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrarFrame registrar = new RegistrarFrame();
				setVisible(false);
				registrar.setVisible(true);
			}
		});
		
		alimentarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AlimentarFrame alimentar = new AlimentarFrame();
				setVisible(false);
				alimentar.setVisible(true);
			}
		});
	}

}
