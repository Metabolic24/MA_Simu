package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import domaineConduite.Voiture;



public class TestVoiture {
	
	@Test
	public void testGetX(){
		Voiture voiture = new Voiture(20) ;
		
		int xVoiture = voiture.getCoordXEnMetres() ;
		
		assertEquals(20, xVoiture);
		
	}
	
	@Test
	public void testVitesseX() {
		Voiture voiture = new Voiture(20);
		voiture.setVitesse(150);
		assertEquals(150,voiture.getVitesseMetreParSecondes());
	}
	
	@Test
	public void testMiseAjourPositionEnFonctionVitesse() {
		Voiture voiture = new Voiture(20);
		voiture.setVitesse(100);
		voiture.avancerEnFonctionDeLaVitesse();
		assertEquals(120, voiture.getCoordXEnMetres());
	}

	@Test
	public void testDemarrer(){
		Voiture voiture = new Voiture(20);
		voiture.demarrer();
		assertEquals(voiture.getVitesseMetreParSecondes(),50);
	}

	@Test
	public void testArreter(){
		Voiture voiture = new Voiture(20);
		voiture.demarrer();
		voiture.arreter();
		assertEquals(voiture.getVitesseMetreParSecondes(),0);
	}
	
}
