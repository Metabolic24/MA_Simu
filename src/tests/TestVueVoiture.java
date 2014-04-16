package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import applicationSimulateur.VueVoiture;



public class TestVueVoiture {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testTransformationMetrePixels(){
		assertEquals(400, VueVoiture.transformerMetrePixel(800));	
		assertEquals(100, VueVoiture.transformerMetrePixel(201));	
		assertEquals(50, VueVoiture.transformerMetrePixel(100));
	}
	

}
