/*@authors Keerthi Manu,Nithin,Pranathi,Namratha*/

package cs6301.g22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import cs6301.g22.Graph.Vertex;

public class Diameter {
 //Method to find the diameter in a graph
	public static LinkedList<Graph.Vertex> Diameter(Graph g)
	{
		LinkedList<Graph.Vertex> path = new LinkedList<>();
		LinkedList<Graph.Vertex> path1 = new LinkedList<>();
		LinkedList<Graph.Vertex> dia = new LinkedList<>();
	//First run of BFS	
  		BFS bb = new BFS(g);
		 path=bb.findBFS();
		
	//Second run of BFS	 
		 BFS bb1 = new BFS(g);
		 path1=bb1.bfsVisit(path.getLast());
		 dia= findpath(path1.getFirst(),path1.getLast(),bb1.p);
		 return dia;
	}
	
	//Method to find the path between the extreme nodes
	
	public static  LinkedList<Graph.Vertex> findpath(Graph.Vertex source,Graph.Vertex destination,HashMap p)
	{
		LinkedList<Graph.Vertex> d = new LinkedList<>();
		d.add(destination);
		while(destination!=source)
		{
			destination=(Vertex) p.get(destination);
			d.addFirst(destination);
			
		}
		return d;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in;
	        if (args.length > 0) {
	            File inputFile = new File(args[0]);
	            in = new Scanner(inputFile);
	        } else {
	            in = new Scanner(System.in);
	        }
		Graph g = Graph.readGraph(in);
		LinkedList<Graph.Vertex> path = new LinkedList<>();
		path=Diameter.Diameter(g);
		System.out.println("Diameter :"+path);
		
		
	}

}
