package ShortestPath;

import java.io.FileWriter;
import java.io.IOException;

public class Dijkstragraph {
	 private int n;
	 
	    // adjacency matrix
	    private int[][] g = new int[4039][4039];
	 
	    // constructor
	    Dijkstragraph(int x)
	    {
	        this.n = x;
	        int i, j;
	 
	   
	        for (i = 0; i < n; ++i)
	        {
	            for (j = 0; j < n; ++j)
	            {
	                g[i][j] = 0;
	            }
	        }
	    }
	 
	    public void displayAdjacencyMatrix()
	    {
	        System.out.print("\n\n Adjacency Matrix:");
	 
	        // displaying the 2D array
	        for (int i = 0; i < n; ++i)
	        {
	            System.out.println();
	            for (int j = 0; j < n; ++j)
	            {
	                System.out.print(" " + g[i][j]);
	            }
	        }
	    }
	 
	    public void addEdge(int x, int y)
	    {
	        // checks if the vertex exists in the graph
	        if ((x >= n) || (y > n))
	        {
	            System.out.println("Vertex does not exists!");
	        }
	 
	        // checks if the vertex is connecting to itself
	        if (x == y)
	        {
	            System.out.println("Same Vertex!");
	        }
	        else
	        {	//weights adjustment
	            // connecting the vertices
	            g[y][x] = 1;
	            g[x][y] = 1;
	        }
	    }
	 
	
	 
	   

	    
	    static final int V = 4039;
	    int minDistance(int dist[], Boolean sptSet[])
	    {
	        
	        int min = Integer.MAX_VALUE, min_index = -1;
	 
	        for (int v = 0; v < V; v++)
	            if (sptSet[v] == false && dist[v] <= min) {
	                min = dist[v];
	                min_index = v;
	            }
	 
	        return min_index;
	    }
	    
	    
	    
	 
	    
	    void printSolution(int dist[])
	    {	int diameter=0;
	        System.out.println(
	            "Vertex \t\t Distance from Source");
	        for (int i = 0; i < V; i++) {
	        	 System.out.println(i + " \t\t " + dist[i]);
	        	 
	        	 try {
		  		      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/ShortestPath/Dijkstratrace1.txt",true);
		  		      myWriter.write("distance of vertice  :"+i+" is : "+dist[i]+System.getProperty( "line.separator" ));
		  		      
		  		      myWriter.close();
		  		      
		  		    } catch (IOException e) {
		  		      System.out.println("An error occurred.");
		  		      e.printStackTrace();
		  		    }
	        	 if(diameter>=dist[i]) {
		        		diameter=diameter;
		        	}
	        	 else {
	        		 diameter=dist[i];
	        	 }
	        }
	        System.out.print("your diameter is "+diameter);
			try {
				FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/ShortestPath/Dijkstratrace1.txt",true);
				myWriter.write(" Diameter = "+diameter+System.getProperty( "line.separator" ));

				myWriter.close();

			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
	        	
	           
	    }
	 
	    
	    void dijkstra( int src ,int s1)
	    {
	    	 int [][] graph=new int [s1][s1];
	    	    for(int i = 0; i< g.length; i++){
	    	        for (int j = 0; j < g[i].length; j++){
	    	            graph[i][j] = g[i][j];
	    	        }
	    	    }
	        int dist[] = new int[V]; 
	        Boolean sptSet[] = new Boolean[V];
	 
	        // Initialize all distances as INFINITE and stpSet[]
	        // as false
	        for (int i = 0; i < V; i++) {
	            dist[i] = Integer.MAX_VALUE;
	            sptSet[i] = false;
	            
	            try {
		  		      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/ShortestPath/Dijkstratrace1.txt",true);
		  		      myWriter.write("initalizaing distance to infintiy and setting status to false :"+dist[i]+sptSet[i]+System.getProperty( "line.separator" ));
		  		      
		  		      myWriter.close();
		  		      
		  		    } catch (IOException e) {
		  		      System.out.println("An error occurred.");
		  		      e.printStackTrace();
		  		    }
	        	
	        }
	       
	 
	  
	        dist[src] = 0;
	 
	      
	        for (int count = 0; count < V - 1; count++) {
	      
	            int u = minDistance(dist, sptSet);
	 
	            // Mark the picked vertex as processed
	            sptSet[u] = true;
	 
	            for (int v = 0; v < V; v++) {
	            	  if (!sptSet[v] && graph[u][v] != 0
	  	                    && dist[u] != Integer.MAX_VALUE
	  	                    && dist[u] + graph[u][v] < dist[v]) {
	            		  dist[v] = dist[u] + graph[u][v];
	            		  
	            		  
	            		  try {
	    		  		      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/ShortestPath/Dijkstratrace1.txt",true);
	    		  		      myWriter.write("calculating distance  :"+dist[v]+" at these points of matrix  :"+u+" "+v+System.getProperty( "line.separator" ));
	    		  		      
	    		  		      myWriter.close();
	    		  		      
	    		  		    } catch (IOException e) {
	    		  		      System.out.println("An error occurred.");
	    		  		      e.printStackTrace();
	    		  		    }
	            	  }
	  	                    
	            }
	 
	            
	              
	            
	            
	        }
	 
	        // print the constructed distance array
	        printSolution(dist);
}
}
