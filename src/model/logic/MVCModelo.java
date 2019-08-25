package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import model.data_structures.IEstructura;
import model.data_structures.Queue;
import model.data_structures.Stack;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private Stack<Viaje> pila;
	
	private Queue<Viaje> fila;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		pila = new Stack<Viaje>();
		
		fila = new Queue<Viaje>();
	}

	public void cargarDatos()
	{
		
	}

	public int darNumViajes()
	{
		return pila.size();
	}

	public IEstructura<Viaje> darViajesPorMesYZonaO(int pMes, int pIdO)
	{
		return null;
	}

	public int darNumViajesPorMes(int pMes)
	{
		return 0;
	}
}
