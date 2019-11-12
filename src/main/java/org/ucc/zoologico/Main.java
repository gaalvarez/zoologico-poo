package org.ucc.zoologico;

import java.awt.EventQueue;

import org.ucc.zoologico.ui.PrincipalFrame;
import org.ucc.zoologico.ui.Recursividad;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalFrame frame = new PrincipalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
