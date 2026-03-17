/********************************************************************************************
* Sophia DiPietro (T00714296)
* 11/22/2024
*
* ListADT.java
* 
* ListADT defines the interface to a general list collection. Specific types of lists will 
* extend this interface to complete the set of necessary operations. From the course textbook.
*********************************************************************************************/
package jsjf;

import java.util.Iterator;

public interface ListADT<T> extends Iterable<T>
{
	/* Removes and returns the first element from this list. */
	public T removeFirst();

	/* Removes and returns the last element from this list. */
	public T removeLast();

	/* Removes and returns the specified element from this list. */
	public T remove(T element);

	/* Returns a reference to the first element in this list. */
	public T first();

	/* Returns a reference to the last element in this list. */
	public T last();

	/* Returns true if this list contains the specified target element. */
	public boolean contains(T target);

	/* Returns true if this list contains no elements. */
	public boolean isEmpty();

	/* Returns the number of elements in this list. */
	public int size();

	@Override
	/* Returns an iterator for the elements in this list. */
	public Iterator<T> iterator();

	@Override
	/* Returns a string representation of this list. */
	public String toString();
}
