package test.logic;

import static org.junit.Assert.*;
import model.logic.MVCModelo;

import org.junit.Before;
import org.junit.Test;

public class TestMVCModelo
{

	private MVCModelo modelo;

	@Before
	public void setUp1()
	{
		modelo= new MVCModelo();
	}

	public void setUp2()
	{
		
	}

	@Test
	public void testMVCModelo() {
		assertTrue(modelo!=null);
	}

	@Test
	public void testDarTamano() {
	}

	@Test
	public void testAgregar() {
		// TODO Completar la prueba

	}

	@Test
	public void testBuscar() {
		setUp2();
		// TODO Completar la prueba
	}

	@Test
	public void testEliminar() {
		setUp2();
		// TODO Completar la prueba

	}

}
