import Graph.*;
import java.util.*;
import java.io.*;

public class PlotGraphCommand implements Command{
	Graph graph;
	
	public Graph execute()
	{
		//System.out.println(graph.toString());
		graph.plotAdjMartix();
		return graph;
	}
	
	public void setGraph(Graph graph){
		this.graph = graph;
	}
}