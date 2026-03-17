/********************************************************************************************
* OptimizedHeapSort.java
* 
* The OptimizedHeapSort class implements an optimized version of the heap sorting algorithm 
* from the textbook by using a minheap to sort an array in descending order. The omptimizedHeapSort()
* method builds the heap in place with the input array to be sorted (as described in section 21.5 of 
* the textbook). It extends the Comparable class to ensure that the elements to be sorted in the array 
* are comparable.
* This class contains three methods:
*   1. optimizedHeapSort(): builds the heap in place and sorts the array using the swap()
*      and heapify() methods. 
*   2. heapify(): ensures the minheap property is maintained by comparing each node with its
*      children and using the swap() method to swap two elements when necessary and recursively 
*      calling heapify().
*   3. swap(): swaps two elements in an array.
*********************************************************************************************/

public class OptimizedHeapSort<T extends Comparable<T>>
{
    /* Method to perform a heap sort by bulding a minheap in place and repeatedly extracting 
     * the root element (smallest element) and placing it at the end of the result array. */
    public void optimizedHeapSort(T[] data)
    {
        boolean nullElements = true;
        
        for (int i = 0; i < data.length; i++)
        {
            if (data[i] != null)
            {
                nullElements = false;
                break;
            }
        }

        if (data.length == 0 || nullElements)
        {
            System.out.println("The array is empty. Heap sorting cannot be applied. ");
            return;
        }

        int heapSize = data.length;

        /* Step 1: Build the heap in place. Start from the last non-leaf node and move up the tree. */
        for (int currentIndex = (heapSize/2) - 1; currentIndex >= 0; currentIndex--)
        {
            /* Apply heapify to ensure the subtree rooted at each node satisfies the minheap 
             * property (root is smaller than or equal to both children). */
            heapify(data, currentIndex, heapSize);
        }

        /* Step 2: Sort the array. Extract elements one at a time and move them to the end of the 
         * array. */
        for (int lastElementIndex = data.length - 1; lastElementIndex > 0; lastElementIndex--)
        {
            // Swap the root (smallest element) with the last element in the heap.
            swap(data, 0, lastElementIndex);

            // Restore the heap property for the reduced heap.
            heapify(data, 0, lastElementIndex);
        }
    }

    /* Method to maintain the minheap property (the value of each node should be less than or equal 
     * the value of its children). */
    private void heapify(T[] data, int rootIndex, int heapSize)
    {
        int smallestElementIndex = rootIndex;   // Initialize smallest element as root.
        int leftChildIndex = 2 * rootIndex + 1;     // Left child index.
        int rightChildIndex = 2 * rootIndex + 2;    // Right child index.

        // Check if the left child is smaller than the current smallest element.
        if (leftChildIndex < heapSize && data[leftChildIndex] != null 
            && data[leftChildIndex].compareTo(data[smallestElementIndex]) < 0)
        {
            smallestElementIndex = leftChildIndex;
        }

        // Check if the right child is smaller than the current smallest element.
        if (rightChildIndex < heapSize && data[rightChildIndex] != null 
            && data[rightChildIndex].compareTo(data[smallestElementIndex]) < 0)
        {
            smallestElementIndex = rightChildIndex;
        }

        /* If the smallest element is not the root (meaning it is one of the child nodes), swap the root 
         * element with the smallest element and heapify the affected subtree to ensure the minheap 
         * property is still satisfied. */
        if (smallestElementIndex != rootIndex)
        {
            swap(data, rootIndex, smallestElementIndex);
            heapify(data, smallestElementIndex, heapSize);
        }
    }

    /* Method to swap the values at two specified indices in an array. */
    private void swap(T[] data, int index1, int index2)
    {
        T temp = data[index1];          // Store the element at index1 in temp.
        data[index1] = data[index2];    // Assign the element at index2 to index1.
        data[index2] = temp;            // Assign temp (the original element at index1) to index2.
    }
}
