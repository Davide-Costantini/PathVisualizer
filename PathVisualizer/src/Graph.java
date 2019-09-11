import java.util.ArrayList;

public class Graph {

	private int numEdges;
	private int numVertices;
	ArrayList<Edge> edges;
	ArrayList<Vertex> vertices;

	public Graph() {

		numEdges = 0;
		numVertices = 0;
		edges = new ArrayList<Edge>();
		vertices = new ArrayList<Vertex>();

	}

	public int numEdges() {
		return numEdges;
	}

	public int numVertices() {
		return numVertices;
	}

	public ArrayList<Edge> edges() {
		return edges;
	}

	public ArrayList<Vertex> vertices() {
		return vertices;
	}

	public ArrayList<Edge> incidentEdges(Vertex v) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean areAdjacent(Vertex u, Vertex v) {
		// TODO Auto-generated method stub
		return false;
	}

	public Vertex replace(Vertex v, Vertex o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Edge replace(Edge e, Edge o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vertex insertVertex(Vertex o) {
		vertices.add(o);
		return o;
	}

	public Vertex removeVertex(Vertex v) {
		vertices.remove(v);
		return v;
	}

	public Edge insertEdge(Vertex u, Vertex v, Edge o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Edge removeEdge(Edge e) {
		// TODO Auto-generated method stub
		return null;
	}

}
