import Graph.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class LoadFileCommand implements Command{
	Graph graph;
	
	public class Input {
        public char nodeName;

        List<Character> neighborLists = new ArrayList<Character>();

        List<Integer> distances = new ArrayList<Integer>();
	}

	public Graph execute()
	{
		try {

            // check whether file exists
            // if not, go to catch block
            File file = new File("sample.graph");
            Scanner sc = new Scanner(file);  

            // loop counter
            int i = 0, j, k;
            
            ArrayList<Input> inputs = new ArrayList<Input>();

            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                // create an array list object
                inputs.add(new Input());
                System.out.println(currentLine);
                
                // set node name
                inputs.get(i).nodeName = currentLine.charAt(0);
                
                // shorten the length of current line
                currentLine = currentLine.substring(3);

                // initaialize loop counter
                j = 0; k = 0;

                // perform inner line checking
                Scanner lineScanner = new Scanner(currentLine);               
                while (lineScanner.hasNext()) {
                    String token = lineScanner.next(); // token format: c:d  where c=nodeName, d=lengthCost

                    // add one neighbor to neighborLists
                    inputs.get(i).neighborLists.add(j, token.charAt(0));
                    //System.out.println(i + ": " + j + ": " + inputs.get(i).neighborLists);

                    // add correspond length cost to distances
                    inputs.get(i).distances.add(k, Integer.parseInt(token.substring(2)));

                    j++;
                    k++;
                }
                i++;
            } 

            /* //checking
            for (int x = 0; x < i; x++) {
                System.out.println("Node name: " + inputs.get(x).nodeName);
                System.out.println("Neighbors: " + inputs.get(x).neighborLists);
                System.out.println("Costs: " + inputs.get(x).distances);
                System.out.println("-------------------------------");
			}*/
			
            //insect graph
            Graph graph = new Graph();

			for (int x = 0; x < i; x++) {
                Node node = new Node(Character.toUpperCase(inputs.get(x).nodeName));
				graph.addNode(node);
			}
			
			for (int x = 0; x < i; x++) {
				Node node = graph.getNode(Character.toUpperCase(inputs.get(x).nodeName));
				for (int s = 0; s < inputs.get(x).neighborLists.size(); s++)
				{
                    Node fromNode = node;
					Node toNode = graph.getNode(Character.toUpperCase(inputs.get(x).neighborLists.get(s)));
						
					Edge edge = new Edge(fromNode, toNode, inputs.get(x).distances.get(s));
					Edge edgeReverse = new Edge(toNode, fromNode, inputs.get(x).distances.get(s));
						
					graph.addEdge(fromNode.getName() , edge);
					graph.addEdge(toNode.getName(), edgeReverse);
				}
            }
            
            setGraph(graph);
             
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Failed to read file...");
		}
		return graph;
	}
	
	public void setGraph(Graph graph){
		this.graph = graph;
	}
}