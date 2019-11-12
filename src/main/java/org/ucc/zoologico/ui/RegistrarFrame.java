package org.ucc.zoologico.ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.ucc.zoologico.Animal;
import org.ucc.zoologico.Leon;
import org.ucc.zoologico.Lobo;
import org.ucc.zoologico.Store;
import org.ucc.zoologico.Tigre;
import org.ucc.zoologico.Zorro;
import org.ucc.zoologico.exception.AnimalExistException;
import org.ucc.zoologico.validators.NotEmptyValidator;
import org.ucc.zoologico.validators.WantsValidationStatus;

public class RegistrarFrame extends MainFrame implements WantsValidationStatus {

	private NavegacionPanel navegacion;
	private JLabel nombreLabel;
	private JTextField nombreTextField;
	private JLabel pesoLabel;
	private JTextField pesoTextField;
	private JLabel edadLabel;
	private JTextField edadTextField;
	private JLabel familiaLabel;
	private String[] optionsFamilia = { "Seleccione...", "Canino", "Felino" };
	private JComboBox familiaCombo;
	private JLabel tipoLabel;
	private String[] optionsFelinos = { "Seleccione...", "Tigre", Constante.TIPO_LEON };
	private String[] optionsCaninos = { "Seleccione...", "Zorro", "Lobo" };
	private JComboBox tipoCombo;
	private JButton registrarButton;
	private static final Logger logger = Logger.getLogger(RegistrarFrame.class.getName());
	// TODO: agregar label y combobox para el genero
	// TODO: agregar label y inputtext para el color de pelo

	/**
	 * Create the frame.
	 */
	public RegistrarFrame() {
		super("REGISTRAR ANIMAL");
		this.crearInterfaz();
		this.configurarEventos();
	}

	public void crearInterfaz() {
		this.navegacion = new NavegacionPanel(this);
		GridBagConstraints constraints0 = new GridBagConstraints();
		constraints0.anchor = GridBagConstraints.EAST;
		constraints0.insets = new Insets(10, 10, 10, 10);
		constraints0.gridx = 0;
		constraints0.gridy = 0;
		constraints0.gridwidth = 4;
		this.getPanel().add(navegacion, constraints0);

		/* Fila de campo nombre **/
		this.nombreLabel = new JLabel("Nombre: ");
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.gridx = 0;
		constraints.gridy = 1;
		this.getPanel().add(this.nombreLabel, constraints);
		this.nombreTextField = new JTextField();
		this.nombreTextField.setPreferredSize(new Dimension(200, 20));
		this.nombreTextField
				.setInputVerifier(new NotEmptyValidator(this, nombreTextField, "Nombre es un campo requerido"));
		GridBagConstraints constraints2 = new GridBagConstraints();
		constraints2.anchor = GridBagConstraints.WEST;
		constraints2.insets = new Insets(10, 10, 10, 10);
		constraints2.gridx = 1;
		constraints2.gridy = 1;
		constraints2.gridwidth = 3;
		this.getPanel().add(this.nombreTextField, constraints2);

		/* Campo peso **/
		this.pesoLabel = new JLabel("Peso: ");
		GridBagConstraints constraints3 = new GridBagConstraints();
		constraints3.anchor = GridBagConstraints.WEST;
		constraints3.insets = new Insets(10, 10, 10, 10);
		constraints3.gridx = 0;
		constraints3.gridy = 2;
		this.getPanel().add(this.pesoLabel, constraints3);
		this.pesoTextField = new JTextField();
		this.pesoTextField.setPreferredSize(new Dimension(50, 20));
		GridBagConstraints constraints4 = new GridBagConstraints();
		constraints4.anchor = GridBagConstraints.WEST;
		constraints4.insets = new Insets(10, 10, 10, 10);
		constraints4.gridx = 1;
		constraints4.gridy = 2;
		this.getPanel().add(this.pesoTextField, constraints4);

		/* campo edad */
		this.edadLabel = new JLabel("Edad: ");
		GridBagConstraints constraints5 = new GridBagConstraints();
		constraints5.anchor = GridBagConstraints.WEST;
		constraints5.insets = new Insets(10, 10, 10, 10);
		constraints5.gridx = 2;
		constraints5.gridy = 2;
		this.getPanel().add(this.edadLabel, constraints5);
		this.edadTextField = new JTextField();
		this.edadTextField.setPreferredSize(new Dimension(50, 20));
		GridBagConstraints constraints6 = new GridBagConstraints();
		constraints6.anchor = GridBagConstraints.WEST;
		constraints6.insets = new Insets(10, 10, 10, 10);
		constraints6.gridx = 3;
		constraints6.gridy = 2;
		this.getPanel().add(this.edadTextField, constraints6);
		/* selección de familia */
		this.familiaLabel = new JLabel("Familia: ");
		GridBagConstraints constraints70 = new GridBagConstraints();
		constraints70.anchor = GridBagConstraints.WEST;
		constraints70.insets = new Insets(10, 10, 10, 10);
		constraints70.gridx = 0;
		constraints70.gridy = 3;
		this.getPanel().add(this.familiaLabel, constraints70);
		this.familiaCombo = new JComboBox(optionsFamilia);
		GridBagConstraints constraints7 = new GridBagConstraints();
		constraints7.anchor = GridBagConstraints.WEST;
		constraints7.insets = new Insets(10, 10, 10, 10);
		constraints7.gridx = 1;
		constraints7.gridy = 3;
		this.getPanel().add(this.familiaCombo, constraints7);

		/* selección de tipo */
		this.tipoLabel = new JLabel("Tipo: ");
		GridBagConstraints constraints90 = new GridBagConstraints();
		constraints90.anchor = GridBagConstraints.WEST;
		constraints90.insets = new Insets(10, 10, 10, 10);
		constraints90.gridx = 0;
		constraints90.gridy = 4;
		this.getPanel().add(this.tipoLabel, constraints90);

		this.tipoCombo = new JComboBox();
		GridBagConstraints constraints9 = new GridBagConstraints();
		constraints9.anchor = GridBagConstraints.WEST;
		constraints9.insets = new Insets(10, 10, 10, 10);
		constraints9.gridx = 1;
		constraints9.gridy = 4;
		this.getPanel().add(this.tipoCombo, constraints9);

		/* botón registrar */
		this.registrarButton = new JButton("Registrar");
		GridBagConstraints constraints8 = new GridBagConstraints();
		constraints8.anchor = GridBagConstraints.CENTER;
		constraints8.insets = new Insets(10, 10, 10, 10);
		constraints8.gridy = 6;
		constraints8.gridx = 0;
		constraints8.gridwidth = 4;
		this.getPanel().add(this.registrarButton, constraints8);

		ajustarInterfaz();
	}

	public void configurarEventos() {
		/* acción de registro */
		registrarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					registrarAnimal();
				} catch (AnimalExistException e1) {
					logger.log(Level.SEVERE, e1.getLocalizedMessage(), e1);
					JOptionPane.showMessageDialog(RegistrarFrame.this, e1.getLocalizedMessage());
				}
			}
		});

		this.familiaCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (e.getItem().toString().equals("Canino")) {
						tipoCombo.setModel(new DefaultComboBoxModel<>(optionsCaninos));
					} else {
						tipoCombo.setModel(new DefaultComboBoxModel<>(optionsFelinos));
					}
				}
			}
		});

		// TODO: agregar un listener para el combobox de tipo, similar al anterior.
		// TODO: dentro de la captura del evento, validar si es Leon llamar a un metodo
		// para construir mostrar un inputtext que me permita capturar el sexo del leon
		// (mostrarInputTextGenero)
		// TODO: Validar si es zorro llamar a un método que muestre un inputtext para
		// capturar el color de pelo
	}

	public void mostrarInputTextGenero() {
		// TODO: inicializar el label y inputtext de genero y mostrarlo en la posición
		// y=5
		// TODO: remover color de pelo si está agregado al panel
	}

	public void mostrarInputTextColorPelo() {
		// TODO: inicializar el label y inputtext de color pelo y mostrarlo en la
		// posición y=5
		// TODO: remover inputext genero si está agregado
	}

	private void registrarAnimal() throws AnimalExistException {
		String nombre = this.nombreTextField.getText();
		int peso = Integer.parseInt(this.pesoTextField.getText());
		int edad = Integer.parseInt(this.edadTextField.getText());
		int indiceFamilia = this.familiaCombo.getSelectedIndex();
		String familia = this.optionsFamilia[indiceFamilia];
		int indiceTipo = this.tipoCombo.getSelectedIndex();
		String tipo = "";
		if (familia.equals("Canino")) {
			tipo = this.optionsCaninos[indiceTipo];
		} else {
			tipo = this.optionsFelinos[indiceTipo];
		}
		System.out.println("tipo: " + tipo);
		Animal animal = crearAnimal(nombre, peso, edad, familia, tipo);
		Store.getInstance().addAnimal(animal);
		for (Animal an : Store.getInstance().getAnimales()) {
			System.out.println("***********");
			System.out.println("nombre: " + an.getNombre());

			System.out.println("familia: " + an.getFamilia());

		}
	}

	private Animal crearAnimal(String nombre, int peso, int edad, String familia, String tipo) {
		if (tipo.equals("Leon")) {
			return new Leon(nombre, familia, peso, edad);
		} else if (tipo.equals("Tigre")) {
			return new Tigre(nombre, familia, peso, edad);
		} else if (tipo.equals("Zorro")) {
			return new Zorro(nombre, familia, peso, edad);
		} else if (tipo.equals("Lobo")) {
			return new Lobo(nombre, familia, peso, edad);
		} else {
			throw new IllegalArgumentException("El tipo no corresponde a un animal del zoologico");
		}
	}

	@Override
	public void validateFailed() {
		this.registrarButton.setEnabled(false);
	}

	@Override
	public void validatePassed() {
		this.registrarButton.setEnabled(true);
	}

}
