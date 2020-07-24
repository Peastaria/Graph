package Graph;

import java.io.*;
import java.util.*;

public class Graph {
    Vector<Node> nodes;

    public Graph(){
        nodes = new Vector<Node>();
    }

    public Graph(Vector<Node> nodes){
        this.nodes = nodes;
    }

    public Vector<Node> getNodes() {
        return this.nodes;
    }

    public void setNodes(Vector<Node> nodes) {
        this.nodes = nodes;
    }

    public Node getNode(char nodeName){
        for (int i = 0; i < nodes.size(); i++){
            if (nodes.elementAt(i).getName() == nodeName)
                return nodes.elementAt(i);
        }
        System.out.println(nodeName + ", do not exist in the graph. Cannot be retrived.");
        return null;
    }
    
    public void addNode(Node node){
        nodes.add(node);
    }

    public void addEdge(char nodeName, Edge edge){
        getNode(nodeName).addEdge(edge);
    }

    //Return of a String of Adjacency Matrix of the Graph
    public String toString(){
        int adjMartix[][] = new int[nodes.size()][nodes.size()];
        String output = " ";

        for (int i = 0; i < nodes.size(); i++){
            output += nodes.elementAt(i).getName() + " ";
        }
        output += "\n";

        for (int i = 0; i < nodes.size(); i++){
            output += nodes.elementAt(i).getName();
            for( int j = 0; j < nodes.size(); j++){
                adjMartix[i][j] = nodes.elementAt(i).getDistance(nodes.elementAt(j));
                output += adjMartix[i][j];
                output += " ";
            }
            output += "\n";
        }

        return output;
    }

    //Get the 2D-Array on the Adjacency Matrix of the Graph
    public int[][] getAdjMatrix(){
        int[][] adjMartix = new int[nodes.size()][nodes.size()];

        for (int i = 0; i < nodes.size(); i++){
            for( int j = 0; j < nodes.size(); j++){
                adjMartix[i][j] = nodes.elementAt(i).getDistance(nodes.elementAt(j));
            }
        }

        return adjMartix;
    }

    //Plot the Adjacency Matrix
    public void plotAdjMartix(){
        System.out.print("  ");

        for (int i = 0; i < nodes.size(); i++)
            System.out.printf("%8c", nodes.elementAt(i).getName());

        System.out.printf("\n");

        for (int i = 0; i < nodes.size(); i++){
            System.out.print(nodes.elementAt(i).getName() + " " );
            for( int j = 0; j < nodes.size(); j++){
                System.out.printf("%8d", nodes.elementAt(i).getDistance(nodes.elementAt(j)));
            }
            System.out.printf("\n");
        }
        //return Arrays.deepToString(adjMartix).replace("],","\n").replace(",","\t| ").replaceAll("[\\[\\]]", " ");
    }

    //Check whether two node is connected together
    public boolean isConnected(char from, char to){
        Vector<Edge> edges;
        Edge currentEdge;

        for (int i = 0; i < nodes.size(); i++){
            edges = nodes.elementAt(i).getEdges();
            for (int j = 0; i < edges.size(); i++){
                currentEdge =  edges.elementAt(j);
                if ( (currentEdge.getFrom().getName() == from && currentEdge.getTo().getName() == to) || (currentEdge.getFrom().getName() == to && currentEdge.getTo().getName() == from) )
                    return true;
            }
        }

        return false;
    }

    //Check whether the graph has certain node
    public boolean haveNode(char nodeName){
        for (int i = 0; i < nodes.size(); i++){
            if (nodes.elementAt(i).getName() == nodeName)
                return true;
        }

        return false;
    }

}