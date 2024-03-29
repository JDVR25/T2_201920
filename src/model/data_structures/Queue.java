package model.data_structures;

import java.util.Iterator;

public class Queue<E> extends ListaEncadenadaAbstracta<E>
{	
	protected Nodo<E> ultimo;
	@SuppressWarnings("unchecked")
	public Queue()
	{
		primerNodo = null;
		ultimo = null;
	}
	
	public Queue(E element)
	{
		primerNodo = new Nodo<E>(element);
		ultimo = primerNodo;
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
			ultimo = primerNodo;
			cantidadElementos = 1;
			agregado = true;
		}
		else
		{
			Nodo<E> nuevo= new Nodo<E>(elemento);
			ultimo.cambiarSiguiente(nuevo);
			ultimo = nuevo; 
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
		E removed = null;
		if (primerNodo != null)
		{
			removed = primerNodo.darElemento();
			primerNodo = primerNodo.darSiguiente();
			cantidadElementos--;
		}
		return removed; 
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