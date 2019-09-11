package graph;

import java.util.ArrayList;

public class Edge {

	// Pointer to itself
	private Edge thisEdge;

	// Connected vertices
	private Vertex vertex1;
	private Vertex vertex2;

	// Weight of the edge
	private int weight;

	public Edge(Edge thisEdge, int weight) {

		this.thisEdge = thisEdge;

		if (weight >= 0) {
			this.weight = weight;
		} else {
			throw new InvalidWeightException();
		}

	}

	public void setConnectedVertices(Vertex v1, Vertex v2) {
		this.vertex1 = v1;
		this.vertex2 = v2;
	}

	public ArrayList<Vertex> getConnectedVertices() {
		if (vertex1 != null && vertex2 != null) {
			ArrayList<Vertex> connectedVertices = new ArrayList<Vertex>();
			connectedVertices.add(this.vertex1);
			connectedVertices.add(this.vertex2);
			return connectedVertices;
		}
		throw new VerticesNotDefinedException();
	}

	public Edge element() {
		return thisEdge;
	}

}

class InvalidWeightException extends RuntimeException {
}

class VerticesNotDefinedException extends RuntimeException {
}