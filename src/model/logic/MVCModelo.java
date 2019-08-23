package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

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
		CSVReader reader = null;
		try {
			for(int i = 1; i<3; i++)
			{
				reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-"+i+"-All-MonthlyAggregate.csv"));
				for(String[] param : reader)
				{
					try
					{
						Viaje nuevo = new Viaje(Integer.parseInt(param[0]), Integer.parseInt(param[1]), 
								Integer.parseInt(param[2]), Double.parseDouble(param[3]), Double.parseDouble(param[4]),
								Double.parseDouble(param[5]), Double.parseDouble(param[6]));
						datos.addFirst(nuevo);
					}
					catch(NumberFormatException e)
					{

					}
				}
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (reader != null)
			{
				try
				{
					reader.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}

		}
	}

	public int darNumViajes()
	{
		return datos.size();
	}

	public IListaSencillamenteEncadenada<Viaje> darViajesPorMesYZonaO(int pMes, int pIdO)
	{
		IListaSencillamenteEncadenada<Viaje> lista = new ListaSencillamenteEncadenada<Viaje>();
		for(Viaje temp: datos)
		{
			if(temp.darMes() == pMes && temp.darIDOrigen() == pIdO)
			{
				lista.addFirst(temp);
			}
		}
		return lista;
	}

	public int darNumViajesPorMes(int pMes)
	{
		int conteo = 0;
		for(Viaje temp: datos)
		{
			if(temp.darMes() == pMes)
			{
				conteo++;
			}
		}
		return conteo;
	}
}
