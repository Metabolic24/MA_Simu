package applicationSimulateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import domaineConduite.Voiture;


public class SimulateurVoiture {

	public static final int dureeUneSecondeEnMilliSecondes = 1000;
	
	public static void main(String[] args) {
		
		final Voiture voiture = new Voiture(VueVoiture.transformerPixelMetre(DessinVoiture.TailleBordureFenetre));
		DessinVoiture dessinVoiture = new DessinVoiture();
		
		final VueVoiture triangle = new VueVoiture(voiture, dessinVoiture);
		
		Timer timerAvancer = new Timer(dureeUneSecondeEnMilliSecondes, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				voiture.avancerEnFonctionDeLaVitesse();
			}
		});
		
		timerAvancer.start();
		
		while(true){
		}
	}
}
