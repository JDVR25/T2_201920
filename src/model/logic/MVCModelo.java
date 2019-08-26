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
		CSVReader reader = null;
		try 
		{

			reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-1-All-HourlyAggregate.csv"));
			for(String[] nextLine : reader) 
			{
				System.out.println("col1: " + nextLine[0] + ", col2: "+ nextLine[1]);
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
	
	public Stack whatYouWanted(int hour, int howManyYouWant)
	{
		Stack stack1 = new Stack(); 
		int i = 0;
		while (i < howManyYouWant && !pila.isEmpty() )
		{
			Viaje temp = pila.pop(); 
			if (temp.darhora() == hour)
			{
				stack1.push(temp);
				i++; 
			}
		}
		return stack1; 
	}

	public Queue eliminateCluster(int hour)
	{
		Queue fila1 = new Queue(); 
		Queue fila2 = new Queue(); 
		for(int i = 0; i < fila.size(); i++ )
		{
			Viaje temp = fila.dequeue();
			if (temp.darhora() == hour && fila2.isEmpty())
			{
				fila2.enqueue(temp);
			}
			else if (((Viaje) fila2.getFirst()).darhora() < temp.darhora())
			{
				fila2.enqueue(temp);
			}
			else
			{
				if(fila2.size() > fila1.size())
				{
					fila1 = fila2; 
				}
				
				fila2 = new Queue(); 
			}
		}
		
		if(fila2.size() > fila1.size())
		{
			fila1 = fila2; 
		}
		
		return fila1; 
	}
}
