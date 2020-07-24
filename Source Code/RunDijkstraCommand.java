import Graph.*;
import java.util.*;
import java.io.*;

public class RunDijkstraCommand implements Command{
	Graph graph;
	
	public Graph execute()
	{
		Scanner scanner = new Scanner(System.in);
		Dijkstra dijkstra = new Dijkstra();
		for (int i = 0; i < graph.getNodes().size(); i++){
			dijkstra.runDijkstra(graph.getNodes(), graph.getAdjMatrix(), i);
		}

		return graph;
	}
	
	public void setGraph(Graph graph){
		this.graph = graph;
	}
}