import Graph.*;
import java.io.*;
import java.util.*;

public class AddEdgeCommand implements Command {
	Graph graph;
	
	public Graph execute()
	{
		try {
			Scanner scanner = new Scanner(System.in);
			char from, to;
			Node fromNode, toNode;
			int distance;
			
			System.out.println("Enter node name (a-z), state the edge from the node of: ");
			from = scanner.nextLine().toUpperCase().charAt(0);
			
			if(!graph.haveNode(from))
			{
				System.out.println(from + " does not exist!");
				return graph;
			}
			
			System.out.println("Enter node name (a-z), state the edge to the node of: ");
			to = scanner.nextLine().toUpperCase().charAt(0);
			
			if(!graph.haveNode(to))
			{
				System.out.println(to + " does not exist!");
				return graph;
			}
			
			if(graph.isConnected(from, to))
			{
				System.out.println("Node " + from + " Node " + to + " is already connected!");
				return graph;
			}
			
			System.out.println("Enter the distance :");
			distance = (int)scanner.nextInt();
			
			fromNode = graph.getNode(from);
			toNode = graph.getNode(to);
			
			Edge edge = new Edge(fromNode, toNode, distance);
			Edge edgeReverse = new Edge(toNode, fromNode, distance);
			
			graph.addEdge(from , edge);
			graph.addEdge(to, edgeReverse);
			
			return graph;
			
			
		}catch (Exception e) {
			System.out.println("*** " + e.getMessage());
		}
		
		return graph;
	}
	
	public void setGraph(Graph graph){
		this.graph = graph;
	}

}