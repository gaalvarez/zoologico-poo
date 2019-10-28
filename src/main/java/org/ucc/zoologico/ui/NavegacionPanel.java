package org.ucc.zoologico.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NavegacionPanel extends JPanel {

	private JButton homeButton;
	private JButton backButton;
	private JFrame frameContenedor;

	/**
	 * Create the frame.
	 */
	public NavegacionPanel(JFrame frameContenedor) {
		super(new GridBagLayout());
		this.frameContenedor = frameContenedor;
		this.crearInterfaz();
		this.configurarEventos();
	}

	public void crearInterfaz() {
		this.homeButton = new JButton("Inicio");
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridy = 0;
		constraints.gridx = 1;
		add(this.homeButton, constraints);
		
		this.backButton = new JButton("Atras");
		GridBagConstraints constraints1 = new GridBagConstraints();
		constraints1.anchor = GridBagConstraints.WEST;
		constraints1.gridy = 0;
		constraints1.gridx = 0;
		add(this.backButton, constraints1);
	}

	public void configurarEventos() {
		this.homeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrincipalFrame principal = new PrincipalFrame();
				principal.setVisible(true);
				frameContenedor.setVisible(false);
			}
		});
	}

}
