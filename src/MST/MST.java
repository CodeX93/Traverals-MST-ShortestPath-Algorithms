package MST;

import java.io.FileWriter;
import java.io.IOException;

public class MST {
	 private static final int V = 4039;
	 public int n;
	 

	   

   int minKey(int key[], Boolean mstSet[])
   {
       
       int min = Integer.MAX_VALUE, min_index = -1;

       for (int v = 0; v < V; v++)
           if (mstSet[v] == false && key[v] < min) {
               min = key[v];
               min_index = v;
               try {
      		      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/MST/prims.txt",true);
      		      myWriter.write("/n finding min  :"+min+"min_index :"+min_index+ System.getProperty( "line.separator" ));
      		      myWriter.close();
      		    
      		    } catch (IOException s) {
      		      System.out.println("An error occurred.");
      		      s.printStackTrace();
      		    }
           }

       return min_index;
   }

   // A utility function to print the constructed MST
   // stored in parent[]
   public static int[][] g = new int[4039][4039];
   public void addEdge(int x, int y)
   {
   	 
       if ((x >= n) || (y > n))
       {
          // System.out.println("Vertex does not exists!");
       }

       // checks if the vertex is connecting to itself
       if (x == y)
       {
           //System.out.println("Same Vertex!");
       }
       else
       {	//weights adjustment
           // connecting the vertices
           g[y][x] = 1;
           g[x][y] = 1;
       }
   }
   void printMST(int parent[], int graph[][])
   {
       System.out.println("Edge \tWeight");
       for (int i = 1; i < V; i++) {
    	   
    	   System.out.println(parent[i] + " - " + i + "\t"
                   + graph[i][parent[i]]);
    	   
    	   try {
    		      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/MST/prims.txt",true);
    		      myWriter.write("/n printing MST  parent"+parent[i]+" graph "+graph[i][parent[i]]+ System.getProperty( "line.separator" ));
    		      myWriter.close();
    		    
    		    } catch (IOException s) {
    		      System.out.println("An error occurred.");
    		      s.printStackTrace();
    		    } 
       }
           
   	
   }

   // Function to construct and print MST for a graph
   // represented using adjacency matrix representation
   void primMST()
   {
   	int graph[][] = new int[4039][4039]; 
       try {
			for(int i = 0; i< g.length; i++){
			    for (int j = 0; j < g[i].length; j++){
			        graph[i][j] = g[i][j];
			    }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       // Array to store constructed MST
       int parent[] = new int[V];

       // Key values used to pick minimum weight edge in
       // cut
       int key[] = new int[V];

       // To represent set of vertices included in MST
       Boolean mstSet[] = new Boolean[V];

       // Initialize all keys as INFINITE
       for (int i = 0; i < V; i++) {
           key[i] = Integer.MAX_VALUE;
           mstSet[i] = false;
           try {
 		      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/MST/prims.txt",true);
 		      myWriter.write("/n initializing keys and setting status to false :"+key[i]+ System.getProperty( "line.separator" ));
 		      myWriter.close();
 		    
 		    } catch (IOException s) {
 		      System.out.println("An error occurred.");
 		      s.printStackTrace();
 		    }
       }

       // Always include first 1st vertex in MST.
       key[0] = 0; // Make key 0 so that this vertex is
       // picked as first vertex
       parent[0] = -1; // First node is always root of MST

       // The MST will have V vertices
       for (int count = 0; count < V - 1; count++) {
           
           int u = minKey(key, mstSet);

          
           mstSet[u] = true;

    
           for (int v = 0; v < V; v++)

         
               if (graph[u][v] != 0 && mstSet[v] == false
                   && graph[u][v] < key[v]) {
            	   
                   parent[v] = u;
                   key[v] = graph[u][v];
                   try {
          		      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/MST/prims.txt",true);
          		      myWriter.write("/n parent :"+parent[v]+" key:"+key[v]+ System.getProperty( "line.separator" ));
          		      myWriter.close();
          		    
          		    } catch (IOException s) {
          		      System.out.println("An error occurred.");
          		      s.printStackTrace();
          		    }
                   
            
               }
       }

       // print the constructed MST
       printMST(parent, graph);
   }

}
