package graph;

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

		ArrayList<Edge> incidentEdges = new ArrayList<Edge>();

		for (Edge edge : edges) {
			ArrayList<Vertex> vertices = edge.getConnectedVertices();
			if (vertices.get(0).equals(v) || vertices.get(1).equals(v)) {
				incidentEdges.add(edge);
			}
		}
		return incidentEdges;
	}

	public boolean areAdjacent(Vertex u, Vertex v) {

		ArrayList<Edge> incidentEdges = incidentEdges(u);
		for (Edge edge : incidentEdges) {
			ArrayList<Vertex> vertices = edge.getConnectedVertices();
			if (vertices.get(0).equals(v) || vertices.get(1).equals(v)) {
				return true;
			}
		}
		return false;
	}

	// Replaces vertex v with vertex o
	public void replace(Vertex v, Vertex o) {
		
		ArrayList<Edge> incidentEdges = incidentEdges(v);
		for (Edge edge : incidentEdges) {
			ArrayList<Vertex> vertices = edge.getConnectedVertices();
			if(vertices.get(0).equals(v)) {
				edge.setConnectedVertices(o, vertices.get(1));
			}
			else if(vertices.get(1).equals(v)) {
				edge.setConnectedVertices(o, vertices.get(0));
			}
			else throw new CouldNotReplaceVertexException();
		}
		
	}

	// Replaces edge e with edge o
	public void replace(Edge e, Edge o) {

		ArrayList<Vertex> vertices = e.getConnectedVertices();

		// Ensures that the connections do not get altered
		o.setConnectedVertices(vertices.get(0), vertices.get(1));
		edges.remove(e);
		edges.add(o);

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
		o.setConnectedVertices(u, v);
		edges.add(o);
		return o;
	}

	public Edge removeEdge(Edge e) {
		edges.remove(e);
		return e;
	}

}

class CouldNotReplaceVertexException extends RuntimeException {
}
