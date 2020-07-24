package Graph;

import java.util.*;

public class Dijkstra { 

	public Dijkstra(){}
	
    public void runDijkstra(int[][] graph, int source) 
	{ 
		int size = graph[0].length; 
		int[] shortestDistances = new int[size];  
        boolean[] visited = new boolean[size]; 
        int[] path = new int[size]; 

        //setting all the node to infinite distance
		for (int i = 0; i < size; i++) 
		{ 
			shortestDistances[i] = Integer.MAX_VALUE; 
			visited[i] = false; 
		} 
		
		shortestDistances[source] = 0; //source node, can go with 0 distance
		path[source] = -1; //empty path for source node

        // run Dijkstra
		for (int i = 1; i < size; i++) 
		{ 
			int neighbor = -1; 
            int shortestDistance = Integer.MAX_VALUE;
            
            //Pick up the minimum distance node from the graph, which start at the source node
			for (int j = 0;j < size;j++) 
			{ 
				if (!visited[j] && shortestDistances[j] < shortestDistance) 
				{ 
					neighbor = j; 
					shortestDistance = shortestDistances[j]; 
				} 
			}

			visited[neighbor] = true;   // mark visited node

			// Update the distance between the picked node and the neighbor
			for (int j = 0; j < size; j++) 
			{ 
				int distance = graph[neighbor][j]; 
				
				if (distance > 0 && ((shortestDistance + distance) < shortestDistances[j])) 
				{ 
					path[j] = neighbor; //record the path
					shortestDistances[j] = shortestDistance + distance; 
				} 
			}
		}

		printResult(source, shortestDistances, path); 
	}

	public void runDijkstra(Vector<Node> nodes, int[][] graph, int source) 
	{ 
		int size = graph[0].length; 
		int[] shortestDistances = new int[size];  
        boolean[] visited = new boolean[size]; 
        int[] path = new int[size]; 

        //setting all the node to infinite distance
		for (int i = 0; i < size; i++) 
		{ 
			shortestDistances[i] = Integer.MAX_VALUE; 
			visited[i] = false; 
		} 
		
		shortestDistances[source] = 0; //source node, can go with 0 distance
		path[source] = -1; //empty path for source node

        // run Dijkstra
		for (int i = 1; i < size; i++) 
		{ 
			int neighbor = -1; 
            int shortestDistance = Integer.MAX_VALUE;
            
            //Pick up the minimum distance node from the graph, which start at the source node
			for (int j = 0;j < size;j++) 
			{ 
				if (!visited[j] && shortestDistances[j] < shortestDistance) 
				{ 
					neighbor = j; 
					shortestDistance = shortestDistances[j]; 
				} 
			}

			visited[neighbor] = true;   // mark visited node

			// Update the distance between the picked node and the neighbor
			for (int j = 0; j < size; j++) 
			{ 
				int distance = graph[neighbor][j]; 
				
				if (distance > 0 && ((shortestDistance + distance) < shortestDistances[j])) 
				{ 
					path[j] = neighbor; //record the path
					shortestDistances[j] = shortestDistance + distance; 
				} 
			}
		}

		printResult(nodes, source, shortestDistances, path); 
	} 

	private static void printResult(int source, int[] distances, int[] path) 
	{  
		System.out.println("Source:" + source); 
		for (int i = 0; i < distances.length; i++) 
		{ 
			if (i != source) 
			{ 
                System.out.print(i + ":" + " Path: "); 
                printPath(i, path); 
				System.out.print(" Cost: " + distances[i] +"\n"); 
            }
            
		} 
    }
    
	private static void printPath(int currentNode, int[] path) 
	{ 
		if (currentNode == -1) 
		{ 
			return; 
		} 
		printPath(path[currentNode], path); 
		System.out.print(currentNode + ">"); 
    }
    
    private static void printResult(Vector<Node> nodes, int source, int[] distances, int[] path) 
	{  
		System.out.println("Source:" + nodes.elementAt(source).getName()); 
		for (int i = 0; i < distances.length; i++) 
		{ 
			if (i != source) 
			{ 
                System.out.print(nodes.elementAt(i).getName() + ":" + " Path: "); 
                printPath(nodes, i, path); 
				System.out.print(" Cost: " + distances[i] +"\n"); 
            }
            
		} 
    }
    
	private static void printPath(Vector<Node> nodes, int currentNode, int[] path) 
	{ 
		if (currentNode == -1) 
		{ 
			return; 
		} 
		//printPath(nodes.elementAt(path[currentNode]).getName(), path);
		printPath(nodes,path[currentNode], path, true);
		System.out.print(nodes.elementAt(currentNode).getName()); 
	}

	private static void printPath(Vector<Node> nodes, int currentNode, int[] path, boolean notLast) 
	{ 
		if (currentNode == -1) 
		{ 
			return; 
		} 
		//printPath(nodes.elementAt(path[currentNode]).getName(), path);
		printPath(nodes,path[currentNode], path , true);
		System.out.print(nodes.elementAt(currentNode).getName() + ">"); 
	}

}