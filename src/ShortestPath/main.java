package ShortestPath;

import ShortestPath.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> source=new ArrayList<>();
		ArrayList<Integer> destination=new ArrayList<>();
		ArrayList<Integer> weight=new ArrayList<>();
		
		Graph g=new Graph();
		try {
		      File myObj = new File("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/f.txt");
		      Scanner myReader = new Scanner(myObj);
		      int m=0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String strings[] = data.split(" ");
		        int x=Integer.parseInt(strings[0]);
		        int y=Integer.parseInt(strings[1]);
		        source.add(x);
		        destination.add(y);
		        weight.add(1);
		       m++; 
		     
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		for(int i=0;i<destination.size();i++) {
			
			g.addNewEdge(source.get(i), destination.get(i), true);
			
			
		}
		

		//System.out.println("graph"+g.toString());
		//g.countVertices();
		//g.countEdges(true);
		//g.containsVertex(0);   
		//g.containsVertex(5);
/*		destination.add(1);
		destination.add(2);
		destination.add(2);
		destination.add(3);
		destination.add(4);
		destination.add(2);
		destination.add(1);
		destination.add(3);
		source.add(0);
		source.add(0);
		source.add(1);
		source.add(1);
		source.add(1);
		source.add(3);
		source.add(3);
		source.add(4);
		weight.add(-1);
		weight.add(4);
		weight.add(3);
		weight.add(2);
		weight.add(2);
		weight.add(5);
		weight.add(1);
		weight.add(-3);
		
		*/
	
		long start = System.nanoTime();
		bellmangraph bell = createGraph(g.countVertices(),source,destination,weight);  
		int distance[] = new int[bell.getV()];  
		boolean hasNegativeCycle = getShortestPaths(bell, 0, distance);  
		if(!hasNegativeCycle)   
		{  
		System.out.println("Vertex \t: Distance");      
		for(int i = 0; i < distance.length; i++)  
		System.out.println("\t"+i + " " + "\t\t"+(distance[i] == Integer.MAX_VALUE ? "-" : distance[i]));
		}   
		else   
		{  
		System.out.println("Negative cycle exists in the graph, no solution found!!!");  
		}  
		
		 System.out.println("d="+destination.size());
		 System.out.println("s="+source.size());
		 long end = System.nanoTime();

		 long execution = (end - start);
		 System.out.println("bellman Execution time: " + execution + " nanoseconds");
		
		 long start2=System.nanoTime();
		 
		 Dijkstragraph obj = new Dijkstragraph(g.countVertices());

	        // calling methods
		 for(int j=0;j<destination.size();j++) {
				obj.addEdge(source.get(j), destination.get(j));
				try {
				      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/ShortestPath/Dijkstratrace1.txt",true);
				      myWriter.write(" adding edge of source "+source.get(j)+"  destination: "+destination.get(j)+System.getProperty( "line.separator" ));

				      myWriter.close();

				    } catch (IOException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
			}
		 System.out.print("dijkstra");
		 obj.dijkstra(0,g.countVertices());
		 long end2 = System.nanoTime();

		 long execution2 = (end2 - start2);
		 System.out.println("dijkstra Execution time: " + execution2 + " nanoseconds");

		
	}
	
	
	private static bellmangraph createGraph(int vertice, ArrayList<Integer> source,ArrayList<Integer> destination,ArrayList<Integer> weight)   
	{  
		  
	int v = vertice;  

	bellmangraph graph = new bellmangraph(v);  
	//adding edges to the graph  
	for(int j=0;j<destination.size();j++) {
		graph.addEdge(source.get(j), destination.get(j), weight.get(j));
		
		try {
		      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/ShortestPath/bellmantrace.txt",true);
		      myWriter.write(" adding edge of source "+source.get(j)+"  destination: "+destination.get(j)+" weight: "+weight.get(j)+System.getProperty( "line.separator" ));
		      
		      myWriter.close();
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	
	      
	  
	return graph;  
	}  
	
	
	
	public static boolean getShortestPaths(bellmangraph g, int source, int[] distance)   
	{  
	int V = g.getV();  
	//initializing distances from source to other vertices  
	for(int i = 1; i < V; i++)   
	{  
	distance[i] = Integer.MAX_VALUE;  
	
	try {
	      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/ShortestPath/bellmantrace.txt",true);
	      myWriter.write("/n intializing distance  from source to other vertices :"+distance[i]+ System.getProperty( "line.separator" ));
	      myWriter.close();
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}  
	//source vertex initialize to 0  
	distance[source] = 0;  
	//relaxing edges  
	for(int i = 1; i < V; i++)   
	{  
	//iterate over edges      
	for(Edge e: g.getEdges())   
	{  
	int u = e.getU(), v = e.getV(), w = e.getW();  
	if(distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + w)   
	{
		System.out.println(distance[i]);
		try {
		      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/ShortestPath/bellmantrace.txt",true);
		      myWriter.write("/n finding distance of vertice  "+e.getV()+ System.getProperty( "line.separator" ));
		      myWriter.close();
		    
		    } catch (IOException s) {
		      System.out.println("An error occurred.");
		      s.printStackTrace();
		    }     
	distance[v] = distance[u] + w;  
	}  
	}  
	}  
	//checks if there exist negative cycles in graph G  
	for(Edge e: g.getEdges())   
	{  
	int u = e.getU(), v = e.getV(), w = e.getW();  
	if(distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + w)   
	{  
	return true;  
	}  
	}  
	return false;  
	}  
}  


