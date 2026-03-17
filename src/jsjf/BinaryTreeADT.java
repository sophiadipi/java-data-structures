/********************************************************************************************
* BinaryTreeADT.java
* 
* BinaryTreeADT defines the interface to a binary tree data structure. From the course
* textbook.
*********************************************************************************************/
package jsjf;

import java.util.Iterator;

public interface BinaryTreeADT<T> 
{
	/* Returns a reference to the root element. */
	public T getRootElement();

	/* Returns true if this binary tree is empty and false otherwise. */
	public boolean isEmpty();

	/* Returns the number of elements in this binary tree. */
	public int size();

	/* Returns true if the binary tree contains an element that matches
	 * the specified element and false otherwise. */
	public boolean contains(T targetElement);

	/* Returns a reference to the specified element if it is found in 
	 * this binary tree. Throws an exception if the specified element
	 * is not found. */
	public T find(T targetElement);

	@Override
	/* Returns the string representation of this binary tree. */
	public String toString();

	/* Returns an iterator over the elements of this tree. */
	public Iterator<T> iterator();

	/* Returns an iterator that represents an inorder traversal on this binary tree.  */
	public Iterator<T> iteratorInOrder();

	/* Returns an iterator that represents a preorder traversal on this binary tree. */
	public Iterator<T> iteratorPreOrder();

	/* Returns an iterator that represents a postorder traversal on this binary tree. */
	public Iterator<T> iteratorPostOrder();

	/* Returns an iterator that represents a levelorder traversal on the binary tree. */
	public Iterator<T> iteratorLevelOrder();
}

