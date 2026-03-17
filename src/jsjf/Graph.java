/********************************************************************************************
* Graph.java
* 
* The Graph class implements an undirected, unweighted graph using an adjacency matrix. It
* implements the GraphADT interface, supporting basic graph methods like adding and removing 
* vertices/edges, performing breadth-first and depth-firest traversals, finding the 
* shortest path between two vertices, and checking the connectedness of the graph. 
*********************************************************************************************/

package jsjf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class Graph<T> implements GraphADT<T> 
{
    protected static final int DEFAULT_CAPACITY = 5;   
    protected int numVertices;  // Number of vertices in the graph
    protected boolean[][] adjMatrix;  // Adjacency matrix to represent the graph
    protected T[] vertices;           // Array to store values of the vertices
    protected int modCount;
    
    @SuppressWarnings("unchecked")
    /* Constructor to initialize an empty graph with the default capacity. */
    public Graph()
    {
        numVertices = 0;
        this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[])(new Object[DEFAULT_CAPACITY]);
    }

    @Override
    /* Adds a vertex to the graph, expanding the capacity of the graph if necessary. */
    public void addVertex(T vertex)
    {
        System.out.println("Adding new vertex '" + vertex + "' to the graph...");

        /* If the number of vertices in the graph is greater than or equal to the 
         * number size of the adjacency matrix, the adjacency matrix is expanded
         * to accommodate the new vertex. */
        if (numVertices >= adjMatrix.length)
        {
            System.out.println("\nGraph is full. Expanding capacity...\n");
            expandCapacity();
        }

        // Add the new vertex to the vertices array
        vertices[numVertices] = vertex;

        // Add the new vertex to the adjacency matrix with no initial edges. 
        for (int i = 0; i < numVertices; i++)
        {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }

        // Increment the number of vertices to reflect the addition of a vertice.
        numVertices++;

        // Incremenet the modCount. 
        modCount++;
    }

    @Override 
    /* Removes a vertex and all edges associated with it. */
    public void removeVertex(T vertex)
    {
        int index = getIndex(vertex);

        // Checks if the index of the vertex to be removed is valid. 
        if (indexIsValid(index))
        {
            // Remove all edges associated with the vertex.
            for (int i = 0; i < numVertices; i++)
            {
                adjMatrix[index][i] = false;
                adjMatrix[i][index] = false;
            }

            // Shift rows and columns in adjancecy matrix to remove the vertex.
            for (int i = index; i < numVertices - 1; i++)
            {
                // Moves each vertex one position to the left.
                vertices[i] = vertices[i + 1];

                for (int j = 0; j < numVertices; j++)
                {
                    adjMatrix[i][j] = adjMatrix[i + 1][j];
                    adjMatrix[j][i] = adjMatrix[j][i + 1];
                }
            }

            vertices[numVertices - 1] = null;   // Clear the last vertex.
            numVertices--;      // Decrement the vertice count to reflect the removal of a vertex.
            modCount++;     // Increment the mod count.
        }
    }
    
    @Override
    /* Inserts an edge between two vertices of the graph. */
    public void addEdge(T vertex1, T vertex2)
    {
        System.out.println("Adding an edge between vertex " + vertex1 + " and vertex " + vertex2 + "...");
        addEdgeHelper(getIndex(vertex1), getIndex(vertex2));
    }

    /* Helper method to add an edge between two vertices. */
    public void addEdgeHelper(int index1, int index2)
    {
        // Ensures that the vertices both exist in the vertices array.
        if (indexIsValid(index1) && indexIsValid(index2))
        {
            // Sets the corresponding positions in the adjacency matrix to true, indicating an edge exists.
            adjMatrix[index1][index2] = true;
            adjMatrix[index2][index1] = true;
            modCount++;
        }
    }

    @Override
    /* Removes an edge between two vertices of the graph. */
    public void removeEdge(T vertex1, T vertex2)
    {
        System.out.println("Removing the edge between vertex " + vertex1 + " and vertex " + vertex2 + "...");
        removeEdgeHelper(getIndex(vertex1), getIndex(vertex2));
    }

    /* Helper method to remove an edge between two vertices. */
    public void removeEdgeHelper(int index1, int index2)
    {
        // Ensures that the vertices both exist in the vertices array.
        if (indexIsValid(index1) && indexIsValid(index2))
        {
            /* Sets the corresponding positions in the adjacency matrix to true, indicating the 
             * edge between the two vertices no longer exists. */
            adjMatrix[index1][index2] = false; 
            adjMatrix[index2][index1] = false;
            modCount++;
        }
    }

    @Override
    /* Returns an iterator that performs a breadth-first traversal of the graph starting from
     * the specified vertex. */
    public Iterator<T> iteratorBFS(T startVertex)
    {
        // Retrieves index of the starting vertex in the vertices array.
        int startIndex = getIndex(startVertex);
        
        /* Throws an exception if the start vertex is not found in the vertices array (meaning 
         * it doesn't exist in the graph). */
        if (!indexIsValid(startIndex))
        {
            throw new IllegalArgumentException("Invalid start index: " + startIndex);
        }

        // Array to track whether or not a vertex has been visited. 
        boolean[] visited = new boolean[numVertices];   

        // Queue to manage the breadth-first traversal order. 
        Queue<Integer> queue = new LinkedList<>();

        // ArrayList to store the result of the traversal. 
        ArrayList<T> result = new ArrayList<>();

        // Add starting vertex to the queue and mark it as visited.
        queue.add(startIndex);
        visited[startIndex] = true;

        // Loop to continue traversing as long as there are elements (vertices) in the queue.
        while (!queue.isEmpty())
        {
            // Removes the front element of the queue (next vertex to be processed) and stores it in currentIndex.
            int currentIndex = queue.poll();
            
            // Add the current vertex to the result list. 
            result.add(vertices[currentIndex]);

            // Check if each vertex adjacent to the current one has been visited.
            for (int i = 0; i < numVertices; i++)
            {
                /* Checks that there is an edge between the current vertex and vertex i and that vertex i
                 * has not yet been visited. If both are true, vertex i is added to the queue for future 
                 * processing and marked as visited. */
                if (adjMatrix[currentIndex][i] && !visited[i])
                {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        // Returns an iterator over the result list.
        return result.iterator();
    }

    @Override
    /* Returns an iterator that performs a depth-first traversal of the graph starting from
     * the specified vertex. */
    public Iterator<T> iteratorDFS(T startVertex)
    {
        // Retrieves index of the starting vertex in the vertices array.
        int startIndex = getIndex(startVertex);

        /* Throws an exception if the start vertex is not found in the vertices array (meaning 
         * it doesn't exist in the graph). */
        if (!indexIsValid(startIndex))
        {
            throw new IllegalArgumentException("Invalid start index: " + startIndex);
        }

        // Array to track whether or not a vertex has been visited. 
        boolean[] visited = new boolean[numVertices];

        // Stack to manage the depth-first traversal order. 
        Stack<Integer> stack = new Stack<>();

        // ArrayList to store the result of the traversal.
        ArrayList<T> result = new ArrayList<>();

        // Push the starting vertex index onto the stack to being traversal.
        stack.push(startIndex);

        // Loop to continue traversing as long as there are elements (vertices) in the stack.
        while (!stack.isEmpty())
        {
            // Pop the top vertex from the stack (next vertex to be processed) and store it in currentIndex.
            int currentIndex = stack.pop();

            /* If currentIndex has not been visited yet, mark it as visited and add it to the result 
             * list. */
            if (!visited[currentIndex])
            {
                visited[currentIndex] = true;
                result.add(vertices[currentIndex]);

                /* Iterates through all of the vertices to find neighbours of the current vertex. */
                for (int i = numVertices - 1; i >= 0; i--)
                {
                    /* If there is an edge between the current vertex and i and vertex i has not yet
                     * been visited, push vertex i onto the stack. */
                    if (adjMatrix[currentIndex][i] && !visited[i])
                    {
                        stack.push(i);
                    }
                }
            }
        }
        // Returns an iterator over the result list. 
        return result.iterator();
    }

    @Override 
    /* Returns an iterator over the shortest path between the specificed starting vertex and 
     * target vertex. This method uses a breadth-first traversal to determine the shortest path. */
    public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex)
    {
        // Retrieves the index of the specified starting vertex in the vertices array.
        int startIndex = getIndex(startVertex);

        // Retrieves the index of the specified target index in the vertices array.
        int targetIndex = getIndex(targetVertex);

        // Throws an exception if the starting and/or target indices are not found in the vertices array.
        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex))
        {
            throw new IllegalArgumentException("Invalid start or target index.");
        }

        // Array to keep track of the predecessors of each vertex in the shortest path.
        int[] predecessors = new int[numVertices];
        Arrays.fill(predecessors, -1);

        // Queue to manage the breadth-first traversal. 
        Queue<Integer> queue = new LinkedList<>();

        // Array to track which vertices have been visited. 
        boolean[] visited = new boolean[numVertices];

        // Add starting vertex to the queue and mark it as visited.
        queue.add(startIndex);
        visited[startIndex] = true;

        // Loop to continue traversing as long as there are elements (vertices) in the queue.
        while(!queue.isEmpty())
        {
            // Removes the front element of the queue (next vertex to be processed) and stores it in currentIndex.
            int currentIndex = queue.poll();

            // If the current vertex is the target vertex, we have found the shortest path and can stop traversing.
            if (currentIndex == targetIndex)
            {
                break;
            }

            // Iterates through all of the vertices to find neighbours of the current vertex.
            for (int i = 0; i < numVertices; i++)
            {
                /* If there is an edge between the current vertex and i and vertex i has not yet
                 * been visited, mark vertex i as visited, set the predecessor of i to be the 
                 * index of the current vertex, and add vertex i to the queue for later processing. */
                if (adjMatrix[currentIndex][i] && !visited[i])
                {
                    visited[i] = true;
                    predecessors[i] = currentIndex;
                    queue.add(i);
                }
            }
        }

        /* ArrayList to store the vertices of the shortest path from the specified starting vertex to the 
         * specified target vertex. */
        ArrayList<T> path = new ArrayList<>();

        /* Reconstruct the shortest path by following the predecessors from the target vertex back to the start vertex. */
        for (int i = targetIndex; i != -1; i = predecessors[i])
        {
            // Add each vertex to the front of the path (since the loop is in reverse order).
            path.add(0, vertices[i]);
        }

        /* If the first vertex in the reconstructed path is the startVertex, it means a valid path exists. */
        if (path.get(0).equals(startVertex))
        {
            return path.iterator();
        }

        /* If a valid path is not found, return null. */
        System.out.println("No path exists between the specified vertices.");
        return null;
    }

    @Override
    /* Returns true if the graph is empty and false otherwise. */
    public boolean isEmpty()
    {
        // Graph is empty when the number of vertices is equal to zero.
        return numVertices == 0;
    }

    @Override
    /* Returns true if the graph is connected and false if it is not. A graph is
     * considered connected if there is a path between every pair of vertices 
     * in the graph. */
    public boolean isConnected()
    {
        // If the graph is empty, it cannot be connected.
        if (isEmpty())
        {
            return false;
        }

        // Perform a breadth-first traversal starting from the first vertex.
        Iterator<T> bfsIterator = iteratorBFS(vertices[0]);
        
        // Counter to track the number of vertices visited.
        int count = 0;

        // Continuing traversing while there are still vertices in the iterator.
        while (bfsIterator.hasNext())
        {
            // Move to the next vertex.
            bfsIterator.next();

            // Increment the count for each vertex visited.
            count++;
        }

        /* If the number of vertices visited is equal to the total number of vertices in the 
         * graph, the graph is connected because all of the vertices are connected to the starting
         * vertex. */
        return count == numVertices;
    }

    @Override
    /* Returns the size of the graph. */
    public int size()
    {
        return numVertices;
    }


    /* Creates new arrays to store the contents of the graph with twice the capacity. */
    @SuppressWarnings("unchecked")
    protected void expandCapacity()
    {
        // Expanded array to store vertices with double the capacity of the vertices array.
        T[] expandedVertices = (T[])(new Object[vertices.length * 2]);

        // Expanded adjacency matrix with double the capacity of the original adjacency matrix.
        boolean[][] expandedAdjMatrix = new boolean[vertices.length * 2][vertices.length * 2];

        /* Copies the existing vertices and edges from the existing vertices array and adjacency
         * matrix into the new expanded versions. */
        for (int i = 0; i < numVertices; i++)
        {
            for (int j = 0; j < numVertices; j++)
            {
                expandedAdjMatrix[i][j] = adjMatrix[i][j];
            }
            expandedVertices[i] = vertices[i];
        }
        // Updates the current vertices array reference to point to the new expanded array.
        vertices = expandedVertices;

        // Updates the current adjacency matrix reference to point to the new expanded adjacency matrix.
        adjMatrix = expandedAdjMatrix;
    }

    /* Returns true if the specified index exists in the vertices array and false otherwise.  */
    private boolean indexIsValid(int index)
    {
        return index >= 0 && index < numVertices;
    }

    /* Returns the index of the specified vertex in the vertices array. */
    private int getIndex(T vertex)
    {
        for (int i = 0; i < numVertices; i++)
        {
            if (vertices[i].equals(vertex))
            {
                return i;
            }
        }
        // Throws an exception if the vertex does not exist. 
        throw new NoSuchElementException("Vertex not found.");
    }

    @Override
    /* Returns a string representation of the graph as an adjacency matrix. */
    public String toString()
    {
        String result = "";

        for (int i = 0; i < numVertices; i++)
        {
            for (int j = 0; j < numVertices; j++)
            {
                if (adjMatrix[i][j])
                {
                    result = result + "1 ";
                }
                else
                {
                    result = result + "0 ";
                }
            }
            result += "\n";
        }
        return result;
    }
    
}
