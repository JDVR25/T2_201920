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
	//TODO 6.1.1 Declare como atributo el elemento que se almacenará en el nodo
	protected E elemento;

	/**
	 * Siguiente nodo.
	 */
	//TODO 6.1.2 Declare una referencia al siguiente elemento
	protected NodoListaSencilla<E> siguiente;

	/**
	 * Constructor del nodo.
	 * @param elemento El elemento que se almacenará en el nodo. elemento != null
	 */
	public NodoListaSencilla(E elemento)
	{
		//TODO 6.1.3 Asigne el elemento que llega como parámetro al atributo
		this.elemento = elemento;
	}

	/**
	 * Método que cambia el siguiente nodo.
	 * <b>post: </b> Se ha cambiado el siguiente nodo
	 * @param siguiente El nuevo siguiente nodo
	 */
	public void cambiarSiguiente(NodoListaSencilla<E> siguiente)
	{
		//TODO 6.1.4 Cambie el siguiente nodo por el que llega como parámetro
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

}
