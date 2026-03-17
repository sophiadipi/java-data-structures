/********************************************************************************************
* ArrayUnorderedList.java
* 
* ArrayUnorderedList represents an array implementation of an unordered list. From the course
* textbook. 
*********************************************************************************************/
package jsjf;

import jsjf.exceptions.*;

public class ArrayUnorderedList<T> extends ArrayList<T> 
implements UnorderedListADT<T>
{
	/* Creates an empty list using the default capacity. */
	public ArrayUnorderedList()
	{
		super();
	}

	/* Creates an empty list using the specified capacity.*/
	public ArrayUnorderedList(int initialCapacity)
	{
		super(initialCapacity);
	}

	@Override
	/* Adds the specified element to the front of this list. */
	public void addToFront(T element)
	{
		// To be completed as a Programming Project
	}

	@Override
	/* Adds the specified element to the rear of this list. */
	public void addToRear(T element)
	{
		// To be completed as a Programming Project
	}

	@Override
	/* Adds the specified element after the specified target element.
	 * Throws an ElementNotFoundException if the target is not found. */
	public void addAfter(T element, T target)
	{
		if (size() == list.length)
			expandCapacity();

		int scan = 0;

		// find the insertion point
		while (scan < rear && !target.equals(list[scan])) 
			scan++;

		if (scan == rear)
			throw new ElementNotFoundException("UnorderedList");

		scan++;

		// shift elements up one
		for (int shift = rear; shift > scan; shift--)
			list[shift] = list[shift - 1];

		// insert element
		list[scan] = element;
		rear++;
		modCount++;
	}
}
