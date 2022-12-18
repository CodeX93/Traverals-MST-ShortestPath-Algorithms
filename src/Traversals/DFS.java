package Traversals;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DFS {

    private final int V;
    private LinkedList<Integer> adj[]; /*adjacency list representation*/
    private final List<List<Integer>> ADJ;
    private boolean visited[];

    public DFS(int V) /*'V' is the number of vertices in the graph*/ {
        this.V=V;
        adj = new LinkedList[V];
        ADJ = new ArrayList<>(V);
        visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<Integer>();
            ADJ.add(new LinkedList<>());
            try {
  		      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/Traversals/dfstrace.txt",true);
  		      myWriter.write("visiting vertices and adding into ADJ array : "+System.getProperty( "line.separator" ));
  		      
  		      myWriter.close();
  		      
  		    } catch (IOException e) {
  		      System.out.println("An error occurred.");
  		      e.printStackTrace();
  		    }
        }

    }
    public boolean isCyclicUtil(int i, boolean[] visited,
                                 boolean[] recStack) {

        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;
        recStack[i] = true;
        List<Integer> children = ADJ.get(i);

        for (Integer c : children)
            if (isCyclicUtil(c, visited, recStack))
                return true;

        recStack[i] = false;

        return false;
    }

     public boolean isCyclic()
    {
        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;
        return false;
    }

    /* Adding an edge to the graph */
   public void insertEdge(int src, int dest) {
        adj[src].add(dest);
       ADJ.get(src).add(dest);
       try {
		      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/Traversals/dfstrace.txt",true);
		      myWriter.write("adding edge of src: "+src+" destination :"+dest+System.getProperty( "line.separator" ));
		      
		      myWriter.close();
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
    }

    public void DFS(int vertex) {
        visited[vertex] = true; /*Mark the current node as visited*/
        System.out.print(vertex + " ");

        Iterator<Integer> it = adj[vertex].listIterator();
        while (it.hasNext()) {
        	
            int n = it.next();
            try {
    		      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/Traversals/dfstrace.txt",true);
    		      myWriter.write("visiting vertex "+n+System.getProperty( "line.separator" ));
    		      
    		      myWriter.close();
    		      
    		    } catch (IOException e) {
    		      System.out.println("An error occurred.");
    		      e.printStackTrace();
    		    }
            if (!visited[n])
                DFS(n);
        }


    }


}
