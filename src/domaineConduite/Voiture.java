package domaineConduite;

import java.util.Observable;

public class Voiture extends Observable {

	private int coordXEnMetres;
	private int vitesseMetreParSecondes;

	public static final int largeurDomaine = 1000;

	public Voiture(int coordXEnMetres) {
		this.coordXEnMetres = coordXEnMetres;
		this.vitesseMetreParSecondes = 0;
	}

	public int getCoordXEnMetres() {
		return coordXEnMetres;
	}

	public int getVitesseMetreParSecondes() {
		return vitesseMetreParSecondes;
	}

	public void avancerEnFonctionDeLaVitesse() {
		if(vitesseMetreParSecondes>0){
			coordXEnMetres += vitesseMetreParSecondes;
			notificationObservateurs();
		}
	}

	private void notificationObservateurs() {
		this.setChanged();
		this.notifyObservers();
	}

	public void demarrer() {
		// TODO Auto-generated method stub
		
	}
	public void arreter() {
		vitesseMetreParSecondes=0;
		
	}

	public void setVitesse(int nouvelleVitesseMetreParSecondes) {
		vitesseMetreParSecondes=nouvelleVitesseMetreParSecondes;
	}
}
