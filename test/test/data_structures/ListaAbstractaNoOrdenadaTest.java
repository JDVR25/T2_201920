package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public abstract class ListaAbstractaNoOrdenadaTest extends ListaAbstractaTest
{

	@Override
	public void testIterator() 
	{
		super.testIterator();
		Iterator<Integer> iterador = lista.iterator();
		int indiceActual = 0;
		while(iterador.hasNext())
		{
			try
			{
				Integer actual = iterador.next();
				assertEquals("El elemento en la posición " + indiceActual + " del iterador no coincide con el que debería", new Integer(ARREGLO_ESCENARIO_2[indiceActual]), actual);
				indiceActual++;
			}
			catch(NoSuchElementException e)
			{
				fail("Indica que puede avanzar, pero lanza excepción al avanzar.");
			}
		}
	}
	
	@Override
	public void testToArray() 
	{
		super.testToArray();
		Object[] arreglo = lista.toArray();
		for(int i = 0; i < arreglo.length; i++)
		{
			assertEquals("El elemento en la posición "+ i + " no es el esperado", ARREGLO_ESCENARIO_2[i], arreglo[i]);
		}
	}
	
	@Override
	public void testAdd() {
		super.testAdd();
		
		Object[] arreglo = lista.toArray();
		
		for(int i = 0; i < lista.size(); i ++)
		{
			assertEquals("El elemento en la posición " + i + " no es el esperado", ARREGLO_ESCENARIO_2[i], arreglo[i]);
			assertTrue("La lista no contiene " + ARREGLO_ESCENARIO_2[i], lista.contains(ARREGLO_ESCENARIO_2[i]));
			assertEquals("El elemento en la posición " + i + " no es el esperado", new Integer(ARREGLO_ESCENARIO_2[i]), lista.get(i));
		}
	}
	
	@Override
	public void testRemoveObject() {
		super.testRemoveObject();
		Object[] arreglo = lista.toArray();
		
		assertEquals("El primer elemento no es el esperado", new Integer(383), arreglo[0]);
		assertEquals("El elemento no es el esperado", new Integer(266), arreglo[4]);
		assertEquals("El elemento no es el esperado", new Integer(221), arreglo[9]);
		assertEquals("El elemento no es el esperado", new Integer(352), arreglo[13]);
		assertEquals("El elemento no es el esperado", new Integer(98), arreglo[14]);
		assertEquals("El elemento no es el esperado", new Integer(97), arreglo[15]);
		
		
	}
	
	@Override
	public void testGet() {
		super.testGet();
		
		for(int i = 0; i < lista.size(); i ++)
		{
			assertEquals("El elemento en la posición " + i  + " no es el esperado", new Integer(ARREGLO_ESCENARIO_2[i]), lista.get(i));
		}
	}
	
	/**
	 * Prueba el método set con un índice.
	 */
	@Test
	public void testSetIndex()
	{
		//Prueba con la lista vacía
		try
		{
			lista.set(0, 5);
		}
		catch(IndexOutOfBoundsException e)
		{
			//
		}
		
		//Prueba con 20 elementos
		setupEscenario2();
		
		try
		{
			lista.set(20, 5);
			fail("Debería lanzar excepción, está por fuera del arreglo");
		}
		catch(IndexOutOfBoundsException e)
		{
			//
		}
		
		try
		{
			lista.set(-1, 5);
			fail("Debería lanzar excepción, está por fuera del arreglo");
		}
		catch(IndexOutOfBoundsException e)
		{
			//
		}
		
		try
		{
			lista.set(0, 5);
			assertEquals("El tamaño de la lista no debió cambiar", 20, lista.size());
			assertEquals("El elemento no fue modificado", new Integer(5), lista.get(0));
			
			lista.set(19, 200);
			assertEquals("El tamaño de la lista no debió cambiar", 20, lista.size());
			assertEquals("El elemento no fue modificado", new Integer(200), lista.get(19));
			
			lista.set(10, 320);
			assertEquals("El tamaño de la lista no debió cambiar", 20, lista.size());
			assertEquals("El elemento no fue modificado", new Integer(320), lista.get(10));
			
			lista.set(16, 518);
			assertEquals("El tamaño de la lista no debió cambiar", 20, lista.size());
			assertEquals("El elemento no fue modificado", new Integer(518), lista.get(16));
			
			lista.set(4, 1250);
			assertEquals("El tamaño de la lista no debió cambiar", 20, lista.size());
			assertEquals("El elemento no fue modificado", new Integer(1250), lista.get(4));
		}
		catch(IndexOutOfBoundsException e)
		{
			fail("No debería fallar, los índices se encuentra dentro de la lista.");
		}
	}
	
	/**
	 * Prueba el método add en un índice.
	 */
	@Test
	public void addIndice()
	{
		try
		{
			lista.add(1, 5);
			fail("Debería lanzar la excepción, el índice se encuentra por fuera de la lista.");
		}
		catch(IndexOutOfBoundsException e)
		{
			//
		}
		
		try
		{
			lista.add(0, 5);
			assertEquals("El tamaño de la lista no es correcto", 1, lista.size());
			assertEquals("El elemento no es el esperado", new Integer(5), lista.get(0));
		}
		catch(IndexOutOfBoundsException e)
		{
			fail("No debería lanzar la excepción, el índice se encuentra dentro de la lista.");
		}
		
		//Prueba con 20 elementos
		lista.clear();
		setupEscenario2();
		
		try
		{
			lista.add(-1, 5);
			fail("Debería lanzar la excepción, el índice se encuentra por fuera de la lista.");
		}
		catch(IndexOutOfBoundsException e)
		{
			//
		}
		
		try
		{
			lista.add(21, 5);
			fail("Debería lanzar la excepción, el índice se encuentra por fuera de la lista.");
		}
		catch(IndexOutOfBoundsException e)
		{
			//
		}
		
		try
		{
			lista.add(0, 5);
			assertEquals("El tamaño de la lista no es correcto", 21, lista.size());
			assertEquals("El elemento no es el esperado", new Integer(5), lista.get(0));
			assertEquals("El elemento no es el esperado", new Integer(350), lista.get(1));
			
			lista.add(21, 290);
			assertEquals("El tamaño de la lista no es correcto", 22, lista.size());
			assertEquals("El elemento no es el esperado", new Integer(290), lista.get(21));
			assertEquals("El elemento no es el esperado", new Integer(396), lista.get(20));
			
			lista.add(10, 580);
			assertEquals("El tamaño de la lista no es correcto", 23, lista.size());
			assertEquals("El elemento no es el esperado", new Integer(580), lista.get(10));
			assertEquals("El elemento no es el esperado", new Integer(80), lista.get(9));
			assertEquals("El elemento no es el esperado", new Integer(360), lista.get(11));
		}
		catch(IndexOutOfBoundsException e)
		{
			fail("No debería lanzar la excepción, el índice se encuentra dentro de la lista.");
		}
	}
	
	//Codigo basado en el ejercicio de nivel 9 de APO 2 (Honores) 201910
}