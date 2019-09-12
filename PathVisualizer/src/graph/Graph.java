package graph;

import java.util.ArrayList;

public class Graph<T> {

	private int numEdges;
	private int numVertices;
	ArrayList<Edge<T>> edges;
	ArrayList<Vertex<T>> vertices;

	public Graph() {

		numEdges = 0;
		numVertices = 0;
		edges = new ArrayList<Edge<T>>();
		vertices = new ArrayList<Vertex<T>>();

	}

	public int numEdges() {
		return numEdges;
	}

	public int numVertices() {
		return numVertices;
	}

	public ArrayList<Edge<T>> edges() {
		return edges;
	}

	public ArrayList<Vertex<T>> vertices() {
		return vertices;
	}

	public ArrayList<Edge<T>> incidentEdges(Vertex<T> v) {

		ArrayList<Edge<T>> incidentEdges = new ArrayList<Edge<T>>();

		for (Edge<T> edge : edges) {
			ArrayList<Vertex<T>> vertices = edge.getConnectedVertices();
			if (vertices.get(0).equals(v) || vertices.get(1).equals(v)) {
				incidentEdges.add(edge);
			}
		}
		return incidentEdges;
	}

	public boolean areAdjacent(Vertex<T> u, Vertex<T> v) {

		ArrayList<Edge<T>> incidentEdges = incidentEdges(u);
		for (Edge<T> edge : incidentEdges) {
			ArrayList<Vertex<T>> vertices = edge.getConnectedVertices();
			if (vertices.get(0).equals(v) || vertices.get(1).equals(v)) {
				return true;
			}
		}
		return false;
	}

	// Replaces vertex v with vertex o
	public void replace(Vertex<T> v, Vertex<T> o) {

		ArrayList<Edge<T>> incidentEdges = incidentEdges(v);
		for (Edge<T> edge : incidentEdges) {
			ArrayList<Vertex<T>> vertices = edge.getConnectedVertices();
			if (vertices.get(0).equals(v)) {
				edge.setConnectedVertices(o, vertices.get(1));
			} else if (vertices.get(1).equals(v)) {
				edge.setConnectedVertices(o, vertices.get(0));
			} else
				throw new CouldNotReplaceVertexException();
		}

	}

	// Return the vertex on the other side of the edge
	public Vertex<T> opposite(Vertex<T> v, Edge<T> e) {

		ArrayList<Vertex<T>> vertices = e.getConnectedVertices();
		if (vertices.get(0).equals(v)) {
			return vertices.get(1);
		} else if (vertices.get(1).equals(v)) {
			return vertices.get(0);
		}
		throw new VertexAndEdgeNotConnectedException();
	}

	// Replaces edge e with edge o
	public void replace(Edge<T> e, Edge<T> o) {

		ArrayList<Vertex<T>> vertices = e.getConnectedVertices();

		// Ensures that the connections do not get altered
		o.setConnectedVertices(vertices.get(0), vertices.get(1));
		edges.remove(e);
		edges.add(o);

	}

	public Vertex<T> insertVertex(Vertex<T> o) {
		numVertices++;
		vertices.add(o);
		return o;
	}

	public Vertex<T> removeVertex(Vertex<T> v) {
		boolean wasRemoved = vertices.remove(v);
		if (wasRemoved) {
			numVertices--;
		}
		return v;
	}

	// Insert a new edge between vertices u and v, does nothing and return null
	// if the two vertices were already connected
	public Edge<T> insertEdge(Vertex<T> u, Vertex<T> v, Edge<T> o) {
		numEdges++;
		if (!areAdjacent(u, v)) {
			o.setConnectedVertices(u, v);
			edges.add(o);
			return o;
		}
		return null;
	}

	public Edge<T> removeEdge(Edge<T> e) {
		boolean wasRemoved = edges.remove(e);
		if (wasRemoved) {
			numEdges--;
		}
		return e;
	}

}

class VertexAndEdgeNotConnectedException extends RuntimeException {
}

class CouldNotReplaceVertexException extends RuntimeException {
}
