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
	
	public void cargarDatos()
	{
	}
	public int darNumViajes()
	{
	return datos.size();
	}
	public IListaSencillamenteEncadenada<Viaje> darViajesPorMesYZonaO(int pMes, int pIdO)
	{
	//pendiente
	IListaSencillamenteEncadenada<Viaje> lista = new ListaSencillamenteEncadenada<Viaje>();
	return lista;
	}
	public int darNumViajesPorMes(int pMes)
	{
	//pendiente
	return 0;
	}
}
