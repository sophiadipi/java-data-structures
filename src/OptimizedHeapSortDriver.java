/********************************************************************************************
* OptimizedHeapSortDriver.java
* 
* The OptimizedHeapSortDriver class demonstrates the funcionality of the OptimizedHeapSort
* algorithm. 
*********************************************************************************************/

import java.util.Arrays;

public class OptimizedHeapSortDriver 
{
    public static void main(String[] args)
    {
        // Create new OptimizedHeapSort object.
        OptimizedHeapSort<Integer> heapSorter = new OptimizedHeapSort<>();

        // Create unsorted array of integers.
        Integer[] data1 = {45, 32, 7, 19, 23, 1, 92};
        
        System.out.println("--------------------------------------------------------");
        System.out.println("TEST CASE 1: UNSORTED ARRAY");
        System.out.println("--------------------------------------------------------");

        System.out.println("Before heap sort: " + Arrays.toString(data1));
        System.out.println("\nApplying heap sort algorithm...\n");

        // Apply optimized heap sort algorithm.
        heapSorter.optimizedHeapSort(data1);
        System.out.println("After heap sort: " + Arrays.toString(data1));

        System.out.println("\n--------------------------------------------------------");
        System.out.println("TEST CASE 2: SORTED ARRAY");
        System.out.println("--------------------------------------------------------");

        // Create sorted array of integers. 
        Integer[] data2 = {97, 72, 66, 63, 45, 31, 20, 9};

        System.out.println("Before heap sort: " + Arrays.toString(data2));
        System.out.println("\nApplying heap sort algorithm...\n");

        // Apply optimized heap sort algorithm to already sorted array.
        heapSorter.optimizedHeapSort(data2);
        System.out.println("After heap sort: " + Arrays.toString(data2));

        System.out.println("\n--------------------------------------------------------");
        System.out.println("TEST CASE 3: EMPTY ARRAY");
        System.out.println("--------------------------------------------------------");

        // Create empty array.
        Integer[] data3 = {};

        System.out.println("Before heap sort: " + Arrays.toString(data3));
        System.out.println("\nApplying heap sort algorithm...\n");

        // Apply optimized heap sorting algorithm to empty array.
        heapSorter.optimizedHeapSort(data3);

        System.out.println("\n--------------------------------------------------------");
        System.out.println("TEST CASE 4: ARRAY CONTAINING ALL NULL ELEMENTS");
        System.out.println("--------------------------------------------------------");

        // Create array containing all null elements. 
        Integer[] data4 = new Integer[8];

        System.out.println("Before heap sort: " + Arrays.toString(data4));
        System.out.println("\nApplying heap sort algorithm...\n");

        // Apply optimized heap sorting algorithm to array of null elements. 
        heapSorter.optimizedHeapSort(data4);
    }
    
}
