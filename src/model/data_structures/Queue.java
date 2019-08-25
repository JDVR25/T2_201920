package model.data_structures;

import java.util.Iterator;

public class Queue<E> implements IEstructura<E>
{
	private int cantidadElementos;
	
	private E[] arreglo;
	
	public Queue()
	{
		cantidadElementos = 0;
		
		arreglo = (E[]) new Object[2];
	}

	@Override
	public Iterator<E> iterator()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E getFirst()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear()
	{
		// TODO Auto-generated method stub
		
	}

}
