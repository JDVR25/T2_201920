package test.data_structures;

import model.data_structures.ListaSencillamenteEncadenada;

public class ListaSencillamenteEncadenadaTest extends ListaAbstractaNoOrdenadaTest 
{

	@Override
	public void setupEscenario1() 
	{
		lista = new ListaSencillamenteEncadenada<>();		
	}

	@Override
	public void testListIterator() {
		//No se probará en esta prueba.
	}
}
