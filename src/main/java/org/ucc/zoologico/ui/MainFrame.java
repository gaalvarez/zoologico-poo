package org.ucc.zoologico.ui;

import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private String tituloInterface = "SIN TITULO";

	/**
	 * Create the frame.
	 */
	public MainFrame(String titulo) {
		this.tituloInterface = titulo;
		this.crearMainInterfaz();
	}
	
	public void crearMainInterfaz() {
		this.contentPane = new JPanel(new GridBagLayout());
		// set border for the panel
		contentPane.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), this.tituloInterface));

		// add the panel to this frame
		getContentPane().add(contentPane);
		this.ajustarInterfaz();
	}
	
	public void ajustarInterfaz() {
		this.pack();
		setLocationRelativeTo(null);
	}
	
	public JPanel getPanel() {
		return this.contentPane;
	}
}
