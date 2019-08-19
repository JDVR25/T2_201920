package model.data_structures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListaSencillamenteEncadenada<E> extends ListaEncadenadaAbstracta<E>
{

	/**
	 * Constante de serialización.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construye la lista vacía.
	 * <b>post: </b> Se ha inicializado el primer nodo en null
	 */
	public ListaSencillamenteEncadenada() 
	{
		//TODO 8.1.1 Complete de acuerdo a la documentación
		primerNodo = null;
	}

	/**
	 * Se construye una nueva lista cuyo primer nodo  guardará al elemento que llega por parámetro. Actualiza el número de elementos.
	 * @param nPrimero el elemento a guardar en el primer nodo
	 * @throws NullPointerException si el elemento recibido es nulo
	 */
	public ListaSencillamenteEncadenada(E nPrimero) throws NullPointerException
	{
		//TODO 8.1.2 Complete de acuerdo a la documentación
		primerNodo = new NodoListaSencilla<E>(nPrimero);
		cantidadElementos = 1;
	}

	@Override
	public boolean add(E elemento) 
	{
		//TODO 8.1.3 Complete de acuerdo a la documentación
		boolean agregado = false;

		if(primerNodo == null)
		{
			primerNodo = new NodoListaSencilla<E>(elemento);
			cantidadElementos = 1;
			agregado = true;
		}
		else
		{
			NodoListaSencilla<E> anterior = primerNodo;
			NodoListaSencilla<E> aAgregar = new NodoListaSencilla<E>(elemento);
			while(anterior.darSiguiente() != null)
				anterior = anterior.darSiguiente();
			anterior.cambiarSiguiente(aAgregar);
			cantidadElementos++;
			agregado = true;
		}

		return agregado;
	}

	@Override
	public void add(int index, E elemento) 
	{
		//TODO 8.1.4 Complete de acuerdo a la documentación
		NodoListaSencilla<E> nuevo = new NodoListaSencilla<E>(elemento);
		if(index < 0 || index > size())
		{
			throw new IndexOutOfBoundsException();
		}
		else if(index == 0)
		{
			nuevo.cambiarSiguiente(primerNodo);
			primerNodo = nuevo;
			cantidadElementos++;
		}
		else
		{
			int posicion = 1;
			NodoListaSencilla<E> anterior = primerNodo;
			while(posicion < index)
			{
				anterior = anterior.darSiguiente();
				posicion++;
			}
			nuevo.cambiarSiguiente(anterior.darSiguiente());
			anterior.cambiarSiguiente(nuevo);
			cantidadElementos++;
		}
	}

	@Deprecated
	public ListIterator<E> listIterator() 
	{
		throw new UnsupportedOperationException ();
	}

	@Deprecated
	public ListIterator<E> listIterator(int index) 
	{
		throw new UnsupportedOperationException ();
	}


	@Override
	public boolean remove(Object objeto) 
	{
		//TODO 8.1.5 Complete de acuerdo a la documentación
		boolean respuesta = false;

		E elemento = (E)objeto;
		if(primerNodo != null)
		{
			if(primerNodo.darElemento().equals(elemento))
			{
				primerNodo = primerNodo.darSiguiente();
				respuesta = true;
				cantidadElementos--;
			}
			else
			{
				NodoListaSencilla<E> anterior = primerNodo;
				while(anterior != null && !respuesta && anterior.darSiguiente() != null)
				{
					if(anterior.darSiguiente().darElemento().equals(elemento))
					{
						anterior.cambiarSiguiente(anterior.darSiguiente().darSiguiente());
						respuesta = true;
						cantidadElementos--;
					}
					anterior = anterior.darSiguiente();
				}
			}
		}

		return respuesta;
	}

	@Override
	public E remove(int pos) 
	{
		//TODO 8.1.6 Complete de acuerdo a la documentación
		E borrado = null;
		if(pos < 0 || pos > size() - 1 || primerNodo == null)
		{
			throw new IndexOutOfBoundsException();
		}
		else if(pos == 0)
		{
			borrado = primerNodo.darElemento();
			primerNodo = primerNodo.darSiguiente();
			cantidadElementos--;
		}
		else
		{
			int posicion = 1;
			NodoListaSencilla<E> anterior = primerNodo;
			while(posicion < pos)
			{
				anterior = anterior.darSiguiente();
				posicion++;
			}
			borrado = anterior.darSiguiente().darElemento();
			anterior.cambiarSiguiente(anterior.darSiguiente().darSiguiente());
			cantidadElementos--;
		}

		return borrado;
	}

	@Override
	public boolean retainAll(Collection<?> coleccion) 
	{
		//TODO 8.1.7 Complete de acuerdo a la documentación
		boolean respuesta = false;

		if(primerNodo != null)
		{ int pos = 1;
		NodoListaSencilla<E> anterior = primerNodo;
		while(anterior.darSiguiente() != null)
		{
			if(!coleccion.contains(anterior.darSiguiente().darElemento()))
			{
				remove(pos);
				if(!respuesta)
				{
					respuesta = true;
				}
			}
			else
			{
				anterior = anterior.darSiguiente();
				pos++;
			}
		}
		if(!coleccion.contains(primerNodo.darElemento()))
		{
			remove(0);
			if(!respuesta)
			{
				respuesta = true;
			}
		}
		}
		return respuesta;
	}

	@Override
	public List<E> subList(int inicio, int fin) 
	{
		//TODO 8.1.8 Complete de acuerdo a la documentación
		List<E> lista = new ListaSencillamenteEncadenada<E>();

		if(inicio < 0 || fin > size() ||inicio > fin)
		{
			throw new IndexOutOfBoundsException();
		}
		int conteo = 0;
		NodoListaSencilla<E> nodo = primerNodo;
		while(conteo < fin && nodo != null)
		{
			if(inicio <= conteo)
			{
				lista.add(nodo.darElemento());
			}
			nodo = nodo.darSiguiente();
			conteo++;
		}
		return lista;
	}

}
