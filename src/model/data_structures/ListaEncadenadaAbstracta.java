package model.data_structures;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**
 * Clase que contiene lo común entre las listas encadenadas.
 * @param <E> Elemento que se almacenará en la lista, el elemento debe ser únicamente identificado.
 */
public abstract class ListaEncadenadaAbstracta<E> implements List<E>, Serializable
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
	//TODO 7.1.1 Declara el primer nodo de la lista. Recuerde herencia.
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
	@SuppressWarnings("unchecked")
	public<U> U[] toArray(U[] array) 
	{
		if(array.length < size())
		{
			return (U[]) toArray();
		}
		else
		{
			NodoListaSencilla<E> actual = primerNodo;
			int pos =0;
			while(actual != null)
			{
				array[pos] = (U) actual.darElemento();
				actual = actual.darSiguiente();
				pos ++;
			}
			if(array.length > size())
			{
				array[size()] = null;
			}
			return array;
		}
	}


	@Override
	public int size() 
	{
		//TODO 7.1.2 Retorna el tamaño de la lista. Revise los atributos de la clase.
		return cantidadElementos;
	}

	@Override
	public E set(int index, E element) throws IndexOutOfBoundsException 
	{
		//TODO 7.1.3 Complete de acuerdo a la documentación
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
			nodo.cambiarElemento(element);
		}

		return retornar;
	}

	@Override
	public boolean removeAll(Collection<?> c) 
	{
		boolean modificado = false;
		for(Object objeto: c)
		{
			modificado |= remove(objeto);
		}
		return modificado;
	}

	@Override
	public int lastIndexOf(Object o)
	{
		int ultimaPosicion = -1;
		NodoListaSencilla<E> actual = primerNodo;
		int posActual = 0;
		while(actual != null)
		{
			if(actual.darElemento().equals((o)))
			{
				ultimaPosicion = posActual;
			}
			posActual ++;
			actual = actual.darSiguiente();
		}

		return ultimaPosicion;
	}

	@Override
	public Iterator<E> iterator() 
	{
		return new IteradorSencillo<E>(primerNodo);
	}

	@Override
	public boolean isEmpty() 
	{
		//TODO 7.1.4 Complete de acuerdo a la documentación
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
		//TODO 7.1.6 Complete de acuerdo a la documentación
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
	public boolean containsAll(Collection<?> c) 
	{
		boolean contiene = true;
		for(Object objeto: c)
		{
			contiene &= contains(objeto);
		}
		return contiene;
	}

	@Override
	public boolean contains(Object o) 
	{
		//TODO 7.1.7 Complete de acuerdo a la documentación
		boolean contiene = false;
		int i = 0;
		NodoListaSencilla<E> nodo = primerNodo;
		if(primerNodo != null)
		{
			//			E elemento = nodo.darElemento();

			while(i < size() && !contiene && nodo != null)
			{
				if(nodo.darElemento().equals(o))
				{
					contiene = true;
				}
				nodo = nodo.darSiguiente();
				//				elemento = nodo.darElemento();

				i++;
			}
		}
		return contiene;
	}	

	@Override
	public void clear() 
	{
		//TODO 7.1.8 Complete de acuerdo a la documentación
		primerNodo = null;
		cantidadElementos = 0;
	}

	@Override
	public boolean addAll(int pos, Collection<? extends E> c) 
	{
		//TODO 7.1.9 Complete de acuerdo a la documentación
		int inicial = size();
		int posicion = pos;
		for(E actual: c)
		{
			add(posicion, actual);
			posicion++;
		}
		return inicial < size()? true: false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) 
	{
		boolean modificado = false;
		for(E actual: c)
		{
			modificado |= add(actual);
		}
		return modificado;
	}

}
