/*@authors Keerthi Manu,Nithin,Pranathi,Namratha*/

package cs6301.g22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import cs6301.g22.CC.CCVertex;
import cs6301.g22.Graph.Vertex;

public class BFS {
	Queue<Graph.Vertex> q = new LinkedList<>();
	HashMap<Graph.Vertex,Graph.Vertex> p=new HashMap<>();
	LinkedList<Graph.Vertex> path = new LinkedList<>();
	
	// Class to store information about a vertex in this algorithm
	class BFSVertex {
		Graph.Vertex element;
		boolean seen;
		
		BFSVertex(Graph.Vertex u) {
		    element = u;
		    seen = false;
		    
		}
	}
	 // Algorithm uses a parallel array for storing information about vertices
		 BFSVertex[] bfsVertex;
		    Graph g;

		    public BFS(Graph g) {
			this.g = g;
			bfsVertex = new BFSVertex[g.size()];
			
			for(Graph.Vertex u: g) { bfsVertex[u.name] = new BFSVertex(u); }
		    }
		    
		    // Main algorithm for finding the path of g using BFS

		    LinkedList<Graph.Vertex> findBFS() {
		    	LinkedList<Graph.Vertex> path1=new LinkedList();
		    	   	for(Graph.Vertex u: g) {
		    	    if(!seen(u)) {
		    		 	path1=	bfsVisit(u);
		    	   }
		    	   	}
					return path1;
		        }

		    
		        LinkedList<Graph.Vertex> bfsVisit(Graph.Vertex u) {
		        	if(!seen(u))
		    		 {
		        	
		    	      q.add(u);
		    	      visit(u);
		    		 }
		        	for(Graph.Edge e: u) {
		    	    Graph.Vertex v = e.otherEnd(u);
		    		if(!seen(v))
		    		 {
		    	      q.add(v);
		    	      p.put(v, u);
		    		 }
		    	    visit(v);    
		    	}
		    	if(! q.isEmpty())
		    	{
		    	  Graph.Vertex v1 = q.remove();
		    	  path.add(v1);
		    	  bfsVisit(v1);
		    	 }
		    	
				return path;
		    	
		        }

		        boolean seen(Graph.Vertex u) {
		        	BFSVertex ccu = getBFSVertex(u);
		        	return ccu.seen;
		            }

		            
		        // Visit a node by marking it as seen 
		            void visit(Graph.Vertex u) {
		        	BFSVertex ccu = getBFSVertex(u);
		        	ccu.seen = true;
		        	
		            }
		            
		         // From Vertex to CCVertex 
		            BFSVertex getBFSVertex(Graph.Vertex u) {
		            	return bfsVertex[u.name];
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
		BFS bb = new BFS(g);
		 path=bb.findBFS();
		 System.out.println(" BFS Path :"+path);

	}
	
}
