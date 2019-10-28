package org.ucc.zoologico;

import java.awt.EventQueue;

import org.ucc.zoologico.ui.PrincipalFrame;

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
//		
//		Lobo lobo = new Lobo("CAN", 40, 7);
//		Vacuna rabia = new Vacuna();
//		rabia.setDosis(50);
//		rabia.setTipo("Rabia");
//		lobo.vacunar(rabia);
//		lobo.comer(10);
//		Thread.sleep(1000);
//		Vacuna fiebre = new Vacuna();
//		fiebre.setDosis(50);
//		fiebre.setTipo("Fiebre");
//		lobo.vacunar(fiebre);
//		String registroVacunas = lobo.imprimirVacunas();
//		System.out.println(registroVacunas);
//		System.out.println("**************************************");
//		
//		Zorro zorro = new Zorro("CAN", 29, 8);
//		Vacuna polio = new Vacuna();
//		polio.setDosis(50);
//		polio.setTipo("Polio");
//		zorro.vacunar(polio);
//		Thread.sleep(1000);
//		Vacuna gripa = new Vacuna();
//		gripa.setDosis(50);
//		gripa.setTipo("Gripa");
//		zorro.vacunar(gripa);
//		String registroVacunasZorro = zorro.imprimirVacunas();
//		System.out.println(registroVacunasZorro);
	}

}
