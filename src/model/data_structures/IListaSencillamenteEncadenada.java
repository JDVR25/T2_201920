package model.data_structures;

public interface IListaSencillamenteEncadenada<E> extends Iterable<E>
{
	public int size();

	public E set(int index, E element) throws IndexOutOfBoundsException;

	public boolean isEmpty();

	public E get(int index) throws IndexOutOfBoundsException;

	public boolean contains(Object o);

	public void clear();

	public boolean add(E elemento);

	public void add(int index, E elemento);

	public boolean remove(Object objeto);

	public E remove(int pos);

	public Object[] toArray();
}
