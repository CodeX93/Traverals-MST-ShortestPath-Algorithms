package MST;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Prims {

	 public static void main(String[] args)
	    {
	    	ArrayList<Integer> source=new ArrayList<>();
			ArrayList<Integer> destination=new ArrayList<>();
			ArrayList<Integer> weight=new ArrayList<>();
			ArrayList<Integer> degree=new ArrayList<>();
			long start = System.nanoTime();

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
	   MST t = new MST();
	      for(int i=0;i<source.size();i++) {
	    	    t.addEdge(source.get(i), destination.get(i));
	      }
	        t.primMST();
	        long end= System.nanoTime();  
	        long e=end-start;
	        countFrequencies(source);
			System.out.println("\nExecution Prims time = "+e);
}
	 
	 public static void countFrequencies(ArrayList<Integer> list)
	    {
	        int sum=0;
	        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
	 
	        for (int i : list) {
	            Integer j = hm.get(i);
	            hm.put(i, (j == null) ? 1 : j + 1);
	        }
	 
	        // displaying the occurrence of elements in the arraylist
	        for (Map.Entry<Integer, Integer> val : hm.entrySet()) {
	            System.out.println("Element " + val.getKey() + " "
	                               + "occurs"
	                               + ": " + val.getValue() + " times");
	            
	            try {
	    		      FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/MST/prims.txt",true);
	    		      myWriter.write("/n degree of vertice:"+val.getKey()+" is: "+val.getValue()+ System.getProperty( "line.separator" ));
	    		      myWriter.close();
	    		    
	    		    } catch (IOException s) {
	    		      System.out.println("An error occurred.");
	    		      s.printStackTrace();
	    		    }
	            sum=val.getValue()+sum;
	        }
	        double avg=sum/4031;
	        System.out.print("AVERAGE DEGREE : "+avg);
			try {
				FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/MST/prims.txt",true);
				myWriter.write("/n Average degree of vertices: is: "+avg+ System.getProperty( "line.separator" ));
				myWriter.close();

			} catch (IOException s) {
				System.out.println("An error occurred.");
				s.printStackTrace();
			}
	        
	       
	    }
}