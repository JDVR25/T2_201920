package model.data_structures;

import java.io.Serializable;
import java.util.Iterator;

import uniandes.cupi2.apo2H.estructuras.NodoListaSencilla;

/**
 * Clase que contiene lo común entre las listas encadenadas.
 * @param <E> Elemento que se almacenará en la lista, el elemento debe ser únicamente identificado.
 */
public abstract class ListaEncadenadaAbstracta<E> implements IListaSencillamenteEncadenada<E>, Serializable
{

	/**
	 * Constante de serialización.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo que indica la cantidad de elementos que han sido almacenados en la lista.
	 */
	protected int cantidadElementos;

	/**
	 * Primer nodo de la lista.
	 */
	protected NodoListaSencilla<E> primerNodo;

	@Override
	@SuppressWarnings("unchecked")
	public Object[] toArray() 
	{
		E[] arreglo = (E[]) new Object[size()];
		NodoListaSencilla<E> actual = primerNodo;
		int pos = 0;
		while(actual != null)
		{
			arreglo[pos] = actual.darElemento();
			actual = actual.darSiguiente();
			pos ++;
		}

		return arreglo;
	}
	
	@Override
	public int size() 
	{
		return cantidadElementos;
	}

	@Override
	public Iterator<E> iterator() 
	{
		return new IteradorSencillo<E>(primerNodo);
	}

	@Override
	public boolean isEmpty() 
	{
		return cantidadElementos == 0? true: false;
	}
	
	@Override
	public int indexOf(Object o) 
	{
		//TODO 7.1.5 Complete de acuerdo a la documentación
		int posicion = -1;
		NodoListaSencilla<E> actual = primerNodo;
		int posActual = 0;
		boolean listo = false;
		while(actual != null && !listo)
		{
			if(actual.darElemento().equals((o)))
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

	@Override
	public E get(int index) throws IndexOutOfBoundsException
	{
		NodoListaSencilla<E> nodo = primerNodo;
		E retornar = null;

		int i = 0;
		if(index >= size() || index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			while(i != index)
			{
				nodo = nodo.darSiguiente();
				i++;
			}
			retornar = nodo.darElemento();
		}

		return retornar;
	}

	/**
	 * Devuelve el nodo de la posición dada
	 * @param pos la posición  buscada
	 * @return el nodo en la posición dada 
	 * @throws IndexOutOfBoundsException si index < 0 o index >= size()
	 */
	public NodoListaSencilla<E> darNodo(int index)
	{
		if(index < 0 || index > cantidadElementos)
		{
			throw new IndexOutOfBoundsException("Se está pidiendo el indice: " + index + " y el tamaño de la lista es de " + cantidadElementos);
		}

		NodoListaSencilla<E> actual = primerNodo;
		int posActual = 0;
		while(actual != null && posActual < index)
		{
			actual = actual.darSiguiente();
			posActual ++;
		}

		return actual;
	}

	@Override
	public boolean contains(Object o) 
	{
		boolean contiene = false;
		int i = 0;
		NodoListaSencilla<E> nodo = primerNodo;
		if(primerNodo != null)
		{

			while(i < size() && !contiene && nodo != null)
			{
				if(nodo.darElemento().equals(o))
				{
					contiene = true;
				}
				nodo = nodo.darSiguiente();

				i++;
			}
		}
		return contiene;
	}	

	@Override
	public void clear() 
	{
		primerNodo = null;
		cantidadElementos = 0;
	}
	//Codigo basado en lo desarrollado en el ejercicio de nivel 9 de APO 2 (Honores) 201910
}
