package Traversals;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private int vertex;       /* total number number of vertices in the graph */
    private LinkedList<Integer> adj[];      /* adjacency list */
    private Queue<Integer> que;           /* maintaining a queue */

    public BFS(int v) {
        vertex = v;
        adj = new LinkedList[vertex];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
            try {
  		      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/Traversals/bfstrace.txt",true);
  		      myWriter.write("adding linkedlist in adj array "+System.getProperty( "line.separator" ));
  		      
  		      myWriter.close();
  		      
  		    } catch (IOException e) {
  		      System.out.println("An error occurred.");
  		      e.printStackTrace();
  		    }
        }
        que = new LinkedList<Integer>();
    }

    public void insertEdge(int v, int w) {
        adj[v].add(w);   
        try {
		      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/Traversals/bfstrace.txt",true);
		      myWriter.write("adding vertice : "+v+System.getProperty( "line.separator" ));
		      
		      myWriter.close();
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }/* adding an edge to the adjacency list (edges are bidirectional in this example) */
    }

   public  void BFS(int n) {
        boolean nodes[] = new boolean[vertex];       /* initialize boolean array for holding the data */
        int a = 0;
        nodes[n] = true;
        que.add(n);   
        try {
		      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/Traversals/bfstrace.txt",true);
		      myWriter.write("adding node in queue : "+n +System.getProperty( "line.separator" ));
		      
		      myWriter.close();
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }/* root node is added to the top of the queue */
        while (que.size() != 0) {
            n = que.poll();      
            try {
    		      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/Traversals/bfstrace.txt",true);
    		      myWriter.write("removing top element: "+n+System.getProperty( "line.separator" ));
    		      
    		      myWriter.close();
    		      
    		    } catch (IOException e) {
    		      System.out.println("An error occurred.");
    		      e.printStackTrace();
    		    }/* remove the top element of the queue */
            System.out.print(n + " ");    /* print the top element of the queue */
            for (int i = 0; i < adj[n].size(); i++)  /* iterate through the linked list and push all neighbors into queue */ {
                a = adj[n].get(i);
                if (!nodes[a])      /* only insert nodes into queue if they have not been explored already */ {
                    nodes[a] = true;
                    que.add(a);
                    try {
            		      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/Traversals/bfstrace.txt",true);
            		      myWriter.write("adding in que : "+a+System.getProperty( "line.separator" ));
            		      
            		      myWriter.close();
            		      
            		    } catch (IOException e) {
            		      System.out.println("An error occurred.");
            		      e.printStackTrace();
            		    }
                }
            }
        }
    }
}
