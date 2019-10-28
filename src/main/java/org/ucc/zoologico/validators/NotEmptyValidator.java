/**
 * 
 */
package org.ucc.zoologico.validators;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * @author iotec_ceo
 *
 */
public class NotEmptyValidator extends AbstractValidator {

	public NotEmptyValidator(JFrame parent, JTextField c, String message) {
		super(parent, c, message);
	}

	@Override
	protected boolean validationCriteria(JComponent c) {
		String texto = ((JTextField) c).getText();
		if (texto.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	
}
