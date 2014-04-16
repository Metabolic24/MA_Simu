package applicationSimulateur;

import java.awt.Graphics;

import javax.swing.JFrame;

public class DessinVoiture extends JFrame {

	public static final int TailleFenetreEnPixels = 500;
	public static final int TailleBordureFenetre = 9;
	
	private int largeurVoiture=40;
	private int hauteurVoiture=20;
	
	private int xPixelVoiture;

	public DessinVoiture() {
		super();
		this.setTitle("Simulateur de Voiture");
		this.setSize(TailleFenetreEnPixels, TailleFenetreEnPixels);
		this.setVisible(true);
		this.xPixelVoiture = TailleBordureFenetre;
	}

	
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		dessinerVoiture(graphics);
	}

	public void dessinerVoiture(Graphics graphics) {
		graphics.fillRect(xPixelVoiture, 200, largeurVoiture, hauteurVoiture);
	}

	public void setXPixelVoiture(int xPixelVoiture) {
		this.xPixelVoiture = xPixelVoiture;
	}

	public boolean estAuBoutDeLaRoute(int xPixelVoiture) {
		if(xPixelVoiture>=this.getWidth()-largeurVoiture){
			setXPixelVoiture(this.getWidth()-largeurVoiture-TailleBordureFenetre);
			return true;
		}
		else{
			return false;
		}
	}

}
