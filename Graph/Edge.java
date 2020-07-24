package Graph;

public class Edge{
    private Node from;
    private Node to;
    private int distance;

    public Edge() {
    }

    public Edge(Node from, Node to, int distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Node getFrom() {
        return this.from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public Node getTo() {
        return this.to;
    }

    public void setTo(Node to) {
        this.to = to;
    }

}