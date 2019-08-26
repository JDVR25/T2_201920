package model.data_structures;

import java.util.Iterator;

public class Queue<E> extends ListaEncadenadaAbstracta<E>
{	
	@SuppressWarnings("unchecked")
	public Queue()
	{
		primerNodo = null;
	}
	
	public Queue(E element)
	{
		primerNodo = new Nodo<E>(element);
		cantidadElementos = 1;
	}

	public int indexOf(E element) 
	{
		int posicion = -1;
		Nodo<E> actual = primerNodo;
		int posActual = 0;
		boolean listo = false;
		while(actual != null && !listo)
		{
			if(actual.darElemento().equals((element)))
			{
				posicion = posActual;
				listo = true;
			}
			else
			{
				posActual ++;
				actual = actual.darSiguiente();
			}
		}

		return posicion;
	}

	/**
	 * Agrega un elemento que llega como parametro a la primera posicion de la lista
	 * @param elemento 
	 */
	public void enqueue(E elemento) 
	{
		boolean agregado = false;

		if(primerNodo == null)
		{
			primerNodo = new Nodo<E>(elemento);
			cantidadElementos = 1;
			agregado = true;
		}
		else
		{
			Nodo<E> nuevoPrimero= new Nodo<E>(elemento);
			nuevoPrimero.cambiarSiguiente(primerNodo);
			primerNodo = nuevoPrimero; 
			cantidadElementos++; 
			agregado = true;
		}
	}

	/**
	 * Remueve el ultimo elemento de la lista
	 * @returns E. El elemento eliminado. 
	 */
	public E dequeue() 
	{
		boolean removed;
		Nodo<E> actual = primerNodo; 
		E elementRemoved = null; 
		if (primerNodo == null)
		{
			removed = false; 
		}
		else if(primerNodo.darSiguiente() == null)
		{
			elementRemoved = primerNodo.darElemento(); 
			primerNodo = null; 
			removed = true; 
		}
		else 
		{	
			while(actual != null && actual.darSiguiente() != null) 
			{
				if (actual.darSiguiente().darSiguiente() == null)
				{
					elementRemoved = actual.darSiguiente().darElemento(); 
					actual.cambiarSiguiente(null);
				}
				else
				{
					actual = actual.darSiguiente(); 
				}
			}

			removed = true; 
		}
		return elementRemoved;
	}

	@Override
	public E getFirst()
	{
		Nodo<E> actual = primerNodo; 
		E lastElement = null; 
		if(primerNodo.darSiguiente() == null)
		{
			lastElement = primerNodo.darElemento(); 
		}
		else 
		{	
			while(actual != null && actual.darSiguiente() != null) 
			{
				if (actual.darSiguiente().darSiguiente() == null)
				{
					lastElement = actual.darSiguiente().darElemento(); 
				}
				else
				{
					actual = actual.darSiguiente(); 
				}
			}

		}
		return lastElement;
	}
}