package model.data_structures;

import java.io.Serializable;

/**
 * Representa un nodo dentro de la lista. Este nodo almacena un elemento.
 *
 * @param <E> Tipo de elemento que se está almacenando dentro de los nodos.
 */
public class NodoListaSencilla<E> implements Serializable
{

	/**
	 * Constante de Serialización
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Elemento almacenado en el nodo.
	 */
	protected E elemento;

	/**
	 * Siguiente nodo.
	 */
	protected NodoListaSencilla<E> siguiente;

	/**
	 * Constructor del nodo.
	 * @param elemento El elemento que se almacenará en el nodo. elemento != null
	 */
	public NodoListaSencilla(E elemento)
	{
		this.elemento = elemento;
	}

	/**
	 * Método que cambia el siguiente nodo.
	 * <b>post: </b> Se ha cambiado el siguiente nodo
	 * @param siguiente El nuevo siguiente nodo
	 */
	public void cambiarSiguiente(NodoListaSencilla<E> siguiente)
	{
		this.siguiente = siguiente;
	}

	/**
	 * Método que retorna el elemento almacenado en el nodo.
	 * @return El elemento almacenado en el nodo.
	 */
	public E darElemento()
	{
		return elemento;
	}

	/**
	 * Cambia el elemento almacenado en el nodo.
	 * @param elemento El nuevo elemento que se almacenará en el nodo.
	 */
	public void cambiarElemento(E elemento)
	{
		this.elemento = elemento;
	}


	/**
	 * Método que retorna el siguiente nodo.
	 * @return Siguiente nodo
	 */
	public NodoListaSencilla<E> darSiguiente()
	{
		return siguiente;
	}
	//Codigo basado en lo desarrollado en el ejercicio de nivel 9 de APO 2 (Honores) 201910
}
