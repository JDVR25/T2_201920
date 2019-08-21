package model.logic;

import model.data_structures.IListaSencillamenteEncadenada;
import model.data_structures.ListaSencillamenteEncadenada;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IListaSencillamenteEncadenada<Viaje> datos;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		datos = new ListaSencillamenteEncadenada<>();
	}
}
