package Graph;

import java.util.*;

public class Node {
    Vector<Edge> edges;
    char name;

    public Node(char name) {
        this.name = name;
        edges = new Vector<Edge>();
    }

    public char getName() {
        return this.name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public int getDegree() {
        return edges.size();
    }

    public void addEdge(Edge edge){
        edges.add(edge);
    }

    public void removeEdge(Edge edge){
        edges.remove(edge);
    }

    public Vector<Edge> getEdges(){
        return edges;
    }

    /*
    public boolean isNeighbor(Node node) {
        //System.out.println(node.getName());
        for(int i = 0; i < edges.size(); i++){
            if(((Edge)edges.elementAt(i)).getFrom().getName() == this.name && ((Edge)edges.elementAt(i)).getTo() == node)
                return true;

        }
        return false;
    }*/

    //Get the distance with certain node
    public int getDistance(Node node) {
        if (this.name == node.getName())
                return 0;
        for(int i = 0; i < edges.size(); i++){
            if(edges.elementAt(i).getTo().getName() == node.getName())
                return edges.elementAt(i).getDistance();
        }

        return 0; // return 0 or -1, not a edge of that node (Not connected)
    }

}