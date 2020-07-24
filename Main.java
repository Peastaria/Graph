import Graph.*;
import java.util.*;
import java.io.*;

public class Main {
	static Graph graph = new Graph();
	
	public static void main(String[] args) {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		String[] creators = {"ExitCommand","LoadFileCommand","PlotGraphCommand","AddNodeCommand","AddEdgeCommand", "RunDijkstraCommand"};

		while (true) {
			try {
				System.out.println("0 = Exit, 1 = Load File, "
                        + "2 = Plot Graph, 3 = Add Node, 4 = Add Edge, 5 = Run Dijkstra");
				System.out.print("Enter option: ");
				String line = br.readLine();
				int option = Integer.parseInt(line);

				Command command = (Command)Class.forName(creators[option]).newInstance();
				command.setGraph(graph);
				graph = command.execute();
				
			} catch (Exception e) {
				System.out.println("*** " + e.getMessage());
			}
			
			System.out.println();
		}
	}
}