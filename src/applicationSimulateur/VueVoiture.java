package applicationSimulateur;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import domaineConduite.Voiture;


public class VueVoiture implements Observer {

	private Voiture voiture;

	private DessinVoiture ihm;

	public VueVoiture(final Voiture voiture, DessinVoiture ihm) {
		this.voiture = voiture;
		this.voiture.addObserver(this);
		this.ihm = ihm;
		ihm.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					voiture.setVitesse(voiture.getVitesseMetreParSecondes()+1);
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					voiture.setVitesse(voiture.getVitesseMetreParSecondes()-1);
				}
				else if(e.getKeyCode()== KeyEvent.VK_ENTER) {
					voiture.demarrer();
				}
				else if(e.getKeyCode()== KeyEvent.VK_SPACE) {
					voiture.arreter();
				}
			}
		});
	}

	public static int transformerMetrePixel(int coordonneeXEnMetre) {

		int ratioDomaineFenetre = Voiture.largeurDomaine / DessinVoiture.TailleFenetreEnPixels;

		int coordonneeXEnPixels = coordonneeXEnMetre / ratioDomaineFenetre;

		return coordonneeXEnPixels;
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		int xVoiture = this.voiture.getCoordXEnMetres();
		int xPixelVoiture = VueVoiture.transformerMetrePixel(xVoiture);
		if(ihm.estAuBoutDeLaRoute(xPixelVoiture)) {
			voiture.setVitesse(0);
		}
		else {
			ihm.setXPixelVoiture(xPixelVoiture);
		}		
		ihm.repaint();
	}

}
