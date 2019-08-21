package model.data_structures;

public interface IListaSencillamenteEncadenada<E> extends Iterable<E>
{
	public int size();

	public boolean isEmpty();

	public E get(int index) throws IndexOutOfBoundsException;

	public boolean contains(Object o);

	public void clear();

	public boolean addLast(E elemento);

	public void add(int index, E elemento);

	public boolean remove(Object objeto);

	public E remove(int pos);

	public Object[] toArray();
	
	public boolean addFirst();
	
	public boolean removeFirst();
	
	public boolean removeLast();

	public int indexOf(Object o);
}
