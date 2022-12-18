import ShortestPath.Dijkstragraph;
import Traversals.BFS;
import Traversals.DFS;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FileRead fr=new FileRead();
        fr.readFromFile();
        int size= 4039;
        BFS b=new BFS(size);
        DFS d=new DFS(size);
        //Dijikstra dj=new Dijikstra(size);

        for(int i=0;i<FileRead.source.size();i++) {

            b.insertEdge(FileRead.source.get(i),FileRead.destination.get(i));
            d.insertEdge(FileRead.source.get(i),FileRead.destination.get(i));
            //dj.addEdge(FileRead.source.get(i),FileRead.destination.get(i));

        }
        System.out.println(size);
        System.out.println("Graph Created");
        long start = System.nanoTime();
        System.out.println();
        b.BFS(3);
        System.out.println();
        long end = System.nanoTime();
        long execution = (end - start);
        System.out.println("BFS Execution time: " + execution + " nanoseconds");
        
        long start2 = System.nanoTime();
        d.DFS(3);
        System.out.println();
        long end2 = System.nanoTime();
        long execution2 = (end2 - start2);
        System.out.println("DFS Execution time: " + execution2 + " nanoseconds");
        
        if(d.isCyclic()){
            try {
                FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/MST/cyclic.txt",true);
                myWriter.write("/n Graph Cyclic:\tTrue"+ System.getProperty( "line.separator" ));
                myWriter.close();

            } catch (IOException s) {
                System.out.println("An error occurred.");
                s.printStackTrace();
            }
            System.out.println("Graph contains cycle");
        }else {
            try {
                FileWriter myWriter = new FileWriter("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/MST/cyclic.txt",true);
                myWriter.write("Graph Cyclic:\tFalse"+ System.getProperty( "line.separator" ));
                myWriter.close();

            } catch (IOException s) {
                System.out.println("An error occurred.");
                s.printStackTrace();
            }
            System.out.println("Graph doesn't contain cycle");
        }


       // dj.dijkstra(0,size);





    }
}
