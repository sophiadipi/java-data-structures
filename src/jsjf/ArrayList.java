/********************************************************************************************
* Sophia DiPietro (T00714296)
* 11/22/2024
*
* ArrayList.java
* 
* ArrayList represents an array implementation of a list. The front of the list is kept at 
* array index 0. This class will be extended to create a specific kind of list. From the 
* course textbook.
*********************************************************************************************/

package jsjf;

import java.util.*;
import jsjf.exceptions.*;

/* ArrayList represents an array implementation of a list. The front of
 * the list is kept at array index 0. This class will be extended
 * to create a specific kind of list. */
public abstract class ArrayList<T> implements ListADT<T>
{
	private static final int DEFAULT_CAPACITY = 100;
	private static final int NOT_FOUND = -1;

	protected int rear;
	protected T[] list; 
	protected int modCount;

	/* Creates an empty list using the default capacity. */
	public ArrayList()
	{
		this(DEFAULT_CAPACITY);
	}

	/* Creates an empty list using the specified capacity. */
	@SuppressWarnings("unchecked")
	public ArrayList(int initialCapacity)
	{
		rear = 0;
		list = (T[])(new Object[initialCapacity]);
		modCount = 0;
	}

	/* Creates a new array to store the contents of this list with
	 * twice the capacity of the old one. Called by descendant classes
	 * that add elements to the list. */
	protected void expandCapacity()
	{
		// To be completed as a Programming Project
	}

	@Override
	/* Removes and returns the last element in this list. */
	public T removeLast() throws EmptyCollectionException
	{
		// To be completed as a Programming Project
		
		return null;  // temp
	}

	@Override
	/* Removes and returns the first element in this list. */
	public T removeFirst() throws EmptyCollectionException
	{
		// To be completed as a Programming Project
		
		return null;  // temp
	}

	@Override
	/* Removes and returns the specified element. */
	public T remove(T element)
	{
		T result;
		int index = find(element);

		if (index == NOT_FOUND)
			throw new ElementNotFoundException("ArrayList");

		result = list[index];
		rear--;

		// shift the appropriate elements 
		for (int scan = index; scan < rear; scan++)
			list[scan] = list[scan+1];

		list[rear] = null;
		modCount++;

		return result;
	}

	@Override
	/* Returns a reference to the element at the front of this list.
	 * The element is not removed from the list.  Throws an
	 * EmptyCollectionException if the list is empty.  */
	public T first() throws EmptyCollectionException
	{
		// To be completed as a Programming Project
		
		return null;  // temp
	}

	@Override
	/* Returns a reference to the element at the rear of this list.
	 * The element is not removed from the list. Throws an
	 * EmptyCollectionException if the list is empty.  */
	public T last() throws EmptyCollectionException
	{
		// To be completed as a Programming Project
		
		return null;  // temp
	}

	@Override
	/* Returns true if this list contains the specified element. */
	public boolean contains(T target)
	{
		return (find(target) != NOT_FOUND);
	}

	/* Returns the array index of the specified element, or the
	 * constant NOT_FOUND if it is not found. */
	private int find(T target)
	{
		int scan = 0; 
		int result = NOT_FOUND;

		if (!isEmpty())
			while (result == NOT_FOUND && scan < rear)
				if (target.equals(list[scan]))
					result = scan;
				else
					scan++;

		return result;
	}

	@Override
	/* Returns true if this list is empty and false otherwise. */
	public boolean isEmpty()
	{
		// To be completed as a Programming Project
		
		return true;  // temp
	}

	@Override
	/* Returns the number of elements currently in this list. */
	public int size()
	{
		// To be completed as a Programming Project
		
		return 0;  // temp
	}

	@Override
	/* Returns a string representation of this list.  */
	public String toString()
	{
		// To be completed as a Programming Project
		
		return "";  // temp
	}

	@Override
	/* Returns an iterator for the elements currently in this list. */
	public Iterator<T> iterator()
	{
		return new ArrayListIterator();
	}

	/* ArrayListIterator iterator over the elements of an ArrayList. */
	private class ArrayListIterator implements Iterator<T>
	{
		int iteratorModCount;
		int current;

		/* Sets up this iterator using the specified modCount. */
		public ArrayListIterator()
		{
			iteratorModCount = modCount;
			current = 0;
		}

		@Override
		/* Returns true if this iterator has at least one more element
		 * to deliver in the iteration. */
		public boolean hasNext() throws ConcurrentModificationException
		{
			if (iteratorModCount != modCount)
				throw new ConcurrentModificationException();

			return (current < rear);
		}

		@Override
		/* Returns the next element in the iteration. If there are no
		 * more elements in this iteration, a NoSuchElementException is
		 * thrown. */
		public T next() throws ConcurrentModificationException
		{
			if (!hasNext())
				throw new NoSuchElementException();

			current++;

			return list[current - 1];
		}

		@Override
		/* The remove operation is not supported in this collection. */
		public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

	}	
}
