import Graph.*;
import java.io.*;
import java.util.*;

public class AddNodeCommand implements Command{
	Graph graph;
	Node node;
	
	public Graph execute()
	{
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter node name (a-z): ");
			char nodeName;
			
			nodeName = scanner.nextLine().toUpperCase().charAt(0);
			
			if(graph.haveNode(nodeName))
			{
				System.out.println(nodeName + " already exist!");
				return graph;
			}
			
			node = new Node(nodeName);
			graph.addNode(node);
			
			return graph;
			
		} catch (Exception e) {
			System.out.println("*** " + e.getMessage());
		}
		return graph;
	}
	
	public void setGraph(Graph graph){
		this.graph = graph;
	}
}