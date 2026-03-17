/********************************************************************************************
* Sophia DiPietro (T00714296)
* 11/22/2024
*
* GraphDriver.java
* 
* The GraphDriver class demonstrates the funcionality of the Graph class. 
*********************************************************************************************/

import java.util.Iterator;
import jsjf.Graph;

public class GraphDriver 
{
    public static void main(String[] args)
    {
        Graph<String> myGraph = new Graph<>();

        System.out.println("\n---------------------------------------------------------------");
        System.out.println("ADDING VERTICES TO THE GRAPH:");
        System.out.println("---------------------------------------------------------------");

        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");
        myGraph.addVertex("E");
        myGraph.addVertex("F");

        System.out.println("\nNumber of vertices: " + myGraph.size());
        System.out.println("\nAdjacency matrix after adding vertices:\n" + myGraph.toString());

        System.out.println("\n---------------------------------------------------------------");
        System.out.println("ADDING EDGES BETWEEN VERTICES:");
        System.out.println("---------------------------------------------------------------");

        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("A", "D");
        myGraph.addEdge("A", "E");
        myGraph.addEdge("A", "F");
        myGraph.addEdge("B", "C");
        myGraph.addEdge("B", "D");
        myGraph.addEdge("B", "E");
        myGraph.addEdge("B", "F");
        myGraph.addEdge("C", "D");
        myGraph.addEdge("C", "E");
        myGraph.addEdge("C", "F");
        myGraph.addEdge("D", "E");
        myGraph.addEdge("D", "F");
        myGraph.addEdge("E", "F");

        System.out.println("\nNumber of vertices: " + myGraph.size());
        System.out.println("\nAdjacency matrix after adding edges:\n" + myGraph.toString());

        System.out.println("Is this graph connected?");
        if (myGraph.isConnected())
        {
            System.out.println("Yes, the graph is connected.");
        }
        else
        {
            System.out.println("No, the graph is not connected.");
        }

        System.out.println("\nWhat is the shortest path between vertex A and vertex B?");
        Iterator<String> shortestPathIterator = myGraph.iteratorShortestPath("A", "B");
        while (shortestPathIterator.hasNext()) 
        {
            System.out.println(shortestPathIterator.next() + " ");
        }

        System.out.println("\n---------------------------------------------------------------");
        System.out.println("REMOVING EDGES FROM THE GRAPH:");
        System.out.println("---------------------------------------------------------------");

        System.out.println("Adjacency matrix before edge removal:\n" + myGraph.toString());
        System.out.println("Is this graph connected?");
        if (myGraph.isConnected())
        {
            System.out.println("Yes, the graph is connected.\n");
        }
        else
        {
            System.out.println("No, the graph is not connected.\n");
        }


        myGraph.removeEdge("A", "B");
        myGraph.removeEdge("A", "C");
        myGraph.removeEdge("A", "E");
        myGraph.removeEdge("B", "E");
        myGraph.removeEdge("C", "E");
        myGraph.removeEdge("D", "E");
        myGraph.removeEdge("E", "F");

        System.out.println("\nAdjacency matrix after removing edges:\n" + myGraph.toString());

        System.out.println("Is this graph connected?");
        if (myGraph.isConnected())
        {
            System.out.println("Yes, the graph is connected.");
        }
        else
        {
            System.out.println("No, the graph is not connected.");
        }

        System.out.println("\nWhat is the shortest path between vertex A and vertex B?");
        Iterator<String> shortestPathIterator2 = myGraph.iteratorShortestPath("A", "B");
        while (shortestPathIterator2.hasNext()) 
        {
            System.out.println(shortestPathIterator2.next() + " ");
        }

        System.out.println("\n---------------------------------------------------------------");
        System.out.println("BREADTH-FIRST TRAVERSAL:");
        System.out.println("---------------------------------------------------------------");

        System.out.println("Adjacency matrix\n" + myGraph.toString());
        System.out.println("Starting at vertex A:");
        Iterator<String> bfsIterator = myGraph.iteratorBFS("A");
        while (bfsIterator.hasNext()) 
        {
            System.out.println(bfsIterator.next() + " ");
        }

        System.out.println("\nStarting at vertex D:");
        Iterator<String> bfsIterator2 = myGraph.iteratorBFS("D");
        while (bfsIterator2.hasNext()) 
        {
            System.out.println(bfsIterator2.next() + " ");
        }

        System.out.println("\n---------------------------------------------------------------");
        System.out.println("DEPTH-FIRST TRAVERSAL:");
        System.out.println("---------------------------------------------------------------");

        System.out.println("Adjacency matrix\n" + myGraph.toString());
        System.out.println("Starting at vertex A:");
        Iterator<String> dfsIterator = myGraph.iteratorDFS("A");
        while (dfsIterator.hasNext()) 
        {
            System.out.println(dfsIterator.next() + " ");
        }

        System.out.println("\nStarting at vertex D:");
        Iterator<String> dfsIterator2 = myGraph.iteratorDFS("D");
        while (dfsIterator2.hasNext()) 
        {
            System.out.println(dfsIterator2.next() + " ");
        }

        System.out.println("\n---------------------------------------------------------------");
        System.out.println("REMOVING A VERTEX FROM THE GRAPH:");
        System.out.println("---------------------------------------------------------------");

        System.out.println("Number of vertices before removal: " + myGraph.size());
        System.out.println("Adjacency matrix before vertex removal:\n" + myGraph.toString());

        System.out.println("Is this graph connected?");
        if (myGraph.isConnected())
        {
            System.out.println("Yes, the graph is connected.");
        }
        else
        {
            System.out.println("No, the graph is not connected.");
        }

        myGraph.removeVertex("E");

        System.out.println("\nNumber of vertices after removal: " + myGraph.size());
        System.out.println("Adjacency matrix after removal:\n" + myGraph.toString());

        System.out.println("Is this graph connected?");
        if (myGraph.isConnected())
        {
            System.out.println("Yes, the graph is connected.");
        }
        else
        {
            System.out.println("No, the graph is not connected.");
        }
        


       




    }
    
}
