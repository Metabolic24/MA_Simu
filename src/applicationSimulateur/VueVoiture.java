package applicationSimulateur;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import domaineConduite.Voiture;


public class VueVoiture implements Observer {

	private Voiture voiture;

	private DessinVoiture ihm;

	public VueVoiture() {
		this.voiture = null;
	}

	public VueVoiture(Voiture voiture) {
		this.voiture = voiture;
		this.voiture.addObserver(this);
	}

	public VueVoiture(final Voiture voiture, DessinVoiture ihm) {
		this.voiture = voiture;
		this.voiture.addObserver(this);
		this.ihm = ihm;
		this.ihm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent touchePressee) {
				if(touchePressee.getKeyCode()== KeyEvent.VK_ENTER)
				{
					voiture.setVitesse(50);
				}
			}
		});
	}

	public int transformerMetrePixel(int coordonneeXEnMetre) {

		int ratioDomaineFenetre = Voiture.largeurDomaine / DessinVoiture.TailleFenetreEnPixels;

		int coordonneeXEnPixels = coordonneeXEnMetre / ratioDomaineFenetre;

		return coordonneeXEnPixels;
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		int xVoiture = this.voiture.getCoordXEnMetres();
		int xPixelVoiture = this.transformerMetrePixel(xVoiture);
		if(ihm.estAuBoutDeLaRoute(xPixelVoiture)){
			voiture.setVitesse(0);
		}
		else{
			ihm.setXPixelVoiture(xPixelVoiture);
		}		
		ihm.repaint();
	}

}
