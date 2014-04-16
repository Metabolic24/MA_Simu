package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import applicationSimulateur.DessinVoiture;

public class TestDessinVoiture {

	@Test
	public void testEstAuBoutDeLaRoute() {
		DessinVoiture dessin=new DessinVoiture();
		assertEquals(dessin.estAuBoutDeLaRoute(dessin.getWidth()),true);
	}

}
